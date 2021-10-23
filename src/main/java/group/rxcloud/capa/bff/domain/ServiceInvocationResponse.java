package group.rxcloud.capa.bff.domain;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 11:53
 */
public class ServiceInvocationResponse<T> extends InvocationResponse<T> {
    public ServiceInvocationResponse(){

    }

    public ServiceInvocationResponse(ServiceInvocationRequest<T> request,T data){
        this.setData(data);
        this.setAppId(request.getAppId());
        this.setMethod(request.getMethod());
    }

}
