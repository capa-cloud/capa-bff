package group.rxcloud.capa.bff.domain;

/**
 * @author wangjun
 * @date 2021/10/25
 */
public class DependOnFieldInfo<T> {
    /**
     * 需要依赖上下文的字段
     */
    private String field;
    /**
     * 依赖的服务请求
     */
    private InvocationRequest<T> dependOnServiceMethod;
    /**
     * 字段使用的服务请求
     */
    private InvocationRequest<T> requestServiceMethod;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public InvocationRequest<T> getDependOnServiceMethod() {
        return dependOnServiceMethod;
    }

    public void setDependOnServiceMethod(InvocationRequest<T> dependOnServiceMethod) {
        this.dependOnServiceMethod = dependOnServiceMethod;
    }

    public InvocationRequest<T> getRequestServiceMethod() {
        return requestServiceMethod;
    }

    public void setRequestServiceMethod(InvocationRequest<T> requestServiceMethod) {
        this.requestServiceMethod = requestServiceMethod;
    }
}
