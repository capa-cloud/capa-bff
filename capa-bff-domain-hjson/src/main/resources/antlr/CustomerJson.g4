grammar CustomerJson;

customerJson
    : '{' service (',' service)* '}'
    ;

service
    : serviceId ':' serviceBody
    ;

serviceId
    : STRING
    ;

serviceBody
    : '[' requestObj (',' requestObj)* ']'
    ;

requestObj
    : requestId ':' requestValue
    ;

requestId
    : STRING
    ;

requestValue
    : '(' 'request' ':' requestJson ',' ('requestHeader' ':' requestHeaderObj ',')? 'response' ':' responseBody ')'
    ;

requestHeaderObj
    : '{' singleRequestHeaderField (',' singleRequestHeaderField)* '}'
    | '{' '}'
    ;

singleRequestHeaderField
    : STRING ':' singlerequestHeaderFieldValue
    ;

requestBody
    : '{' requestBodyItem (',' requestBodyItem)* '}'
    | '{' '}'
    ;

requestBodyItem
    : '{' singleRequestField (',' singleRequestField)* '}'
    | '{' requestBodyItem (',' requestBodyItem)* '}'
    | '{' '}'
    ;

singleRequestField
    : STRING ':' singleRequestFieldValue
    ;

requestJson
   : singleRequestFieldValue
   ;

obj
   : '{' pair (',' pair)* '}'
   | '{' '}'
   ;

pair
   : STRING ':' singleRequestFieldValue
   ;

arr
   : '[' singleRequestFieldValue (',' singleRequestFieldValue)* ']'
   | '[' ']'
   ;

responseBody
    : '{' singleResponseField (',' singleResponseField)* '}'
    | '{' '}'
    ;

singleResponseField
    : STRING ':' singleResponseFieldValue
    ;

singleRequestFieldValue
   : STRING
   | NUMBER
   | 'true'
   | 'false'
   | 'null'
   | obj
   | arr
   ;

singleResponseFieldValue
   : STRING
   | NUMBER
   | 'true'
   | 'false'
   | 'null'
   ;

singlerequestHeaderFieldValue
   : STRING
   | NUMBER
   | 'true'
   | 'false'
   | 'null'
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
