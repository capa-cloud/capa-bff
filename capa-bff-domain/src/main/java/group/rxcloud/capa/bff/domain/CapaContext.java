package group.rxcloud.capa.bff.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.List;
import java.util.Map;

/**
 * @author jwang55
 */
@SuppressFBWarnings(value = {"UUF_UNUSED_FIELD", "UWF_UNWRITTEN_FIELD", "NP_UNWRITTEN_FIELD"})
public class CapaContext implements Context {

    private List<CheckRequestListener> requestList;

    // 弄成final
    private int requestSize;

    // 别名中心
    private Map<String, Object> resultMap;

    @Override
    public void metric(String key, Object value) {

    }

    public void refreshResultMap(HJsonInvocationResponse response) {
        synchronized (this) {
            // resultMap 要变换值
            this.requestList.forEach(item -> item.checkSelfRequestParam(resultMap));
        }
    }


    public List<CheckRequestListener> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<CheckRequestListener> requestList) {
        this.requestList = requestList;
    }

    public int getRequestSize() {
        return requestSize;
    }

    public void setRequestSize(int requestSize) {
        this.requestSize = requestSize;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
