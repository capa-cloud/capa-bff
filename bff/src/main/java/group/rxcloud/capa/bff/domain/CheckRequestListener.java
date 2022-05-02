package group.rxcloud.capa.bff.domain;


public interface CheckRequestListener {

    /**
     * 检查自身的request是否可以发送请求
     */
    void checkSelfRequestParam(CapaContext capaContext);

    /**
     * 发送请求
     */
    void sendRequest(CapaContext capaContext);
}
