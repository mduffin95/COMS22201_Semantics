// COMS22201: Lexical analyser

lexer grammar Lex;

@members
{
    int charCount = 0;
}

//---------------------------------------------------------------------------
// KEYWORDS
//---------------------------------------------------------------------------
DO         : 'do' ;
ELSE       : 'else' ;
FALSE      : 'false' ;
IF         : 'if' ;
READ       : 'read' ;
SKIP       : 'skip' ;
THEN       : 'then' ;
TRUE       : 'true' ;
WHILE      : 'while' ;
WRITE      : 'write' ;
WRITELN    : 'writeln' ;

//---------------------------------------------------------------------------
// OPERATORS
//---------------------------------------------------------------------------
SEMICOLON    : ';' ;
OPENPAREN    : '(' ;
CLOSEPAREN   : ')' ;

INTNUM       : ('0'..'9')+ ;

STRING       : '\'' ('\'' '\'' | ~'\'')* '\'';

COMMENT      : '{' (~'}')* '}' {skip();} ;

WS           : (' ' | '\t' | '\r' | '\n' )+ {skip();} ;

fragment
LETTER       : 'a'..'z'
             | 'A'..'Z' ;

fragment
DIGIT        : '0'..'9' ;

ID           : LETTER ALPHANUM;

fragment
ALPHANUM
@init {int varLen = 1;}
             : ({varLen < 8}?=> (LETTER | DIGIT) {varLen++;})*
             ;

MULT         : '*' ;
MINUS        : '-' ;
PLUS         : '+' ;
DIV          : '/' ;
MOD          : '%' ;
ASSIGN       : ':=' ;
EQ           : '=' ;
LEQ	         : '<=' ;
AND          : '&' ;
NOT          : '!' ;
