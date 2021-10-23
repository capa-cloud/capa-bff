package group.rxcloud.capa.bff.hjson.inbound;

import group.rxcloud.capa.bff.domain.Context;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.inbound.Inbound;

import java.util.List;

public class HJsonInbound implements Inbound<String, HJsonInvocationRequest> {
    @Override
    public List<HJsonInvocationRequest> inbound(String s, Context context) {
        return null;
    }
}
