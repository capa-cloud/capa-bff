package group.rxcloud.capa.bff.process;

import group.rxcloud.capa.bff.domain.Context;

public interface Processor<R extends Object, T extends Object> {

    R receive(String request, Context context);

    T process(R request, Context context);
}
