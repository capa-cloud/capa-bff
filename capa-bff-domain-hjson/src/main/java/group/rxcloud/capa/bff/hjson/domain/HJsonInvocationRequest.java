package group.rxcloud.capa.bff.hjson.domain;


import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.domain.InvocationRequest;
import group.rxcloud.capa.bff.hjson.allocate.ServiceAllocate;
import lombok.ToString;

import java.util.Map;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 11:27
 */
@ToString
public class HJsonInvocationRequest extends InvocationRequest<JSONObject>
        implements ServiceAllocate.TaskService {
    public static  final String SEPARATOR = ".";

    /**
     * 需要补充的动态参数列表
     */
    private Map<String, Object> requiredParams;

    /**
     * Response数据裁剪的格式映射KV
     */
    private Map<String, String> responseDataFormat;

    public Map<String, Object> getRequiredParams() {
        return requiredParams;
    }

    public void setRequiredParams(Map<String, Object> requiredParams) {
        this.requiredParams = requiredParams;
    }

    public void replaceParam(String key, Object value) {

    }

    public boolean sync() {
        return true;
    }


    public Map<String, String> getResponseDataFormat() {
        return responseDataFormat;
    }

    public void setResponseDataFormat(Map<String, String> responseDataFormat) {
        this.responseDataFormat = responseDataFormat;
    }
}
