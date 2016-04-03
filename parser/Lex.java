// $ANTLR 3.2 debian-10 Lex.g 2016-04-03 18:45:30

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Lex extends Lexer {
    public static final int LETTER=22;
    public static final int OPENPAREN=16;
    public static final int DO=4;
    public static final int ASSIGN=31;
    public static final int COMMENT=20;
    public static final int WRITE=13;
    public static final int MINUS=27;
    public static final int MULT=26;
    public static final int WRITELN=14;
    public static final int SEMICOLON=15;
    public static final int ELSE=5;
    public static final int SKIP=9;
    public static final int ID=25;
    public static final int WS=21;
    public static final int EOF=-1;
    public static final int IF=7;
    public static final int CLOSEPAREN=17;
    public static final int MOD=30;
    public static final int TRUE=11;
    public static final int EQ=32;
    public static final int DIGIT=23;
    public static final int READ=8;
    public static final int DIV=29;
    public static final int NOT=35;
    public static final int INTNUM=18;
    public static final int ALPHANUM=24;
    public static final int AND=34;
    public static final int STRING=19;
    public static final int LEQ=33;
    public static final int FALSE=6;
    public static final int THEN=10;
    public static final int WHILE=12;
    public static final int PLUS=28;

        int charCount = 0;


    // delegates
    // delegators

    public Lex() {;} 
    public Lex(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Lex(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Lex.g"; }

    // $ANTLR start "DO"
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:13:12: ( 'do' )
            // Lex.g:13:14: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DO"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:14:12: ( 'else' )
            // Lex.g:14:14: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:15:12: ( 'false' )
            // Lex.g:15:14: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:16:12: ( 'if' )
            // Lex.g:16:14: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "READ"
    public final void mREAD() throws RecognitionException {
        try {
            int _type = READ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:17:12: ( 'read' )
            // Lex.g:17:14: 'read'
            {
            match("read"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "READ"

    // $ANTLR start "SKIP"
    public final void mSKIP() throws RecognitionException {
        try {
            int _type = SKIP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:18:12: ( 'skip' )
            // Lex.g:18:14: 'skip'
            {
            match("skip"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SKIP"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:19:12: ( 'then' )
            // Lex.g:19:14: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:20:12: ( 'true' )
            // Lex.g:20:14: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:21:12: ( 'while' )
            // Lex.g:21:14: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "WRITE"
    public final void mWRITE() throws RecognitionException {
        try {
            int _type = WRITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:22:12: ( 'write' )
            // Lex.g:22:14: 'write'
            {
            match("write"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WRITE"

    // $ANTLR start "WRITELN"
    public final void mWRITELN() throws RecognitionException {
        try {
            int _type = WRITELN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:23:12: ( 'writeln' )
            // Lex.g:23:14: 'writeln'
            {
            match("writeln"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WRITELN"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:28:14: ( ';' )
            // Lex.g:28:16: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "OPENPAREN"
    public final void mOPENPAREN() throws RecognitionException {
        try {
            int _type = OPENPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:29:14: ( '(' )
            // Lex.g:29:16: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPENPAREN"

    // $ANTLR start "CLOSEPAREN"
    public final void mCLOSEPAREN() throws RecognitionException {
        try {
            int _type = CLOSEPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:30:14: ( ')' )
            // Lex.g:30:16: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSEPAREN"

    // $ANTLR start "INTNUM"
    public final void mINTNUM() throws RecognitionException {
        try {
            int _type = INTNUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:32:14: ( ( '0' .. '9' )+ )
            // Lex.g:32:16: ( '0' .. '9' )+
            {
            // Lex.g:32:16: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Lex.g:32:17: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTNUM"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:34:14: ( '\\'' ( '\\'' '\\'' | ~ '\\'' )* '\\'' )
            // Lex.g:34:16: '\\'' ( '\\'' '\\'' | ~ '\\'' )* '\\''
            {
            match('\''); 
            // Lex.g:34:21: ( '\\'' '\\'' | ~ '\\'' )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\'') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='\'') ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='\uFFFF')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // Lex.g:34:22: '\\'' '\\''
            	    {
            	    match('\''); 
            	    match('\''); 

            	    }
            	    break;
            	case 2 :
            	    // Lex.g:34:34: ~ '\\''
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:36:14: ( '{' (~ '}' )* '}' )
            // Lex.g:36:16: '{' (~ '}' )* '}'
            {
            match('{'); 
            // Lex.g:36:20: (~ '}' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='|')||(LA3_0>='~' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Lex.g:36:21: ~ '}'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='|')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('}'); 
            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:38:14: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // Lex.g:38:16: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // Lex.g:38:16: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\t' && LA4_0<='\n')||LA4_0=='\r'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Lex.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // Lex.g:41:14: ( 'a' .. 'z' | 'A' .. 'Z' )
            // Lex.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // Lex.g:45:14: ( '0' .. '9' )
            // Lex.g:45:16: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:47:14: ( LETTER ALPHANUM )
            // Lex.g:47:16: LETTER ALPHANUM
            {
            mLETTER(); 
            mALPHANUM(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "ALPHANUM"
    public final void mALPHANUM() throws RecognitionException {
        try {
            int varLen = 1;
            // Lex.g:52:14: ( ({...}? => ( LETTER | DIGIT ) )* )
            // Lex.g:52:16: ({...}? => ( LETTER | DIGIT ) )*
            {
            // Lex.g:52:16: ({...}? => ( LETTER | DIGIT ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||(LA5_0>='a' && LA5_0<='z')) && ((varLen < 8))) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Lex.g:52:17: {...}? => ( LETTER | DIGIT )
            	    {
            	    if ( !((varLen < 8)) ) {
            	        throw new FailedPredicateException(input, "ALPHANUM", "varLen < 8");
            	    }
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    varLen++;

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "ALPHANUM"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:55:14: ( '*' )
            // Lex.g:55:16: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:56:14: ( '-' )
            // Lex.g:56:16: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:57:14: ( '+' )
            // Lex.g:57:16: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:58:14: ( '/' )
            // Lex.g:58:16: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:59:14: ( '%' )
            // Lex.g:59:16: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:60:14: ( ':=' )
            // Lex.g:60:16: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:61:14: ( '=' )
            // Lex.g:61:16: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "LEQ"
    public final void mLEQ() throws RecognitionException {
        try {
            int _type = LEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:62:14: ( '<=' )
            // Lex.g:62:16: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEQ"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:63:14: ( '&' )
            // Lex.g:63:16: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:64:14: ( '!' )
            // Lex.g:64:16: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    public void mTokens() throws RecognitionException {
        // Lex.g:1:8: ( DO | ELSE | FALSE | IF | READ | SKIP | THEN | TRUE | WHILE | WRITE | WRITELN | SEMICOLON | OPENPAREN | CLOSEPAREN | INTNUM | STRING | COMMENT | WS | ID | MULT | MINUS | PLUS | DIV | MOD | ASSIGN | EQ | LEQ | AND | NOT )
        int alt6=29;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // Lex.g:1:10: DO
                {
                mDO(); 

                }
                break;
            case 2 :
                // Lex.g:1:13: ELSE
                {
                mELSE(); 

                }
                break;
            case 3 :
                // Lex.g:1:18: FALSE
                {
                mFALSE(); 

                }
                break;
            case 4 :
                // Lex.g:1:24: IF
                {
                mIF(); 

                }
                break;
            case 5 :
                // Lex.g:1:27: READ
                {
                mREAD(); 

                }
                break;
            case 6 :
                // Lex.g:1:32: SKIP
                {
                mSKIP(); 

                }
                break;
            case 7 :
                // Lex.g:1:37: THEN
                {
                mTHEN(); 

                }
                break;
            case 8 :
                // Lex.g:1:42: TRUE
                {
                mTRUE(); 

                }
                break;
            case 9 :
                // Lex.g:1:47: WHILE
                {
                mWHILE(); 

                }
                break;
            case 10 :
                // Lex.g:1:53: WRITE
                {
                mWRITE(); 

                }
                break;
            case 11 :
                // Lex.g:1:59: WRITELN
                {
                mWRITELN(); 

                }
                break;
            case 12 :
                // Lex.g:1:67: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 13 :
                // Lex.g:1:77: OPENPAREN
                {
                mOPENPAREN(); 

                }
                break;
            case 14 :
                // Lex.g:1:87: CLOSEPAREN
                {
                mCLOSEPAREN(); 

                }
                break;
            case 15 :
                // Lex.g:1:98: INTNUM
                {
                mINTNUM(); 

                }
                break;
            case 16 :
                // Lex.g:1:105: STRING
                {
                mSTRING(); 

                }
                break;
            case 17 :
                // Lex.g:1:112: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 18 :
                // Lex.g:1:120: WS
                {
                mWS(); 

                }
                break;
            case 19 :
                // Lex.g:1:123: ID
                {
                mID(); 

                }
                break;
            case 20 :
                // Lex.g:1:126: MULT
                {
                mMULT(); 

                }
                break;
            case 21 :
                // Lex.g:1:131: MINUS
                {
                mMINUS(); 

                }
                break;
            case 22 :
                // Lex.g:1:137: PLUS
                {
                mPLUS(); 

                }
                break;
            case 23 :
                // Lex.g:1:142: DIV
                {
                mDIV(); 

                }
                break;
            case 24 :
                // Lex.g:1:146: MOD
                {
                mMOD(); 

                }
                break;
            case 25 :
                // Lex.g:1:150: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 26 :
                // Lex.g:1:157: EQ
                {
                mEQ(); 

                }
                break;
            case 27 :
                // Lex.g:1:160: LEQ
                {
                mLEQ(); 

                }
                break;
            case 28 :
                // Lex.g:1:164: AND
                {
                mAND(); 

                }
                break;
            case 29 :
                // Lex.g:1:168: NOT
                {
                mNOT(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\uffff\10\20\22\uffff\1\45\2\20\1\50\6\20\1\uffff\2\20\1\uffff"+
        "\6\20\1\67\1\20\1\71\1\72\1\73\1\74\2\20\1\uffff\1\77\4\uffff\1"+
        "\100\1\102\2\uffff\1\20\1\uffff\1\104\1\uffff";
    static final String DFA6_eofS =
        "\105\uffff";
    static final String DFA6_minS =
        "\1\11\1\157\1\154\1\141\1\146\1\145\1\153\2\150\22\uffff\1\60\1"+
        "\163\1\154\1\60\1\141\1\151\1\145\1\165\2\151\1\uffff\1\145\1\163"+
        "\1\uffff\1\144\1\160\1\156\1\145\1\154\1\164\1\60\1\145\4\60\2\145"+
        "\1\uffff\1\60\4\uffff\2\60\2\uffff\1\156\1\uffff\1\60\1\uffff";
    static final String DFA6_maxS =
        "\1\173\1\157\1\154\1\141\1\146\1\145\1\153\2\162\22\uffff\1\172"+
        "\1\163\1\154\1\172\1\141\1\151\1\145\1\165\2\151\1\uffff\1\145\1"+
        "\163\1\uffff\1\144\1\160\1\156\1\145\1\154\1\164\1\172\1\145\4\172"+
        "\2\145\1\uffff\1\172\4\uffff\2\172\2\uffff\1\156\1\uffff\1\172\1"+
        "\uffff";
    static final String DFA6_acceptS =
        "\11\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
        "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\12\uffff\1\1\2\uffff\1\4\16"+
        "\uffff\1\2\1\uffff\1\5\1\6\1\7\1\10\2\uffff\1\3\1\11\1\uffff\1\12"+
        "\1\uffff\1\13";
    static final String DFA6_specialS =
        "\105\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\17\2\uffff\1\17\22\uffff\1\17\1\32\3\uffff\1\25\1\31\1\15"+
            "\1\12\1\13\1\21\1\23\1\uffff\1\22\1\uffff\1\24\12\14\1\26\1"+
            "\11\1\30\1\27\3\uffff\32\20\6\uffff\3\20\1\1\1\2\1\3\2\20\1"+
            "\4\10\20\1\5\1\6\1\7\2\20\1\10\3\20\1\16",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41\11\uffff\1\42",
            "\1\43\11\uffff\1\44",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\20\7\uffff\32\20\6\uffff\32\20",
            "\1\46",
            "\1\47",
            "\12\20\7\uffff\32\20\6\uffff\32\20",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "",
            "\1\57",
            "\1\60",
            "",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\12\20\7\uffff\32\20\6\uffff\32\20",
            "\1\70",
            "\12\20\7\uffff\32\20\6\uffff\32\20",
            "\12\20\7\uffff\32\20\6\uffff\32\20",
            "\12\20\7\uffff\32\20\6\uffff\32\20",
            "\12\20\7\uffff\32\20\6\uffff\32\20",
            "\1\75",
            "\1\76",
            "",
            "\12\20\7\uffff\32\20\6\uffff\32\20",
            "",
            "",
            "",
            "",
            "\12\20\7\uffff\32\20\6\uffff\32\20",
            "\12\20\7\uffff\32\20\6\uffff\13\20\1\101\16\20",
            "",
            "",
            "\1\103",
            "",
            "\12\20\7\uffff\32\20\6\uffff\32\20",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( DO | ELSE | FALSE | IF | READ | SKIP | THEN | TRUE | WHILE | WRITE | WRITELN | SEMICOLON | OPENPAREN | CLOSEPAREN | INTNUM | STRING | COMMENT | WS | ID | MULT | MINUS | PLUS | DIV | MOD | ASSIGN | EQ | LEQ | AND | NOT );";
        }
    }
 

}