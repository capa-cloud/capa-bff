package group.rxcloud.capa.bff.process;

public interface Processor<R extends Object, T extends Object> {

    R receive(String request);

    T process(R request);
}
