package group.rxcloud.capa.bff.hjson.outbound;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.domain.Context;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationResponse;
import group.rxcloud.capa.bff.outbound.Outbound;

import java.util.List;

public class HJsonOutbound implements Outbound<
        JSONObject,
        HJsonInvocationRequest,
        HJsonInvocationResponse> {

    @Override
    public JSONObject outbound(List<HJsonInvocationRequest> hJsonInvocationRequests, List<HJsonInvocationResponse> hJsonInvocationResponses, Context context) {
        return null;
    }
}
