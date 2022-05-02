package group.rxcloud.capa.bff.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultContext implements Context {

    private Map<String, Object> metric = new ConcurrentHashMap<>();

    @Override
    public void metric(String key, Object value) {
        this.metric.put(key, value);
    }
}
