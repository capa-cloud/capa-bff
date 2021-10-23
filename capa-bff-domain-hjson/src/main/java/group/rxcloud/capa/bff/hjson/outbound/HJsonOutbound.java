package group.rxcloud.capa.bff.hjson.outbound;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.domain.Context;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationResponse;
import group.rxcloud.capa.bff.outbound.Outbound;
import lombok.Data;

import java.util.List;
import java.util.Map;

public class HJsonOutbound implements Outbound<
        JSONObject,
        HJsonInvocationRequest,
        HJsonInvocationResponse> {

    @Data
    private static class HJsonMappingEntity {

        private String appId;
        private String method;

        private JSONObject responseData;
        private  Map<String, String> responseDataFormat;
    }

    @Override
    public JSONObject outbound(List<HJsonInvocationRequest> hJsonInvocationRequests, List<HJsonInvocationResponse> hJsonInvocationResponses, Context context) {


        for (HJsonInvocationResponse invocationResponse : hJsonInvocationResponses) {
            JSONObject responseData = invocationResponse.getData();
        }

        for (HJsonInvocationRequest invocationRequest : hJsonInvocationRequests) {
            final JSONObject requestData = invocationRequest.getData();
            final Map<String, String> responseDataFormat = invocationRequest.getResponseDataFormat();
        }


        return null;
    }
}
