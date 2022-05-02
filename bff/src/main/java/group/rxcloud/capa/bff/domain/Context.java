package group.rxcloud.capa.bff.domain;

public interface Context {

    void metric(String key, Object value);
}
