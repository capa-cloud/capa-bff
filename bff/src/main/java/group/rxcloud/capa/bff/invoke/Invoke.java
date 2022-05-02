package group.rxcloud.capa.bff.invoke;

import group.rxcloud.capa.bff.domain.Context;
import group.rxcloud.capa.bff.domain.InvocationRequest;
import group.rxcloud.capa.bff.domain.InvocationResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface Invoke<InvocationReq extends InvocationRequest, InvocationResp extends InvocationResponse> {

    List<InvocationResp> invoke(List<InvocationReq> invocationList, Context context) throws Exception;

    default Mono<List<InvocationResp>> invokeAsync(List<InvocationReq> invocationList, Context context) throws Exception {
        return Mono.just(invoke(invocationList, context));
    }
}
