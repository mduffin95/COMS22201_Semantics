// COMS22201: Code generation

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Cg
{
  public static void program(IRTree irt, PrintStream o)
  {
    emit(o, "XOR R0,R0,R0");   // Initialize R0 to 0
    statement(irt, o);
    emit(o, "HALT");           // Program must end with HALT
    Memory.dumpData(o);        // Dump DATA lines: initial memory contents
  }

  private static void statement(IRTree irt, PrintStream o)
  {
    if (irt.getOp().equals("SEQ")) {
      statement(irt.getSub(0), o);
      statement(irt.getSub(1), o);
    }
    else if (irt.getOp().equals("WRS") && irt.getSub(0).getOp().equals("MEM") && irt.getSub(0).getSub(0).getOp().equals("CONST")) {
      String a = irt.getSub(0).getSub(0).getSub(0).getOp();
      emit(o, "WRS "+a);
    }
    else if (irt.getOp().equals("WR")) {
      String e = expression(irt.getSub(0), o);
      emit(o, "WR "+e);
      Memory.freeRegister(e);
    }
    else if (irt.getOp().equals("MOVE")) {
    	String loc = irt.getSub(0).getSub(0).getSub(0).getOp();
    	String reg = expression(irt.getSub(1), o);
    	emit(o, "STORE "+reg+",R0,"+loc);
        Memory.freeRegister(reg);
    }
    else if (irt.getOp().equals("READ")) {
    	String loc = irt.getSub(0).getSub(0).getSub(0).getOp();
    	String reg = Memory.getRegister();
    	emit(o, "RD "+reg);
    	emit(o, "STORE "+reg+",R0,"+loc);
        Memory.freeRegister(reg);
    }
    else if (irt.getOp().equals("CJUMP")) {
    	String op = irt.getSub(0).getOp();
    	String thenLabel = irt.getSub(3).getOp();
    	String elseLabel = irt.getSub(4).getOp();
    	String left = expression(irt.getSub(1), o);
    	String right = expression(irt.getSub(2), o);
    	String reg = Memory.getRegister();

    	if (op.equals("<=")) {
    		emit(o, "SUB "+reg+","+right+","+left);
    		emit(o, "BLTZ "+reg+","+elseLabel);
    		emit(o, "JMP "+thenLabel);
    	}
    	else if (op.equals("=")) {
    		emit(o, "SUB "+reg+","+left+","+right);
    		emit(o, "BNEZ "+reg+","+elseLabel);
    		emit(o, "JMP "+thenLabel);
    	}
        Memory.freeRegister(reg);
        Memory.freeRegister(left);
        Memory.freeRegister(right);
    }
    else if (irt.getOp().equals("JUMP")) {
    	String lbl = irt.getSub(0).getSub(0).getOp();
    	emit(o, "JMP "+lbl);
    }
    else if (irt.getOp().equals("LABEL")) {
    	String lbl = irt.getSub(0).getOp();
    	emit(o, lbl + ":");
    }
    else if (irt.getOp().equals("SKIP")) {
//    	emit(o, "NOP"); //Not necessary
    }
    else {
      error(irt.getOp());
    }
  }

  private static String expression(IRTree irt, PrintStream o)
  {
    String result = Memory.getRegister();
//    System.out.println(irt.getOp());
    if (irt.getOp().equals("CONST")) {
	    String t = irt.getSub(0).getOp();
	    emit(o, "ADDI "+result+",R0,"+t);
    }
    else if (irt.getOp().equals("MEM")) {
    	String t = irt.getSub(0).getSub(0).getOp();
        emit(o, "LOAD "+result+",R0,"+t);
    }
    else if (irt.getOp().equals("BINOP")) {
    	String t = irt.getSub(0).getOp();
    	String Ra, Rb;
    	Ra = expression(irt.getSub(1), o);
    	Rb = expression(irt.getSub(2), o);
    	if (t.equals("%")) {
    		String tmp1 = Memory.getRegister();
    		String tmp2 = Memory.getRegister();
    		emit(o, "DIV "+tmp1+","+Ra+","+Rb);
    		emit(o, "MUL "+tmp2+","+tmp1+","+Rb);
    		emit(o, "SUB "+result+","+Ra+","+tmp2);
    		Memory.freeRegister(tmp1);
    		Memory.freeRegister(tmp2);
    	}
    	else {
    		String op;
	    	if (t.equals("+")) {
	    		op = "ADD ";
	    	}
	    	else if (t.equals("-")) {
	    		op = "SUB ";
	    	}
	    	else if (t.equals("*")) {
	    		op = "MUL ";
	    	}
	    	else {
	    		op = "DIV ";
	    	}
	        emit(o, op+result+","+Ra+","+Rb);
	        Memory.freeRegister(Ra);
	        Memory.freeRegister(Rb);
    	}
    	
    }
    else {
        error(irt.getOp());
    }
    return result;
  }

  private static void emit(PrintStream o, String s)
  {
    o.println(s);
  }

  private static void error(String op)
  {
    System.out.println("CG error: "+op);
    System.exit(1);
  }
}
