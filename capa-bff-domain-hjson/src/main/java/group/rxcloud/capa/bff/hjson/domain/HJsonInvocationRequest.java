package group.rxcloud.capa.bff.hjson.domain;


import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.domain.InvocationRequest;
import group.rxcloud.capa.bff.hjson.allocate.ServiceAllocate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 11:27
 */
public class HJsonInvocationRequest extends InvocationRequest<JSONObject>
        implements ServiceAllocate.TaskService {
    public static  final String SEPARATOR = ".";

    /**
     * 需要补充的动态参数列表
     */
    private Map<String, String> requiredParams;

    /**
     * Response数据裁剪的格式映射KV
     */
    private Map<String, String> responseDataFormat;


    @Override
    public void replaceParam(String key, String value) {

    }

    @Override
    public boolean sync() {
        return false;
    }

    public Map<String, String> getRequiredParams() {
        return requiredParams;
    }

    public void setRequiredParams(Map<String, String> requiredParams) {
        this.requiredParams = requiredParams;
    }

    public Map<String, String> getResponseDataFormat() {
        return responseDataFormat;
    }

    public void setResponseDataFormat(Map<String, String> responseDataFormat) {
        this.responseDataFormat = responseDataFormat;
    }
}
