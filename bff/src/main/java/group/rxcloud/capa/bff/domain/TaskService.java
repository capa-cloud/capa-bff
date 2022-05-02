package group.rxcloud.capa.bff.domain;

/**
 * @author jwang55
 */
public interface TaskService {
    /**
     * 替换参数
     *
     * @param key   -
     * @param value -
     */
    void replaceParam(String key, Object value);

    /**
     * 是否同步/异步
     *
     * @return -
     */
    boolean sync();
}
