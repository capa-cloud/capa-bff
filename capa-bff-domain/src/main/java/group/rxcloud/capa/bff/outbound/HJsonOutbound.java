package group.rxcloud.capa.bff.outbound;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.domain.Context;
import group.rxcloud.capa.bff.domain.DefaultContext;
import group.rxcloud.capa.bff.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.domain.HJsonInvocationResponse;
import group.rxcloud.capa.bff.json.*;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class HJsonOutbound implements Outbound<
        JSONObject,
        HJsonInvocationRequest,
        HJsonInvocationResponse> {

    @Data
    @Builder
    private static class HJsonMappingEntity {

        private String appId;
        private String method;

        private JSONObject requestData;
        private JSONObject responseData;
        private Map<String, String> responseDataFormat;

        String generateKey() {
            return this.appId.toLowerCase() + "#" + this.method.toLowerCase();
        }
    }

    @Override
    public JSONObject outbound(List<HJsonInvocationRequest> hJsonInvocationRequests,
                               List<HJsonInvocationResponse> hJsonInvocationResponses,
                               Context context) {
        log.info("[HJsonOutbound] start outbound");
        // 成功的Map：有响应体Response
        Map<String, HJsonMappingEntity> successEntityMap = new ConcurrentHashMap<>();
        // 失败的Map：只有Request，没有Response
        Map<String, HJsonMappingEntity> failureEntityMap = new ConcurrentHashMap<>();

        // 将响应体集合放入Map中：有响应体即视为成功
        initResponseEntitiesToMap(hJsonInvocationResponses, successEntityMap);

        // 将请求体集合更新到Map中：只有请求体没有响应体，则视为失败
        initRequestEntitiesToBothMap(hJsonInvocationRequests, successEntityMap, failureEntityMap);

        // 将Map<路径，值>转换为Map<别名，值>
        Map<String, Object> aliasValueMap = generateAliasValueMap(successEntityMap);

        // 将Map<别名，值>渲染为JSON结构
        JSONObject responseJsonObject = generateJsonObjectFromPathMap(aliasValueMap);

        // 将失败的请求，生成JSONArray
        JSONArray failureResponseJsonArray = generateFailureRequests(failureEntityMap);

        JSONObject response = new JSONObject();
        response.put("body", responseJsonObject);
        response.put("errors", failureResponseJsonArray);
        log.info("[HJsonOutbound] end outbound");
        return response;
    }

    private JSONArray generateFailureRequests(Map<String, HJsonMappingEntity> failureEntityMap) {
        JSONArray failures = new JSONArray();
        for (Map.Entry<String, HJsonMappingEntity> failureRequest : failureEntityMap.entrySet()) {
            JSONObject failure = new JSONObject();
            HJsonMappingEntity failureRequestValue = failureRequest.getValue();
            String appId = failureRequestValue.getAppId();
            String method = failureRequestValue.getMethod();
            JSONObject requestData = failureRequestValue.getRequestData();
            Map<String, String> responseDataFormat = failureRequestValue.getResponseDataFormat();

            failure.put("appId", appId);
            failure.put("method", method);
            failure.put("request", requestData);
            failure.put("response", responseDataFormat);

            failures.add(failure);
        }
        return failures;
    }

    private Map<String, Object> generateAliasValueMap(Map<String, HJsonMappingEntity> successEntityMap) {
        Map<String, Object> aliasValueMap = new ConcurrentHashMap<>(successEntityMap.size());
        for (Map.Entry<String, HJsonMappingEntity> entry : successEntityMap.entrySet()) {
            final HJsonMappingEntity hJsonMappingEntity = entry.getValue();

            final JSONObject responseData = hJsonMappingEntity.getResponseData();
            final Map<String, String> responseDataFormat = hJsonMappingEntity.getResponseDataFormat();

            for (Map.Entry<String, String> aliasEntry : responseDataFormat.entrySet()) {
                final String path = aliasEntry.getKey();
                final String alias = aliasEntry.getValue();

                // 特殊路径处理
                boolean specialAliasValueMap = this.generateSpecialAliasValueMap(aliasValueMap, responseData, path, alias);
                if (specialAliasValueMap) {
                    continue;
                }

                // 根据路径获取对应的值
                Object aliasValue = JsonValueMapper.findValueByPointPath(responseData, path);
                // 生成Map<别名，值>
                aliasValueMap.put(alias, aliasValue);
            }
        }
        return aliasValueMap;
    }

    private boolean generateSpecialAliasValueMap(Map<String, Object> aliasValueMap, JSONObject responseData, String path, String alias) {
        if ("*".equals(path)) {
            aliasValueMap.put(alias, responseData);
            return true;
        }
        return false;
    }

    private void initRequestEntitiesToBothMap(List<HJsonInvocationRequest> hJsonInvocationRequests, Map<String, HJsonMappingEntity> entityMap, Map<String, HJsonMappingEntity> failureEntityMap) {
        for (HJsonInvocationRequest invocationRequest : hJsonInvocationRequests) {
            final String appId = invocationRequest.getAppId();
            final String method = invocationRequest.getMethod();
            final JSONObject requestData = invocationRequest.getData();
            final Map<String, String> responseDataFormat = invocationRequest.getResponseDataFormat();

            HJsonMappingEntity hJsonMappingEntity = HJsonMappingEntity.builder()
                    .appId(appId)
                    .method(method)
                    .requestData(requestData)
                    .responseDataFormat(responseDataFormat)
                    .build();

            String key = hJsonMappingEntity.generateKey();
            // 若已经存在响应体对象，则更新值
            if (entityMap.containsKey(key)) {
                HJsonMappingEntity mappingEntity = entityMap.get(key);
                mappingEntity.setResponseDataFormat(hJsonMappingEntity.getResponseDataFormat());
            } else {
                // 如果不存在响应体值，则视为失败
                failureEntityMap.putIfAbsent(key, hJsonMappingEntity);
            }
        }
    }

    private void initResponseEntitiesToMap(List<HJsonInvocationResponse> hJsonInvocationResponses, Map<String, HJsonMappingEntity> entityMap) {
        for (HJsonInvocationResponse invocationResponse : hJsonInvocationResponses) {
            final String appId = invocationResponse.getAppId();
            final String method = invocationResponse.getMethod();
            final JSONObject responseData = invocationResponse.getData();

            HJsonMappingEntity hJsonMappingEntity = HJsonMappingEntity.builder()
                    .appId(appId)
                    .method(method)
                    .responseData(responseData)
                    .build();

            String key = hJsonMappingEntity.generateKey();
            entityMap.putIfAbsent(key, hJsonMappingEntity);
        }
    }

    /**
     * 将{@code <user.id, 1>}格式的Map解析为JSON格式的Obj
     *
     * @param aliasValueMap {@code <user.id, 1>} key=别名路径, value=值
     */
    private JSONObject generateJsonObjectFromPathMap(Map<String, Object> aliasValueMap) {
        JSONObject responseBody = new JSONObject();
        if (aliasValueMap == null || aliasValueMap.isEmpty()) {
            return responseBody;
        }

        // 遍历每个<别名路径，值>的Entry
        for (Map.Entry<String, Object> aliasValues : aliasValueMap.entrySet()) {
            final String aliasPath = aliasValues.getKey();
            final Object aliasValue = aliasValues.getValue();

            // 将别名路径解析为路径数组：user.id -> [user, id]
            String[] valueByPointPath = JsonValueMapper.findValueByPointPath(aliasPath);
            if (valueByPointPath == null || valueByPointPath.length == 0) {
                continue;
            }

            // 只有一个路径：直接添加到根节点
            if (valueByPointPath.length == 1) {
                // 当前的路径节点key
                final String jsonKey = valueByPointPath[0];
                responseBody.put(jsonKey, aliasValue);
            } else {
                // 有多个路径：循环遍历，构建层级关系
                // 当前遍历时的指针
                JSONObject point = null;
                // 遍历扫描JSON对象
                for (int i = 0; i < valueByPointPath.length; i++) {
                    // 当前的路径节点key
                    final String jsonKey = valueByPointPath[i];

                    // 起始路径：需要基于根节点进行绑定
                    if (i == 0) {
                        // 如果已经存在，更新指针为已存在节点
                        if (responseBody.get(jsonKey) != null) {
                            point = responseBody.getJSONObject(jsonKey);
                        } else {
                            // 如果不存在，在根节点创建一个新的node，并赋值给指针
                            point = new JSONObject();
                            responseBody.put(jsonKey, point);
                        }
                    } else if (i < valueByPointPath.length - 1) {
                        // 此时，该次遍历的根节点已经指向point指针，不需要再向根节点进行绑定
                        // 中间路径：建立不存在的K:V关系
                        // 如果已经存在该路径
                        if (point.get(jsonKey) != null) {
                            // 如果已经存在，更新指针
                            point = point.getJSONObject(jsonKey);
                        } else {
                            // 如果不存在该路径，将该路径添加为JSONObject节点
                            JSONObject node = new JSONObject();
                            point.put(jsonKey, node);
                            // 创建新节点，更新指针
                            point = node;
                        }
                    } else {
                        // 终端路径：将值放入JSONObject
                        point.put(jsonKey, aliasValue);
                    }
                }
            }
        }

        return responseBody;
    }

    public static void main(String[] args) {
        HJsonOutbound hJsonOutbound = new HJsonOutbound();

        HashMap<String, Object> aliasValueMap = new HashMap<>();
        aliasValueMap.put("user.id", 1);
        aliasValueMap.put("user.name", "1234");
        aliasValueMap.put("user.address.ip", "111.222");
        aliasValueMap.put("user.address.city.name", "shanghai");
        aliasValueMap.put("city.address.id", "2");
        aliasValueMap.put("city.address.name", "shanghai");

        // -- generateJsonObjectFromPathMap

        JSONObject jsonObject = hJsonOutbound.generateJsonObjectFromPathMap(aliasValueMap);
        System.out.println(jsonObject);

        // -- outbound

        JSONObject request = new JSONObject();
        request.put("a", "1");
        HashMap<String, String> responseDataFormat = new HashMap<>();
        responseDataFormat.put("b.c.id", "user.id");
        responseDataFormat.put("b.c.name", "user.name");
        responseDataFormat.put("b.c.city.id", "user.address.city.id");
        responseDataFormat.put("b.c.city.name", "user.address.city.name");
        responseDataFormat.put("b.c.address.id", "city.address.id");
        responseDataFormat.put("b.c.address.name", "city.address.name");
        responseDataFormat.put("*", "12345#hello");

        HJsonInvocationRequest hJsonInvocationRequest = new HJsonInvocationRequest();
        hJsonInvocationRequest.setAppId("12345");
        hJsonInvocationRequest.setMethod("hello");
        hJsonInvocationRequest.setData(request);
        hJsonInvocationRequest.setResponseDataFormat(responseDataFormat);

        JSONObject address = new JSONObject();
        address.put("id", 123);
        address.put("name", "234");

        JSONObject city = new JSONObject();
        city.put("id", 12);
        city.put("name", "23");

        JSONObject c = new JSONObject();
        c.put("id", 1);
        c.put("name", "2");
        c.put("city", city);
        c.put("address", address);

        JSONObject b = new JSONObject();
        b.put("c", c);

        JSONObject a = new JSONObject();
        a.put("b", b);

        HJsonInvocationResponse hJsonInvocationResponse = new HJsonInvocationResponse();
        hJsonInvocationResponse.setAppId("12345");
        hJsonInvocationResponse.setMethod("hello");
        hJsonInvocationResponse.setData(a);

        HJsonInvocationRequest failure = new HJsonInvocationRequest();
        failure.setAppId("23456");
        failure.setMethod("failure");
        failure.setData(request);
        failure.setResponseDataFormat(responseDataFormat);

        JSONObject outbound = hJsonOutbound.outbound(
                List.of(hJsonInvocationRequest, failure),
                List.of(hJsonInvocationResponse),
                new DefaultContext());

        System.out.println(outbound);
    }
}
