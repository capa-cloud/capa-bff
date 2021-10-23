package group.rxcloud.capa.bff.outbound;

import group.rxcloud.capa.bff.allocate.InvocationRequest;
import group.rxcloud.capa.bff.domain.Context;
import group.rxcloud.capa.bff.domain.InvocationResponse;

import java.util.List;

public interface Outbound<Response extends Object, InvocationReq extends InvocationRequest, InvocationResp extends InvocationResponse> {

    Response outbound(List<InvocationReq> invocationReqList, List<InvocationResp> invocationRespList, Context context);
}
