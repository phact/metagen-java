grammar MetagenCall;
// https://www.youtube.com/watch?v=eW4WFgRtFeY

metagenCall :
 ( inputType '->' )?
 funcName '(' funcArg* ')'
 ( '->' outputType )?
 ;

inputType : ID;
funcName: ID;
outputType : ID;

funcArg : ( metagenCall | stringLiteral );

stringLiteral : SQUOTESTRING;

SQUOTESTRING: '\'' .*? '\'' ;
ID: IDPART ('.' IDPART)* ;
IDPART:  [a-zA-Z] [0-9a-zA-Z_-]* ;

