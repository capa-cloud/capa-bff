package group.rxcloud.capa.bff.allocate;

import group.rxcloud.capa.bff.domain.BffApiDomain;

import java.util.Map;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 11:27
 */
public class InvocationRequest implements ServiceAllocate.TaskService {
    private String appId;

    private String method;

    private Object data;

    private Map<String,String> metaData;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map<String, String> getMetaData() {
        return metaData;
    }

    public void setMetaData(Map<String, String> metaData) {
        this.metaData = metaData;
    }

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
