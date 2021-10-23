package group.rxcloud.capa.bff.hjson.inbound.parse;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        CustomerJsonLexer lexer = new CustomerJsonLexer(CharStreams.fromFileName("/Users/wangjie_fourth/Desktop/request.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CustomerJsonParser parser = new CustomerJsonParser(tokens);
        CustomerJsonParser.CustomerJsonContext ast = parser.customerJson();

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        BffParseListener importListener = new BffParseListener();
        parseTreeWalker.walk(importListener, ast);
        System.out.println("importListener.requestMap = " + importListener.requestMap);

        //  List<ServiceInvocationRequest>
    }
}
