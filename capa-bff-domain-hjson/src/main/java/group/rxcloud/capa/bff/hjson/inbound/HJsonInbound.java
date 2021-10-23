package group.rxcloud.capa.bff.hjson.inbound;

import group.rxcloud.capa.bff.domain.Context;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.inbound.parse.BffParseListener;
import group.rxcloud.capa.bff.hjson.inbound.parse.CustomerJsonLexer;
import group.rxcloud.capa.bff.hjson.inbound.parse.CustomerJsonParser;
import group.rxcloud.capa.bff.inbound.Inbound;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

public class HJsonInbound implements Inbound<String, HJsonInvocationRequest> {

    @Override
    public List<HJsonInvocationRequest> inbound(String requestStr, Context context) {
        CustomerJsonLexer lexer = new CustomerJsonLexer(CharStreams.fromString(requestStr));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CustomerJsonParser parser = new CustomerJsonParser(tokens);
        CustomerJsonParser.CustomerJsonContext ast = parser.customerJson();
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        BffParseListener importListener = new BffParseListener();
        parseTreeWalker.walk(importListener, ast);
        return new ArrayList<>(importListener.requestMap.values());
    }
}
