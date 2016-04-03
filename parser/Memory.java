// COMS22201: Memory allocation for strings

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.io.*;

public class Memory {

  static ArrayList<Byte> memory = new ArrayList<Byte>();
  static HashMap<String, Integer> variables = new HashMap<String, Integer>();
  static int reg_count = 1;
  static ArrayDeque<String> used_registers = new ArrayDeque<String>();

  static public int allocateString(String text)
  {
    int addr = memory.size();
    int size = text.length();
    for (int i=0; i<size; i++) {
      memory.add(new Byte("", text.charAt(i)));
    }
    memory.add(new Byte("", 0));
    return addr;
  }

  static public int allocateVar(String text) {
    int result;
    if(variables.containsKey(text)) {
      result = variables.get(text);
    }
    else {
      while (memory.size()%4 != 0) {
        memory.add(new Byte("",0));
      }
      result = memory.size();
      variables.put(text, result);
      for (int i=0; i<4; i++)
        memory.add(new Byte(text, 0));

    }
    return result;
  }

  static public String getRegister() {
    String result;
    if (used_registers.isEmpty()) {
        result = "R"+reg_count;
        reg_count++;
    }
    else {
        result = used_registers.poll();
        // System.out.println(result);
    }
    return result;
  }

  static public void freeRegister(String free_reg) {
      used_registers.add(free_reg);
  }

  static public void dumpData(PrintStream o)
  {
    Byte b;
    String s;
    int c;
    int size = memory.size();
    for (int i=0; i<size; i++) {
      b = memory.get(i);
      c = b.getContents();
      if (c >= 32) {
        s = String.valueOf((char)c);
      }
      else {
        s = ""; // "\\"+String.valueOf(c);
      }
      o.println("DATA "+c+" ; "+s+" "+b.getName());
    }
  }
}

class Byte {
  String varname;
  int contents;

  Byte(String n, int c)
  {
    varname = n;
    contents = c;
  }

  String getName()
  {
    return varname;
  }

  int getContents()
  {
    return contents;
  }
}
