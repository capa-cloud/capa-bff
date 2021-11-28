lexer grammar CommonLexerRules;

@lexer::header {
package group.rxcloud.capa.bff.hjson.antlr4;

import group.rxcloud.capa.bff.hjson.antlr4.CommonLexerRules;
import group.rxcloud.capa.bff.hjson.antlr4.CustomerJsonBaseListener;
import group.rxcloud.capa.bff.hjson.antlr4.CustomerJsonListener;
import group.rxcloud.capa.bff.hjson.antlr4.CustomerJsonLexer;
import group.rxcloud.capa.bff.hjson.antlr4.CustomerJsonParser;
}


STRING
   : '"' (ESC | SAFECODEPOINT)* '"'
   ;

NUMBER
   : '-'? INT ('.' [0-9] +)? EXP?
   ;

fragment INT
   : '0' | [1-9] [0-9]*
   ;

fragment ESC
   : '\\' (["\\/bfnrt] | UNICODE)
   ;

fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;

fragment HEX
   : [0-9a-fA-F]
   ;

fragment SAFECODEPOINT
   : ~ ["\\\u0000-\u001F]
   ;

fragment EXP
   : [Ee] [+\-]? INT
   ;

WS
   : [ \t\r\n]+ -> skip
   ;