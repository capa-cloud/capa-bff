grammar CustomerJson;

customerJson
    : '{' service (',' service)* '}'
    ;

service
    : STRING ':' serviceBody
    ;

serviceBody
    : '[' requestObj (',' requestObj)* ']'
    ;

requestObj
    : STRING ':' requestValue
    ;

requestValue
    : '(' STRING ':' requestBody ',' STRING ':' responseBody ')'
    ;

requestBody
    : '{' singleRequestField (',' singleRequestField)* '}'
    ;

singleRequestField
    : STRING ':' value
    ;

responseBody
    : '{' singleResponseField (',' singleResponseField)* '}'
    ;

singleResponseField
    : STRING ':' value
    ;

value
   : STRING
   | NUMBER
   | 'true'
   | 'false'
   | 'null'
   ;

STRING
   : '"' (ESC | SAFECODEPOINT)* '"'
   ;

fragment ESC
   : '\\' (["\\/bfnrt] | UNICODE)
   ;

fragment SAFECODEPOINT
   : ~ ["\\\u0000-\u001F]
   ;

NUMBER
   : '-'? INT ('.' [0-9] +)? EXP?
   ;

fragment HEX
   : [0-9a-fA-F]
   ;

fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;

fragment INT
   : '0' | [1-9] [0-9]*
   ;

fragment EXP
   : [Ee] [+\-]? INT
   ;
