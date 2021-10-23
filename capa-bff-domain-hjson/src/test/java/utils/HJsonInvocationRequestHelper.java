package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import java.util.Map;

public class HJsonInvocationRequestHelper {

    private HJsonInvocationRequest request;

    public static HJsonInvocationRequestHelper builder(String appId, String methodName) {
        HJsonInvocationRequestHelper builder = new HJsonInvocationRequestHelper();
        HJsonInvocationRequest request = new HJsonInvocationRequest();
        request.setAppId(appId);
        request.setMethod(methodName);
        builder.request = request;
        return builder;
    }

    public HJsonInvocationRequestHelper buildMetadata(String metadata) {
        Map<String, String> map = JSONObject.parseObject(metadata, new TypeReference<>() {});
        this.request.setMetadata(map);
        return this;
    }

    public HJsonInvocationRequestHelper buildData(String data) {
        this.request.setData(JSON.parseObject(data));
        return this;
    }

    public HJsonInvocationRequestHelper buildResponseData(String responseData) {
        Map<String, String> map = JSONObject.parseObject(responseData, new TypeReference<>() {});
        this.request.setResponseDataFormat(map);
        return this;
    }

    public HJsonInvocationRequest build() {
        return this.request;
    }

}
