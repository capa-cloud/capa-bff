package group.rxcloud.capa.bff.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import group.rxcloud.capa.bff.enums.RequestEnum;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

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

    CountDownLatch countDownLatch;

    public void start() throws InterruptedException {
        if (CollectionUtils.isEmpty(requestList)) {
            return;
        }
        this.countDownLatch = new CountDownLatch(requestList.size());

        for (CheckRequestListener item : requestList) {
            HJsonInvocationRequest request = (HJsonInvocationRequest) item;
            if (!request.isFinishRequest()
                    && RequestEnum.PRE_REQUEST.equals(request.getRequestEnum())) {
                item.sendRequest(this);
            }
        }

        countDownLatch.await();
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

    /**
     * 每一个request成功获取都会调用这个方法
     */
    public void requestSuccessFinish(HJsonInvocationResponse response) {
        synchronized (this) {
            this.countDownLatch.countDown();
            // 检查这个是不是最后一个请求
            // todo：
            // 如果是的话，检查request；如果是成功的话，就可以告诉主流程，可以返回给客户端数据了

            // resultMap 要变换值
            this.requestList.forEach(item -> item.checkSelfRequestParam(this));
        }
    }
}
