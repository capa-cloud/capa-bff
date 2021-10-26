grammar CustomerJson;

import CommonLexerRules;

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
   | requestHeaderObjValue
   | requestHeaderArr
   ;

value
   : STRING
   | NUMBER
   | 'true'
   | 'false'
   | 'null'
   ;

requestHeaderObjValue
   : '{' requestHeaderPair (',' requestHeaderPair)* '}'
   | '{' '}'
   ;

requestHeaderPair
   : STRING ':' singlerequestHeaderFieldValue
   ;

requestHeaderArr
   : '[' singlerequestHeaderFieldValue (',' singlerequestHeaderFieldValue)* ']'
   | '[' ']'
   ;

