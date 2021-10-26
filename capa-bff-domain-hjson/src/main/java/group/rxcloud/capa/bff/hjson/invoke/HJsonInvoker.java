package group.rxcloud.capa.bff.hjson.invoke;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.domain.Context;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationResponse;
import group.rxcloud.capa.bff.hjson.json.JsonValueMapper;
import group.rxcloud.capa.bff.hjson.util.GraphUtil;
import group.rxcloud.capa.bff.hjson.util.InnerMethodUtil;
import group.rxcloud.capa.bff.invoke.Invoke;
import group.rxcloud.capa.rpc.CapaRpcClient;
import group.rxcloud.cloudruntimes.domain.core.invocation.HttpExtension;
import group.rxcloud.cloudruntimes.utils.TypeRef;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@Component
public final class HJsonInvoker implements Invoke<HJsonInvocationRequest, HJsonInvocationResponse> {

    @Autowired
    private CapaRpcClient capaRpcClient;

    @Override
    public List<HJsonInvocationResponse> invoke(List<HJsonInvocationRequest> invocationList, Context context) throws RuntimeException {
        log.info(String.format("title: invoke start  invocationList: %s",JSONObject.toJSONString(invocationList)));
        if (invocationList != null && invocationList.size() >= 10) {
            return new ArrayList<>();
        }
        new GraphUtil(invocationList).find();
        ConcurrentHashMap<String, List<HJsonInvocationRequest>> localParamsServiceMapping = new ConcurrentHashMap<>();
        ConcurrentHashMap<HJsonInvocationRequest, Integer> serviceParamCountMapping = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Object> parasmKeyValueMapping = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<HJsonInvocationResponse> reList = new CopyOnWriteArrayList<>();
        // 扫描request是否含有 #{} 这种参数，有的话需要放在另外一个地方等待唤醒
        CountDownLatch cd = new CountDownLatch(invocationList.size());
        for (HJsonInvocationRequest request : invocationList) {
            allocateService(request,localParamsServiceMapping,serviceParamCountMapping,parasmKeyValueMapping,reList,cd);
        }
        try {
            cd.await(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return reList;
    }

    public interface TaskService {
        /**
         * 替换参数
         * @param key -
         * @param value -
         */
        void replaceParam(String key, Object value);

        /**
         * 是否同步/异步
         * @return -
         */
        boolean sync();
    }


    private Mono allocateService(HJsonInvocationRequest taskService,
                                 ConcurrentHashMap<String, List<HJsonInvocationRequest>> localParamsServiceMapping,
                                 ConcurrentHashMap<HJsonInvocationRequest, Integer> serviceParamCountMapping,
                                 ConcurrentHashMap<String, Object> parasmKeyValueMapping,
                                 CopyOnWriteArrayList<HJsonInvocationResponse> reList,
                                 CountDownLatch cd){
        if (taskService.getData()==null){
            taskService.setData(new JSONObject());
        }
        Map<String, Object> requiredParams = taskService.getRequiredParams();
        if(requiredParams!=null){

            boolean flag = false;
            Set<Map.Entry<String, Object>> entries = requiredParams.entrySet();
            for (Map.Entry<String, Object> param : entries) {
                //^#{[.]+}$
                if (param != null && !StringUtils.isEmpty(param.getKey()) ) {
                    if (parasmKeyValueMapping.containsKey(param.getKey())) {
                        taskService.replaceParam(param.getKey(), parasmKeyValueMapping.get(param.getKey()));
                        continue;
                    }
                    flag = true;
                    ConcurrentHashMap<String, List<HJsonInvocationRequest>> stringListHashMap = localParamsServiceMapping;
                    if (stringListHashMap.get(param.getKey()) == null) {
                        List<HJsonInvocationRequest> list = new ArrayList<>();
                        list.add(taskService);
                        Integer count = serviceParamCountMapping.get(taskService);
                        serviceParamCountMapping.put(taskService, count == null ? 1 : count + 1);
                        stringListHashMap.put(param.getKey(), list);
                    } else if (!stringListHashMap.get(param.getKey()).contains(taskService)) {
                        Integer count = serviceParamCountMapping.get(taskService);
                        serviceParamCountMapping.put(taskService, count == null ? 1 : count + 1);
                        stringListHashMap.get(param.getKey()).add(taskService);
                    }

                }
            }
            if (flag) {
                return null;
            }
        }
        // 扫描request是否含有 #{} 这种参数，有的话需要放在另外一个地方等待唤醒
        Mono<byte[]> responseMono = capaRpcClient.invokeMethod(
                taskService.getAppId(),
                taskService.getMethod(),
                taskService.getData(),
                HttpExtension.POST,
                taskService.getMetadata(),
                TypeRef.BYTE_ARRAY);

        if (taskService.sync()) {

            JSONObject response = null;
            try {
                byte[] bytes = responseMono.block();
                response = generateResponseObj(bytes);
            } catch (Exception e) {
                log.error(String.format("title: invoke err  taskService: %s",JSONObject.toJSONString(taskService)),e);
                return null;
            }

            reList.add(new HJsonInvocationResponse(taskService, response));
            Map<String, String> responseDataFormat = taskService.getResponseDataFormat();
            if (responseDataFormat!=null && !responseDataFormat.isEmpty()){
                Set<String> strings = responseDataFormat.keySet();
                for (String path:strings){
                    String pathMappingName = responseDataFormat.get(path);
                    String nickName = "";
                    boolean method = false;
                    Object obj = JsonValueMapper.findValueByPointPath(response, path);

                    if (pathMappingName.contains("#{")){
                        nickName = pathMappingName.substring(pathMappingName.lastIndexOf("}")+1);
                        obj = InnerMethodUtil.runMethodAsStringBeforeConvert(pathMappingName,obj);
                    }else {
                        nickName = pathMappingName;
                    }
                    if (StringUtils.isEmpty(nickName)){
                        System.out.println(JSONObject.toJSONString(taskService)+"resp 中 " +path +"没有别名");
                        nickName = path;
                    }
                    // todo update nickname
                    responseDataFormat.put(path,nickName);
                    // 根据路径以及response对象，获取其value，然后将别名以及value映射放入paramsSet中
                    nickName = nickName==null?"":nickName;
                    obj = obj==null?new JSONObject():obj;
                    parasmKeyValueMapping.put(nickName,obj);
                    JsonValueMapper.replaceValueByRealPath(response,path,obj);
                    List<HJsonInvocationRequest> listTmp = localParamsServiceMapping.get(nickName);
                    localParamsServiceMapping.remove(nickName);
                    if (!CollectionUtils.isEmpty(listTmp)){
                        for (HJsonInvocationRequest re:listTmp){
                            Map<String, Object> pMap = new HashMap<>();
                            pMap.put(nickName,obj);
                            re.setData(JsonValueMapper.replaceValuesByParameters(re.getData(),pMap));
                            serviceParamCountMapping.put(re,serviceParamCountMapping.get(taskService)-1);
                            if (serviceParamCountMapping.get(re)==0){
                                allocateService(re,localParamsServiceMapping,serviceParamCountMapping,parasmKeyValueMapping,reList,cd);
                            }
                        }

                    }


                }
            }
            cd.countDown();
        } else {
            responseMono.doOnSuccess((bytes) -> {
                JSONObject response = generateResponseObj(bytes);

                reList.add(new HJsonInvocationResponse(taskService, response));
                Map<String, String> responseDataFormat = taskService.getResponseDataFormat();
                if (responseDataFormat!=null && !responseDataFormat.isEmpty()){
                    Set<String> strings = responseDataFormat.keySet();
                    for (String path:strings){
                        String pathMappingName = responseDataFormat.get(path);
                        String nickName = "";
                        // 根据路径以及response对象，获取其value，然后将别名以及value映射放入paramsSet中
                        Object obj = JsonValueMapper.findValueByPointPath(response, path);
                        if (pathMappingName.contains("#{")){
                            nickName = pathMappingName.substring(pathMappingName.lastIndexOf("}")+1);
                            obj = InnerMethodUtil.runMethodAsStringBeforeConvert(pathMappingName,obj);
                        }else {
                            nickName = pathMappingName;
                        }
                        if (StringUtils.isEmpty(nickName)){
                            System.out.println(JSONObject.toJSONString(taskService)+"resp 中 " +path +"没有别名");
                            nickName = path;
                        }
                        // 根据路径以及response对象，获取其value，然后将别名以及value映射放入paramsSet中
                        // todo update nickname
                        responseDataFormat.put(path,nickName);
                        nickName = nickName==null?"":nickName;
                        obj = obj==null?new JSONObject():obj;
                        parasmKeyValueMapping.put(nickName,obj);
                        JsonValueMapper.replaceValueByRealPath(response,path,obj);
                        List<HJsonInvocationRequest> listTmp = localParamsServiceMapping.get(nickName);
                        localParamsServiceMapping.remove(nickName);
                        if (!CollectionUtils.isEmpty(listTmp)){
                            for (HJsonInvocationRequest re:listTmp){
                                Map<String, Object> pMap = new HashMap<>();
                                pMap.put(nickName,obj);
                                re.setData(JsonValueMapper.replaceValuesByParameters(re.getData(),pMap));
                                serviceParamCountMapping.put(re,serviceParamCountMapping.get(taskService)-1);
                                if (serviceParamCountMapping.get(re)==0){
                                    allocateService(re,localParamsServiceMapping,serviceParamCountMapping,parasmKeyValueMapping,reList,cd);
                                }
                            }

                        }


                    }
                }
                cd.countDown();
            });

            responseMono.doOnError((s)->{
                s.printStackTrace();
                cd.countDown();

            });

        }


        return null;

    }

    private JSONObject generateResponseObj(byte[] block) {
        String responseStr = new String(block);
        JSONObject response = JSON.parseObject(responseStr);
        return response;
    }


}
