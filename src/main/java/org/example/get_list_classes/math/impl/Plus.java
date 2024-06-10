package org.example.get_list_classes.math.impl;


import org.example.get_list_classes.math.Operationable;
import org.example.get_list_classes.math.Tokenable;

public class Plus implements Tokenable, Operationable {
  private final String TOKEN = "+";

  private final int PRIORITY = 2;

    @Override
    public String getToken() {
        return TOKEN;
    }
    @Override
    public int getPriority() {
        return PRIORITY;
    }
    @Override
    public double doOperation(double... operands) {
       return operands[0] + operands[1];
    }
}
