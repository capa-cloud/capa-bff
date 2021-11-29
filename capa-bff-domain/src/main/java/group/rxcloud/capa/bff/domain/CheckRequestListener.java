package group.rxcloud.capa.bff.domain;

import java.util.Map;

public interface CheckRequestListener {

    void checkSelfRequestParam(Map<String, Object> resultMap);

}
