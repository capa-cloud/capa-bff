package group.rxcloud.capa.bff.enums;

public enum RequestEnum {

    PRE_REQUEST("pre_request", "前置请求"),
    POST_REQUEST("post_request", "后置请求");
    private final String code;
    private final String msg;

    RequestEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
