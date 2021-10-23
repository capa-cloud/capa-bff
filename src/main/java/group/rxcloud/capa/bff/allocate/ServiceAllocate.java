package group.rxcloud.capa.bff.allocate;

import group.rxcloud.capa.bff.domain.InvocationResquest;
import group.rxcloud.capa.rpc.CapaRpcClient;
import group.rxcloud.cloudruntimes.domain.core.invocation.HttpExtension;
import group.rxcloud.cloudruntimes.utils.TypeRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/22 13:56
 */
@Component
public final class ServiceAllocate {
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private CapaRpcClient capaRpcClient;

    private final ThreadLocal<HashMap<String, List<TaskService>>> localDynamicParamsMapping;

    private final ThreadLocal<HashMap<TaskService,Integer>> serviceDynamicRequestParamCount;

    private final ThreadLocal<HashMap<String,String>> paramsSet;

    public interface TaskService{

        InvocationResquest generateDomainDto();

        Map<String, String> params();

        void replaceParam(String key, String value);

        boolean sync();
    }

    public ServiceAllocate(){
        localDynamicParamsMapping = new ThreadLocal<>();

        serviceDynamicRequestParamCount = new ThreadLocal<>();

        paramsSet = new ThreadLocal<>();

    }

    private void threadLocalReCheck(){
        if (localDynamicParamsMapping.get()==null){
            HashMap<String, List<TaskService>> tmpMap = new HashMap<>();
            localDynamicParamsMapping.set(tmpMap);
        }
        if (serviceDynamicRequestParamCount.get()==null){
            HashMap<TaskService, Integer> tmpMap2 = new HashMap<>();
            serviceDynamicRequestParamCount.set(tmpMap2);
        }
        if (paramsSet.get()==null){
            HashMap<String, String> tmpSet = new HashMap<>();
            paramsSet.set(tmpSet);
        }
    }

    public Mono allocateService(TaskService taskService){
        threadLocalReCheck();

        Map<String,String> params = taskService.params();
        if (CollectionUtils.isEmpty(params)){
            return null;
        }
        boolean flag = false;
        Set<Map.Entry<String, String>> entries = params.entrySet();
        for (Map.Entry<String, String> param:entries){
            //^#{[.]+}$
            if (param!=null && param.getValue().matches("^#\\{.+}$")){
                if (paramsSet.get().containsKey(param.getKey())){
                    taskService.replaceParam(param.getKey(),param.getValue());
                    continue;
                }
                flag = true;
                HashMap<String, List<TaskService>> stringListHashMap = localDynamicParamsMapping.get();
                if (stringListHashMap.get(param.getKey())==null){
                    List<TaskService> list = new ArrayList<>();
                    list.add(taskService);
                    Integer count = serviceDynamicRequestParamCount.get().get(taskService);
                    serviceDynamicRequestParamCount.get().put(taskService,count==null?1:count+1);
                    stringListHashMap.put(param.getKey(),list);
                }else if (!stringListHashMap.get(param.getKey()).contains(taskService)){
                    Integer count = serviceDynamicRequestParamCount.get().get(taskService);
                    serviceDynamicRequestParamCount.get().put(taskService,count==null?1:count+1);
                    stringListHashMap.get(param.getKey()).add(taskService);
                }

            };
        }
        if (flag){
            return null;
        }
        InvocationResquest invocationResquest = taskService.generateDomainDto();
        // 扫描request是否含有 #{} 这种参数，有的话需要放在另外一个地方等待唤醒
        if (taskService.sync()){
            Mono<HashMap> responseMono = capaRpcClient.invokeMethod(
                    invocationResquest.getAppId(),
                    invocationResquest.getMethod(),
                    invocationResquest.getData(),
                    HttpExtension.POST,
                    TypeRef.get(HashMap.class));

            return responseMono;

        }
        return null;



    }
}
