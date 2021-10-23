package group.rxcloud.capa.bff.hjson.allocate;

import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationResponse;
import group.rxcloud.capa.bff.invoke.Invoke;
import group.rxcloud.capa.rpc.CapaRpcClient;
import group.rxcloud.cloudruntimes.domain.core.invocation.HttpExtension;
import group.rxcloud.cloudruntimes.utils.TypeRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.concurrent.*;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/22 13:56
 */
@Component
@Scope("request")
public final class ServiceAllocate implements Invoke<HJsonInvocationRequest, HJsonInvocationResponse> {
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private CapaRpcClient capaRpcClient;

    private final ThreadLocal<ConcurrentHashMap<String, List<HJsonInvocationRequest>>> localDynamicParamsMapping;

    private final ThreadLocal<ConcurrentHashMap<HJsonInvocationRequest, Integer>> serviceDynamicRequestParamCount;

    private final ThreadLocal<ConcurrentHashMap<String, String>> paramsSet;

    private final ThreadLocal<CopyOnWriteArrayList<HJsonInvocationResponse>> responseList;

    private final ThreadLocal<CountDownLatch> cyclicBarrierThreadLocal;

    @Override
    public List<HJsonInvocationResponse> invoke(List<HJsonInvocationRequest> invocationList) {
        clearThreadLocal();
        CountDownLatch cy = new CountDownLatch(invocationList.size());
        cyclicBarrierThreadLocal.set(cy);
        for (HJsonInvocationRequest request : invocationList) {
            allocateService(request);
        }
        try {
            cy.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<HJsonInvocationResponse> res = responseList.get();

        return res;
    }

    private void clearThreadLocal() {
        cyclicBarrierThreadLocal.remove();
        localDynamicParamsMapping.remove();
        serviceDynamicRequestParamCount.remove();
        paramsSet.remove();
        responseList.remove();
    }

    public interface TaskService {


        Map<String, String> params();

        void replaceParam(String key, String value);

        boolean sync();
    }

    public ServiceAllocate() {
        localDynamicParamsMapping = new ThreadLocal<>();

        serviceDynamicRequestParamCount = new ThreadLocal<>();

        paramsSet = new ThreadLocal<>();

        responseList = new ThreadLocal<>();

        cyclicBarrierThreadLocal = new ThreadLocal<>();

    }

    private void threadLocalReCheck() {
        if (localDynamicParamsMapping.get() == null) {
            ConcurrentHashMap<String, List<HJsonInvocationRequest>> tmpMap = new ConcurrentHashMap<>();
            localDynamicParamsMapping.set(tmpMap);
        }
        if (serviceDynamicRequestParamCount.get() == null) {
            ConcurrentHashMap<HJsonInvocationRequest, Integer> tmpMap2 = new ConcurrentHashMap<>();
            serviceDynamicRequestParamCount.set(tmpMap2);
        }
        if (paramsSet.get() == null) {
            ConcurrentHashMap<String, String> tmpSet = new ConcurrentHashMap<>();
            paramsSet.set(tmpSet);
        }
        if (responseList.get() == null) {
            CopyOnWriteArrayList<HJsonInvocationResponse> re = new CopyOnWriteArrayList<>();
            responseList.set(re);
        }
    }

    public Mono allocateService(HJsonInvocationRequest taskService) {
        threadLocalReCheck();
        ConcurrentHashMap<String, List<HJsonInvocationRequest>> localParamsServiceMapping = localDynamicParamsMapping.get();
        ConcurrentHashMap<HJsonInvocationRequest, Integer> serviceParamCountMapping = serviceDynamicRequestParamCount.get();
        ConcurrentHashMap<String, String> parasmKeyValueMapping = paramsSet.get();
        CopyOnWriteArrayList<HJsonInvocationResponse> reList = responseList.get();

        Map<String, String> params = taskService.params();
        if (CollectionUtils.isEmpty(params)) {
            return null;
        }
        boolean flag = false;
        Set<Map.Entry<String, String>> entries = params.entrySet();
        for (Map.Entry<String, String> param : entries) {
            //^#{[.]+}$
            if (param != null && !StringUtils.isEmpty(param.getValue()) && param.getValue().matches("^#\\{.+}$")) {
                if (paramsSet.get().containsKey(param.getKey())) {
                    taskService.replaceParam(param.getKey(), param.getValue());
                    continue;
                }
                flag = true;
                ConcurrentHashMap<String, List<HJsonInvocationRequest>> stringListHashMap = localDynamicParamsMapping.get();
                if (stringListHashMap.get(param.getKey()) == null) {
                    List<HJsonInvocationRequest> list = new ArrayList<>();
                    list.add(taskService);
                    Integer count = serviceDynamicRequestParamCount.get().get(taskService);
                    serviceDynamicRequestParamCount.get().put(taskService, count == null ? 1 : count + 1);
                    stringListHashMap.put(param.getKey(), list);
                } else if (!stringListHashMap.get(param.getKey()).contains(taskService)) {
                    Integer count = serviceDynamicRequestParamCount.get().get(taskService);
                    serviceDynamicRequestParamCount.get().put(taskService, count == null ? 1 : count + 1);
                    stringListHashMap.get(param.getKey()).add(taskService);
                }

            }
            ;
        }
        if (flag) {
            return null;
        }
        // 扫描request是否含有 #{} 这种参数，有的话需要放在另外一个地方等待唤醒
        CountDownLatch cd = cyclicBarrierThreadLocal.get();
        Mono<HashMap> responseMono = capaRpcClient.invokeMethod(
                taskService.getAppId(),
                taskService.getMethod(),
                taskService.getData(),
                HttpExtension.POST,
                taskService.getMetaData(),
                TypeRef.get(HashMap.class));
        if (taskService.sync()) {
            cd.countDown();
            HashMap block = responseMono.block();
            reList.add(new HJsonInvocationResponse(taskService, block));
        } else {
            responseMono.doOnSuccess((s) -> {
                cd.countDown();
                reList.add(new HJsonInvocationResponse(taskService, s));
            });

        }


        return null;


    }
}