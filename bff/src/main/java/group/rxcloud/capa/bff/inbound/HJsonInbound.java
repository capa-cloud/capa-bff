package group.rxcloud.capa.bff.inbound;

import com.alibaba.fastjson.JSON;
import group.rxcloud.capa.bff.domain.CapaContext;
import group.rxcloud.capa.bff.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.antlr4.CustomerJsonLexer;
import group.rxcloud.capa.bff.hjson.antlr4.CustomerJsonParser;
import group.rxcloud.capa.bff.inbound.parse.BffParseListener;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HJsonInbound implements Inbound<String, HJsonInvocationRequest> {

    @Override
    public List<HJsonInvocationRequest> inbound(String requestStr, CapaContext context) {
        log.info("[HJsonInbound] inbound start");
        CustomerJsonLexer lexer = new CustomerJsonLexer(CharStreams.fromString(requestStr));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CustomerJsonParser parser = new CustomerJsonParser(tokens);
        CustomerJsonParser.CustomerJsonContext ast = parser.customerJson();
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        BffParseListener importListener = new BffParseListener();
        parseTreeWalker.walk(importListener, ast);
        log.info("[HJsonInbound] inbound end " + JSON.toJSON(importListener.requestMap.values()));
        context.setRequestList(new ArrayList<>(importListener.requestMap.values()));
        context.setRequestSize(new ArrayList<>(importListener.requestMap.values()).size());
        return new ArrayList<>(importListener.requestMap.values());
    }
}
