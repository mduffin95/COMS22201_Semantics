// COMS22201: IR tree construction

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Irt {
	// The code below is generated automatically from the ".tokens" file of the
	// ANTLR syntax analysis, using the TokenConv program.
	//
// CAMLE TOKENS BEGIN
  public static final String[] tokenNames = new String[] {
"NONE", "NONE", "NONE", "NONE", "DO", "ELSE", "FALSE", "IF", "READ", "SKIP", "THEN", "TRUE", "WHILE", "WRITE", "WRITELN", "SEMICOLON", "OPENPAREN", "CLOSEPAREN", "INTNUM", "STRING", "COMMENT", "WS", "LETTER", "DIGIT", "ALPHANUM", "ID", "MULT", "MINUS", "PLUS", "DIV", "MOD", "ASSIGN", "EQ", "LEQ", "AND", "NOT"};
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
			irt.setOp("SEQ");
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
				irt.setOp("WR");
				irt.addSub(irt1);
			} else if (type.equals("bool")) {
				//Boolean expression: generate if statement.
				String thenLabel = Irt.getLabel();
				String elseLabel = Irt.getLabel();
				IRTree trans = translate((CommonTree) ast.getChild(0), thenLabel, elseLabel);

				String trst = String.valueOf(true_loc);
				irt1.setOp("WRS");
				irt1.addSub(new IRTree("MEM", new IRTree("CONST", new IRTree(trst))));
				String flst = String.valueOf(false_loc);
				irt2.setOp("WRS");
				irt2.addSub(new IRTree("MEM", new IRTree("CONST", new IRTree(flst))));
				ifthenelse(irt, trans, irt1, irt2, thenLabel, elseLabel);
				break;

			} else {
				irt.setOp("WRS");
				irt.addSub(irt1);
			}
			break;
		case WRITELN:
			String a = String.valueOf(Memory.allocateString("\n"));
			irt.setOp("WRS");
			irt.addSub(new IRTree("MEM", new IRTree("CONST", new IRTree(a))));
			break;
		case ASSIGN:
			irt.setOp("MOVE");
			// VARIABLE
			expression((CommonTree) ast.getChild(0), irt1);

			// VALUE
			arg((CommonTree) ast.getChild(1), irt2);
			irt.addSub(irt1);
			irt.addSub(irt2);
			break;
		case READ:
			irt.setOp("READ");
			expression((CommonTree) ast.getChild(0), irt1);
			irt.addSub(irt1);
			break;
		case IF:
			String thenLabel = Irt.getLabel();
			String elseLabel = Irt.getLabel();
			IRTree trans = translate((CommonTree) ast.getChild(0), thenLabel, elseLabel);
//			IRTree trans = cjump((CommonTree)ast.getChild(0), thenLabel, elseLabel);
			statements((CommonTree) ast.getChild(1), irt1); // Then
			statements((CommonTree) ast.getChild(2), irt2); // Else
			ifthenelse(irt, trans, irt1, irt2, thenLabel, elseLabel);
			break;
		case WHILE:

			irt.setOp("SEQ");
			String beginLabel = Irt.getLabel();
			thenLabel = Irt.getLabel();
			String endLabel = Irt.getLabel();
			statements((CommonTree) ast.getChild(1), irt1); // While contents
			trans = translate((CommonTree) ast.getChild(0), thenLabel, endLabel);
//			IRTree cj = cjump((CommonTree) ast.getChild(0), thenLabel, endLabel);
			irt.addSub(new IRTree("LABEL", new IRTree(beginLabel)));
			irt.addSub(new IRTree("SEQ", trans, new IRTree("SEQ", new IRTree(
					"LABEL", new IRTree(thenLabel)), new IRTree("SEQ", irt1,
					new IRTree("SEQ", new IRTree("JUMP", new IRTree("NAME",
							new IRTree(beginLabel))), new IRTree("LABEL",
							new IRTree(endLabel)))))));

			break;
		case SKIP:
			irt.setOp("SKIP");
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

	public static IRTree translate(CommonTree ast, String n1, String n2) {
		Token t = ast.getToken();
		int tt = t.getType();
		IRTree irt1, irt2, result = null;
		if (tt == AND) {
			String next = Irt.getLabel();
			irt1 = translate((CommonTree) ast.getChild(0), next, n2);
			irt2 = translate((CommonTree) ast.getChild(1), n1, n2);
			result = new IRTree("SEQ", irt1, new IRTree("SEQ", new IRTree(
					"LABEL", new IRTree(next)), irt2));
		} else if (tt == NOT) {
			result = translate((CommonTree) ast.getChild(0), n2, n1);
		} else if (tt == EQ || tt == LEQ) { // Turn into CJUMP
			result = cjump(ast, n1, n2);
		} else if (tt == TRUE) {
			result = new IRTree("JUMP", new IRTree("NAME", new IRTree(n1)));
		} else if (tt == FALSE) {
			result = new IRTree("JUMP", new IRTree("NAME", new IRTree(n2)));
		}
		return result;
	}

	public static String arg(CommonTree ast, IRTree irt) {
		Token t = ast.getToken();
		int tt = t.getType();
		if (tt == STRING) {
			String tx = t.getText();
			int a = Memory.allocateString(tx);
			String st = String.valueOf(a);
			irt.setOp("MEM");
			irt.addSub(new IRTree("CONST", new IRTree(st)));
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
			irt.setOp("CONST");
			irt.addSub(irt1);
		}
		else if (tt == ID) {
			irt.setOp("MEM");
			irt.addSub(new IRTree("CONST", new IRTree(Integer.toString(Memory
					.allocateVar(t.getText())))));
		}
		else {
			irt.setOp("BINOP");
			if (tt == MINUS) {
				if(ast.getChildCount() == 1) {
					irt1.setOp("CONST");
					irt1.addSub(new IRTree("0"));
					expression((CommonTree) ast.getChild(0), irt2);
				}
				else {
					expression((CommonTree) ast.getChild(0), irt1);
					expression((CommonTree) ast.getChild(1), irt2);
				}
				irt.addSub(new IRTree("-"));
			}
			else {
				expression((CommonTree) ast.getChild(0), irt1);
				expression((CommonTree) ast.getChild(1), irt2);
				if (tt == MULT) 		irt.addSub(new IRTree("*"));
				else if (tt == DIV) 	irt.addSub(new IRTree("/"));
				else if (tt == MOD) 	irt.addSub(new IRTree("%"));
				else if (tt == PLUS)	irt.addSub(new IRTree("+"));
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
