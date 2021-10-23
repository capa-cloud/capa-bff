package group.rxcloud.capa.bff.hjson.domain;


import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.domain.InvocationRequest;
import group.rxcloud.capa.bff.hjson.invoke.HJsonInvoker;
import lombok.Data;

import java.util.Map;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 11:27
 */
@Data
public class HJsonInvocationRequest extends InvocationRequest<JSONObject>
        implements HJsonInvoker.TaskService {

    /**
     * 需要补充的动态参数列表
     */
    private Map<String, Object> requiredParams;

    /**
     * Response数据裁剪的格式映射KV
     */
    private Map<String, String> responseDataFormat;

    @Override
    public void replaceParam(String key, Object value) {
    }

    @Override
    public boolean sync() {
        return true;
    }
}
