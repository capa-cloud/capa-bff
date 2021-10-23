package group.rxcloud.capa.bff.inbound;


import java.util.List;

public interface Inbound<Request extends Object, Invocation extends InvocationRequest> {

    List<Invocation> inbound(Request request);
}
