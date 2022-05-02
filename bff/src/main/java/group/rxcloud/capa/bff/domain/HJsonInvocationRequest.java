package group.rxcloud.capa.bff.domain;


import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.json.JsonValueMapper;
import group.rxcloud.capa.bff.enums.RequestEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.HashMap;
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
    public void checkSelfRequestParam(CapaContext capaContext) {
        if (isFinishRequest() || requiredParams == null || requiredParams.size() == 0) {
            return;
        }
        Map<String, Object> resultMap = capaContext.getResultMap();

        if (resultMap.keySet().stream().allMatch(resultMap::containsKey)) {
            // 这个请求可以变成前置请求了
            // 执行发送请求的逻辑
            this.sendRequest(capaContext);
        }

    }

    @Override
    public void sendRequest(CapaContext capaContext) {
        // 发送请求，获取数据时；回调下面的方法
        HJsonInvocationResponse response = null;
        // 回调逻辑
        this.finishRequest = true;
        capaContext.requestSuccessFinish(response);

    }

    public boolean isFinishRequest() {
        return finishRequest;
    }

    public void setFinishRequest(boolean finishRequest) {
        this.finishRequest = finishRequest;
    }
}
