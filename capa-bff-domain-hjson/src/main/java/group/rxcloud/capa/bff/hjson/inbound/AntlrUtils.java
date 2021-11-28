package group.rxcloud.capa.bff.hjson.inbound;

import group.rxcloud.capa.bff.hjson.antlr4.CustomerJsonParser;
import org.antlr.v4.runtime.RuleContext;

public class AntlrUtils {

    public static String parseRowString(String rowString) {
        return rowString.substring(1, rowString.length() - 1);
    }

    public static String getServiceId(RuleContext ctx) {
        RuleContext ruleContext = ctx;
        while (!(ruleContext instanceof CustomerJsonParser.ServiceBodyContext)) {
            ruleContext = ruleContext.getParent();
        }

        return AntlrUtils.parseRowString(((CustomerJsonParser.ServiceBodyContext) ruleContext).getParent().getChild(0).getText());
    }


    public static String getRequestName(RuleContext ctx) {
        RuleContext ruleContext = ctx;
        while (!(ruleContext instanceof CustomerJsonParser.RequestValueContext)) {
            ruleContext = ruleContext.getParent();
        }
        return AntlrUtils.parseRowString(ruleContext.getParent().getChild(0).getText());
    }
}
