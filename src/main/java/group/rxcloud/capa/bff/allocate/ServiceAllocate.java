package group.rxcloud.capa.bff.allocate;

import group.rxcloud.capa.bff.domain.InvocationResponse;
import group.rxcloud.capa.bff.domain.ServiceInvocationRequest;
import group.rxcloud.capa.bff.domain.ServiceInvocationResponse;
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
public final class ServiceAllocate implements Invoke<ServiceInvocationRequest, ServiceInvocationResponse> {
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private CapaRpcClient capaRpcClient;

    private final ThreadLocal<ConcurrentHashMap<String, List<ServiceInvocationRequest>>> localDynamicParamsMapping;

    private final ThreadLocal<ConcurrentHashMap<ServiceInvocationRequest, Integer>> serviceDynamicRequestParamCount;

    private final ThreadLocal<ConcurrentHashMap<String, String>> paramsSet;

    private final ThreadLocal<CopyOnWriteArrayList<ServiceInvocationResponse>> responseList;

    private final ThreadLocal<CountDownLatch> cyclicBarrierThreadLocal;

    @Override
    public List<ServiceInvocationResponse> invoke(List<ServiceInvocationRequest> invocationList) {
        clearThreadLocal();
        CountDownLatch cy = new CountDownLatch(invocationList.size());
        cyclicBarrierThreadLocal.set(cy);
        for (ServiceInvocationRequest request : invocationList) {
            allocateService(request);
        }
        try {
            cy.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<ServiceInvocationResponse> res = responseList.get();

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
            ConcurrentHashMap<String, List<ServiceInvocationRequest>> tmpMap = new ConcurrentHashMap<>();
            localDynamicParamsMapping.set(tmpMap);
        }
        if (serviceDynamicRequestParamCount.get() == null) {
            ConcurrentHashMap<ServiceInvocationRequest, Integer> tmpMap2 = new ConcurrentHashMap<>();
            serviceDynamicRequestParamCount.set(tmpMap2);
        }
        if (paramsSet.get() == null) {
            ConcurrentHashMap<String, String> tmpSet = new ConcurrentHashMap<>();
            paramsSet.set(tmpSet);
        }
        if (responseList.get() == null) {
            CopyOnWriteArrayList<ServiceInvocationResponse> re = new CopyOnWriteArrayList<>();
            responseList.set(re);
        }
    }

    public Mono allocateService(ServiceInvocationRequest taskService) {
        threadLocalReCheck();
        ConcurrentHashMap<String, List<ServiceInvocationRequest>> localParamsServiceMapping = localDynamicParamsMapping.get();
        ConcurrentHashMap<ServiceInvocationRequest, Integer> serviceParamCountMapping = serviceDynamicRequestParamCount.get();
        ConcurrentHashMap<String, String> parasmKeyValueMapping = paramsSet.get();
        CopyOnWriteArrayList<ServiceInvocationResponse> reList = responseList.get();

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
                ConcurrentHashMap<String, List<ServiceInvocationRequest>> stringListHashMap = localDynamicParamsMapping.get();
                if (stringListHashMap.get(param.getKey()) == null) {
                    List<ServiceInvocationRequest> list = new ArrayList<>();
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
            reList.add(new ServiceInvocationResponse(taskService, block));
        } else {
            responseMono.doOnSuccess((s) -> {
                cd.countDown();
                reList.add(new ServiceInvocationResponse(taskService, s));
            });

        }


        return null;


    }
}
