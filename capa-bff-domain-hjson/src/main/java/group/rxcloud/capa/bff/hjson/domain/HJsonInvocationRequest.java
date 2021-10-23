package group.rxcloud.capa.bff.hjson.domain;


import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.domain.InvocationRequest;
import group.rxcloud.capa.bff.hjson.allocate.ServiceAllocate;

import java.util.Map;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 11:27
 */
public class HJsonInvocationRequest extends InvocationRequest<JSONObject>
        implements ServiceAllocate.TaskService {

    @Override
    public Map<String, String> params() {
        return null;
    }

    @Override
    public void replaceParam(String key, String value) {

    }

    @Override
    public boolean sync() {
        return false;
    }
}
