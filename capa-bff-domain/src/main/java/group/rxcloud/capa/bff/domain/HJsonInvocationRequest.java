package group.rxcloud.capa.bff.domain;


import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.enums.RequestEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.HashMap;
import group.rxcloud.capa.bff.json.*;
import java.util.Map;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 11:27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HJsonInvocationRequest extends InvocationRequest<JSONObject> implements TaskService, CheckRequestListener {

    /**
     * 需要补充的动态参数列表
     */
    private Map<String, Object> requiredParams = new HashMap<>();

    /**
     * Response数据裁剪的格式映射KV
     */
    private Map<String, String> responseDataFormat = new HashMap<>();

    private boolean finishRequest = false;

    /**
     * 该请求的类型
     */
    private RequestEnum requestEnum;

    @Override
    public void replaceParam(String key, Object value) {
        Map<String, Object> pMap = new HashMap<>();
        pMap.put(key, value);
        this.setData(JsonValueMapper.replaceValuesByParameters(this.getData(), pMap));
    }



    @Override
    public boolean sync() {
        return false;
    }

    @Override
    public void checkSelfRequestParam(Map<String, Object> resultMap) {
        if (isFinishRequest() || requiredParams == null || requiredParams.size() == 0
                || resultMap == null || resultMap.size() == 0) {
            return;
        }

        if (resultMap.keySet().stream().allMatch(resultMap::containsKey)) {
            // 这个请求可以变成前置请求了
            // 执行发送请求的逻辑
        }

    }

    public boolean isFinishRequest() {
        return finishRequest;
    }

    public void setFinishRequest(boolean finishRequest) {
        this.finishRequest = finishRequest;
    }
}
