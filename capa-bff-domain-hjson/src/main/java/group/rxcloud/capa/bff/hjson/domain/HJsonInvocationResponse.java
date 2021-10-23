package group.rxcloud.capa.bff.hjson.domain;

import group.rxcloud.capa.bff.domain.InvocationResponse;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 11:53
 */
public class HJsonInvocationResponse<T> extends InvocationResponse<T> {
    public HJsonInvocationResponse(){

    }

    public HJsonInvocationResponse(HJsonInvocationRequest<T> request, T data){
        this.setData(data);
        this.setAppId(request.getAppId());
        this.setMethod(request.getMethod());
    }

}
