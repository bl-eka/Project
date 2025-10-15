// Operation.java
package com.example.calculator;

public abstract class Operation {
    protected final double operand1;
    protected final double operand2;

    public Operation(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public abstract double calculate();

}
