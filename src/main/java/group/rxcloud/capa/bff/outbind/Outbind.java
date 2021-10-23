package group.rxcloud.capa.bff.outbind;

import java.util.Map;

public interface Outbind<T> {

    T outbind(Map<String >);


}
