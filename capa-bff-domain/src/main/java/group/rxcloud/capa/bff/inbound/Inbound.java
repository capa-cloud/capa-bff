package group.rxcloud.capa.bff.inbound;


import group.rxcloud.capa.bff.domain.Context;
import group.rxcloud.capa.bff.domain.InvocationRequest;

import java.util.List;

public interface Inbound<Request extends Object, Invocation extends InvocationRequest> {

    List<Invocation> inbound(Request request, Context context);
}
