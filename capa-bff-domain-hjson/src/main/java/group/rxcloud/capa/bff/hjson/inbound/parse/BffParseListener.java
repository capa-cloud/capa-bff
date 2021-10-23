package group.rxcloud.capa.bff.hjson.inbound.parse;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.hjson.inbound.AntlrUtils;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import org.antlr.v4.runtime.RuleContext;

import java.util.HashMap;
import java.util.Map;

public class BffParseListener extends CustomerJsonBaseListener {

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
    public void enterRequestJson(CustomerJsonParser.RequestJsonContext ctx) {
        String appId = AntlrUtils.getServiceId(ctx);
        String methodName = AntlrUtils.getRequestName(ctx);
        String requestKey = String.format("%s-%s", appId, methodName);
        String requestData = ctx.getText();
        HJsonInvocationRequest request = requestMap.get(requestKey);
        request.setData(JSONObject.parseObject(requestData));
        super.enterRequestJson(ctx);
    }

    @Override
    public void enterServiceId(CustomerJsonParser.ServiceIdContext ctx) {
        super.enterServiceId(ctx);
    }

    @Override
    public void enterSingleRequestFieldValue(CustomerJsonParser.SingleRequestFieldValueContext ctx) {
        RuleContext ruleContext = ctx.getParent();
        while (!(ruleContext instanceof CustomerJsonParser.ServiceBodyContext)) {
            ruleContext = ruleContext.getParent();
        }
        String appId = AntlrUtils.parseRowString(((CustomerJsonParser.ServiceBodyContext) ruleContext).getParent().getChild(0).getText());
        ruleContext = ctx.getParent();
        while (!(ruleContext instanceof CustomerJsonParser.RequestValueContext)) {
            ruleContext = ruleContext.getParent();
        }
        String methodName = AntlrUtils.parseRowString(ruleContext.getParent().getChild(0).getText());
        String requestKey = String.format("%s-%s", appId, methodName);
        if (ctx.getStart().getType() == 15) {
            String requestFieldData = AntlrUtils.parseRowString(ctx.getText());
            if (requestFieldData.contains("${")) {
                HJsonInvocationRequest request = requestMap.get(requestKey);
                request.getRequiredParams().put(requestFieldData.substring(2, requestFieldData.length() - 1), null);
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
        if (ctx.getStart().getType() == 15) {
            responseFieldValue = AntlrUtils.parseRowString(responseFieldValue);
        }
        HJsonInvocationRequest request = requestMap.get(requestKey);
        request.getResponseDataFormat().put(responseFieldKey, responseFieldValue);

        super.enterSingleResponseFieldValue(ctx);
    }

    @Override
    public void enterSinglerequestHeaderFieldValue(CustomerJsonParser.SinglerequestHeaderFieldValueContext ctx) {
        String appId = AntlrUtils.parseRowString(ctx.getParent().getParent().getParent().getParent().getParent().getParent().getStart().getText());
        String methodName = AntlrUtils.parseRowString(ctx.getParent().getParent().getParent().getParent().getStart().getText());
        String requestKey = String.format("%s-%s", appId, methodName);
        HJsonInvocationRequest request = requestMap.get(requestKey);
        String requestHeaderKey = AntlrUtils.parseRowString(ctx.getParent().getStart().getText());
        String requestHeaderValue = ctx.getStart().getText();
        if (ctx.getStart().getType() == 15) {
            request.getMetadata().put(requestHeaderKey, AntlrUtils.parseRowString(requestHeaderValue));
        }

        super.enterSinglerequestHeaderFieldValue(ctx);
    }
}
