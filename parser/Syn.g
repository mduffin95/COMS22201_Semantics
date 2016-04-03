// COMS22201: Syntax analyser

parser grammar Syn;

options {
  tokenVocab = Lex;
  output = AST;
}

@members
{
	private String cleanString(String s){
		String tmp;
		tmp = s.replaceAll("^'", "");
		s = tmp.replaceAll("'$", "");
		tmp = s.replaceAll("''", "'");
		return tmp;
	}
}

program :
      statements
    ;

statements :
      statement ( SEMICOLON^ statement )*
    ;

statement :
      ID ASSIGN^ exp
    | SKIP
    | IF^ boolexp THEN! statement ELSE! statement
    | WHILE^ boolexp DO! statement
    | READ^ OPENPAREN! ID CLOSEPAREN!
    | ( WRITE OPENPAREN exp ) => WRITE^ OPENPAREN! exp CLOSEPAREN!
    | WRITE^ OPENPAREN! ( boolexp | string ) CLOSEPAREN!
    | WRITELN
    | OPENPAREN! statements CLOSEPAREN!
    ;

string
    scope { String tmp; }
    :
    s=STRING { $string::tmp = cleanString($s.text); }-> STRING[$string::tmp]
    ;

boolexp :
      boolterm ( AND^ boolterm )*
    ;

boolterm :
      NOT^ bool
    | bool
    ;

bool :
      TRUE
    | FALSE
    | ( exp ( EQ | LEQ ) ) => exp ( EQ | LEQ )^ exp
    | OPENPAREN! boolexp CLOSEPAREN!
    ;

exp :
    term ( ( PLUS | MINUS )^ term )*
    ;

term :
    unary ( (MULT | DIV | MOD)^ unary )*
    ;

unary :
      PLUS! atom
    | MINUS^ atom
    | atom
    ;

atom :
      ID
    | INTNUM
    | OPENPAREN! exp CLOSEPAREN!
    ;
