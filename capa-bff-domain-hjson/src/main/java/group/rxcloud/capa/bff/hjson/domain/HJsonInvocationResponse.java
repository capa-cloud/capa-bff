package group.rxcloud.capa.bff.hjson.domain;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.domain.InvocationResponse;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 11:53
 */
public class HJsonInvocationResponse extends InvocationResponse<JSONObject> {

    public HJsonInvocationResponse() {
    }

    public HJsonInvocationResponse(HJsonInvocationRequest request, JSONObject data) {
        this.setData(data);
        this.setAppId(request.getAppId());
        this.setMethod(request.getMethod());
    }
}
