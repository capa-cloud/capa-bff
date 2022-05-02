package group.rxcloud.capa.bff.inbound;


import group.rxcloud.capa.bff.domain.CapaContext;
import group.rxcloud.capa.bff.domain.InvocationRequest;

import java.util.List;

public interface Inbound<Request, Invocation extends InvocationRequest> {

    List<Invocation> inbound(Request request, CapaContext context);
}
