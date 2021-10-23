package group.rxcloud.capa.bff.hjson.inbound.parse;

import group.rxcloud.capa.bff.hjson.AntlrUtils;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class MyListener extends CustomerJsonBaseListener{

    public Map<String, HJsonInvocationRequest> requestMap = new HashMap<>();

    @Override
    public void enterRequestObj(CustomerJsonParser.RequestObjContext ctx) {
        HJsonInvocationRequest request = new HJsonInvocationRequest();
        String appId = AntlrUtils.parseRowString(ctx.getParent().getParent().getStart().getText());
        String methodName = AntlrUtils.parseRowString(ctx.getStart().getText());
        request.setMetadata(new HashMap<>());
        request.setRequiredParams(new HashMap<>());
        request.setResponseDataFormat(new HashMap<>());
        request.setAppId(appId);
        request.setMethod(methodName);
        requestMap.put(String.format("%s-%s", appId, methodName), request);
        super.enterRequestObj(ctx);
    }

    @Override
    public void enterRequestBody(CustomerJsonParser.RequestBodyContext ctx) {
        String appId = AntlrUtils.parseRowString(ctx.getParent().getParent().getParent().getParent().getStart().getText());
        String methodName = AntlrUtils.parseRowString(ctx.getParent().getParent().getStart().getText());
        String requestKey = String.format("%s-%s", appId, methodName);
        String requestData = ctx.getText();
        HJsonInvocationRequest request = requestMap.get(requestKey);
        request.setData(JSONObject.parseObject(requestData));
        super.enterRequestBody(ctx);
    }

    @Override
    public void enterSingleRequestFieldValue(CustomerJsonParser.SingleRequestFieldValueContext ctx) {
        String appId = AntlrUtils.parseRowString(ctx.getParent().getParent().getParent().getParent().getParent().getParent().getStart().getText());
        String methodName = AntlrUtils.parseRowString(ctx.getParent().getParent().getParent().getParent().getStart().getText());
        String requestKey = String.format("%s-%s", appId, methodName);
        if (ctx.getStart().getType() == 12) {
            String requestFieldData = AntlrUtils.parseRowString(ctx.getText());
            if (requestFieldData.contains("${")) {
                HJsonInvocationRequest request = requestMap.get(requestKey);
                request.getRequiredParams().put(requestFieldData, null);
            }
        }
        super.enterSingleRequestFieldValue(ctx);
    }

    @Override
    public void enterSingleResponseFieldValue(CustomerJsonParser.SingleResponseFieldValueContext ctx) {
        String appId = AntlrUtils.parseRowString(ctx.getParent().getParent().getParent().getParent().getParent().getParent().getStart().getText());
        String methodName = AntlrUtils.parseRowString(ctx.getParent().getParent().getParent().getParent().getStart().getText());
        String requestKey = String.format("%s-%s", appId, methodName);
        String responseFieldKey = AntlrUtils.parseRowString(ctx.getParent().getStart().getText());
        String responseFieldValue = ctx.getText();
        if (ctx.getStart().getType() == 12) {
            responseFieldValue = AntlrUtils.parseRowString(responseFieldValue);
        }
        HJsonInvocationRequest request = requestMap.get(requestKey);
        request.getResponseDataFormat().put(responseFieldKey, responseFieldValue);

        super.enterSingleResponseFieldValue(ctx);
    }

}
