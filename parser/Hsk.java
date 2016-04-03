// COMS22201: IR tree construction

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Hsk {
	// The code below is generated automatically from the ".tokens" file of the
	// ANTLR syntax analysis, using the TokenConv program.
	//
// CAMLE TOKENS BEGIN
  public static final String[] tokenNames = new String[] {
"NONE", "NONE", "NONE", "NONE", "DO", "ELSE", "FALSE", "IF", "READ", "SKIP", "THEN", "TRUE", "WHILE", "WRITE", "WRITELN", "SEMICOLON", "OPENPAREN", "CLOSEPAREN", "INTNUM", "STRING", "COMMENT", "WS", "LETTER", "DIGIT", "ALPHANUM", "ID", "MULT", "MINUS", "PLUS", "DIV", "MOD", "ASSIGN", "EQ", "LEQ", "AND", "NOT"};
  public static final int CLOSEPAREN=17;
  public static final int WHILE=12;
  public static final int MOD=30;
  public static final int LETTER=22;
  public static final int ELSE=5;
  public static final int DO=4;
  public static final int SEMICOLON=15;
  public static final int NOT=35;
  public static final int MINUS=27;
  public static final int MULT=26;
  public static final int AND=34;
  public static final int ID=25;
  public static final int TRUE=11;
  public static final int WRITE=13;
  public static final int ALPHANUM=24;
  public static final int IF=7;
  public static final int INTNUM=18;
  public static final int SKIP=9;
  public static final int WS=21;
  public static final int THEN=10;
  public static final int WRITELN=14;
  public static final int READ=8;
  public static final int ASSIGN=31;
  public static final int PLUS=28;
  public static final int DIGIT=23;
  public static final int OPENPAREN=16;
  public static final int DIV=29;
  public static final int EQ=32;
  public static final int COMMENT=20;
  public static final int FALSE=6;
  public static final int STRING=19;
  public static final int LEQ=33;
// CAMLE TOKENS END

	static int lcount = 0;
	static int true_loc = Memory.allocateString("true");
	static int false_loc = Memory.allocateString("false");

	public static String getLabel() {
		return "n" + lcount++;
	}

	public static IRTree convert(CommonTree ast) {
		IRTree irt = new IRTree();
		program(ast, irt);
		return irt;
	}

	public static void program(CommonTree ast, IRTree irt) {
		statements(ast, irt);
	}

	public static void statements(CommonTree ast, IRTree irt) {
		int i;
		Token t = ast.getToken();
		int tt = t.getType();
		if (tt == SEMICOLON) {
			IRTree irt1 = new IRTree();
			IRTree irt2 = new IRTree();
			CommonTree ast1 = (CommonTree) ast.getChild(0);
			CommonTree ast2 = (CommonTree) ast.getChild(1);
			statements(ast1, irt1);
			statements(ast2, irt2);
			irt.setOp("Comp");
			irt.addSub(irt1);
			irt.addSub(irt2);
		} else {
			statement(ast, irt);
		}
	}

	public static void statement(CommonTree ast, IRTree irt) {
		CommonTree ast1, ast2, ast3;
		IRTree irt1 = new IRTree(), irt2 = new IRTree(), irt3 = new IRTree();
		Token t = ast.getToken();
		int tt = t.getType();
		switch (tt) {
		case WRITE:
			ast1 = (CommonTree) ast.getChild(0);
			String type = arg(ast1, irt1);
			if (type.equals("int")) {
				irt.setOp("WriteA");
				irt.addSub(irt1);
			} else if (type.equals("bool")) {
				irt.setOp("WriteB");
				break;

			} else {
				irt.setOp("WriteS");
				irt.addSub(irt1);
			}
			break;
		case WRITELN:
			// String a = String.valueOf(Memory.allocateString("\n"));
			irt.setOp("WriteLn");
			break;
		case ASSIGN:
			irt.setOp("Ass");
			// VARIABLE
			irt1.setOp('"' + ast.getChild(0).getText() + '"');

			// VALUE
			arg((CommonTree) ast.getChild(1), irt2);
			irt.addSub(irt1);
			irt.addSub(irt2);
			break;
		case READ:
			irt.setOp("Read");
			irt1.setOp('"' + ast.getChild(0).getText() + '"');
			irt.addSub(irt1);
			break;
		case IF:
      irt.setOp("If");
//			IRTree trans = cjump((CommonTree)ast.getChild(0), thenLabel, elseLabel);
      boolexp((CommonTree) ast.getChild(0), irt1);
			statements((CommonTree) ast.getChild(1), irt2); // Then
			statements((CommonTree) ast.getChild(2), irt3); // Else
      irt.addSub(irt1);
      irt.addSub(irt2);
      irt.addSub(irt3);
			break;
		case WHILE:

			irt.setOp("While");
      boolexp((CommonTree) ast.getChild(0), irt1);
			statements((CommonTree) ast.getChild(1), irt2); // While contents
      irt.addSub(irt1);
      irt.addSub(irt2);

			break;
		case SKIP:
			irt.setOp("Skip");
			break;
		default:
			error(tt);
			break;
		}
	}

	public static IRTree cjump(CommonTree ast, String n1, String n2) {
		String op = ast.getText();
		IRTree irt1 = new IRTree(), irt2 = new IRTree();
		expression((CommonTree) ast.getChild(0), irt1); // Const 1
		expression((CommonTree) ast.getChild(1), irt2); // Const 2
		IRTree cj = new IRTree("CJUMP", new IRTree(op), irt1, irt2);
		cj.addSub(new IRTree(n1));
		cj.addSub(new IRTree(n2));
		return cj;
	}

	public static void ifthenelse(IRTree root, IRTree trans, IRTree s1, IRTree s2, String n1, String n2) {
		String end = Irt.getLabel();
		root.setOp("SEQ");
		root.addSub(trans);
		root.addSub(new IRTree("SEQ",
						new IRTree("LABEL", new IRTree(n1)),
						new IRTree("SEQ",
								s1,
								new IRTree("SEQ",
										new IRTree("JUMP", new IRTree("NAME", new IRTree(end))),
										new IRTree("SEQ",
												new IRTree("LABEL", new IRTree(n2)),
												new IRTree("SEQ",
														s2,
														new IRTree("LABEL", new IRTree(end)))
										)
								)
						)
				));
	}

	public static void boolexp(CommonTree ast, IRTree irt) {
		Token t = ast.getToken();
		int tt = t.getType();
		IRTree irt1 = new IRTree(), irt2 = new IRTree();
    if ( ast.getChildCount() == 0 ) {
      if ( tt == TRUE ) irt.setOp("TRUE");
      else irt.setOp("FALSE");
    }
    else if ( ast.getChildCount() == 1 ) {
      boolexp((CommonTree) ast.getChild(0), irt1);
      irt.addSub(irt1);
      if (tt == NOT) irt.setOp("Neg");
    }
    else {
      if (tt == AND) {
        boolexp((CommonTree) ast.getChild(0), irt1);
        boolexp((CommonTree) ast.getChild(1), irt2);
        irt.setOp("And");
      }
      else {
        expression((CommonTree) ast.getChild(0), irt1);
        expression((CommonTree) ast.getChild(1), irt2);
        if ( tt == EQ ) irt.setOp("Eq");
        else if ( tt == LEQ ) irt.setOp("Le");
      }
      irt.addSub(irt1);
      irt.addSub(irt2);
    }
  }


	public static String arg(CommonTree ast, IRTree irt) {
		Token t = ast.getToken();
		int tt = t.getType();
		if (tt == STRING) {
			String tx = t.getText();
			// int a = Memory.allocateString(tx);
			// String st = String.valueOf(a);
			irt.setOp('"' + tx + '"');
			return "string";
		} else if (isBool(tt)) {
//			expression(ast, irt);
			return "bool";
		} else {
			expression(ast, irt);
			return "int";
		}
	}

	public static boolean isBool(int t) {
		if (t == AND || t == LEQ || t == EQ || t == NOT || t == TRUE
				|| t == FALSE) {
			return true;
		}
		return false;
	}

	public static void expression(CommonTree ast, IRTree irt) {
		CommonTree ast1;
		IRTree irt1 = new IRTree(), irt2 = new IRTree();
		Token t = ast.getToken();
		int tt = t.getType();
		if (tt == INTNUM) {
			constant(ast, irt1);
			irt.setOp("N");
			irt.addSub(irt1);
		}
		else if (tt == ID) {
			irt.setOp("V");
      irt1.setOp('"' + t.getText() + '"');
      irt.addSub(irt1);
		}
		else {
			if (tt == MINUS) {
				if(ast.getChildCount() == 1) {
          irt.setOp("N");
					irt1.setOp(t.getText());
					irt.addSub(irt1);
				}
				else {
          irt.setOp("Sub");
					expression((CommonTree) ast.getChild(0), irt1);
					expression((CommonTree) ast.getChild(1), irt2);
				}
			}
			else {
				expression((CommonTree) ast.getChild(0), irt1);
				expression((CommonTree) ast.getChild(1), irt2);
				if (tt == MULT)       irt.setOp("Mult");
				else if (tt == PLUS)  irt.setOp("Add");
			}
			irt.addSub(irt1);
			irt.addSub(irt2);
		}
	}

	public static void constant(CommonTree ast, IRTree irt) {
		Token t = ast.getToken();
		int tt = t.getType();
		if (tt == INTNUM) {
			String tx = t.getText();
			irt.setOp(tx);
		} else {
			error(tt);
		}
	}

	private static void error(int tt) {
		System.out.println("IRT error: " + tokenNames[tt]);
		System.exit(1);
	}
}
