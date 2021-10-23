package group.rxcloud.capa.bff.hjson.inbound.parse;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        CustomerJsonLexer lexer = new CustomerJsonLexer(CharStreams.fromFileName(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CustomerJsonParser parser = new CustomerJsonParser(tokens);
        CustomerJsonParser.CustomerJsonContext ast = parser.customerJson();

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        MyListener importListener = new MyListener();
        parseTreeWalker.walk(importListener, ast);

        //  List<ServiceInvocationRequest>
    }
}
