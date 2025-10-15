// SimpleParsedExpression.java
package com.example.calculator;

public class SimpleParsedExpression implements ParsedExpression {
    private final double operand1;
    private final double operand2;
    private final String operator;

    public SimpleParsedExpression(double operand1, double operand2, String operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    @Override
    public double getOperand1() {
        return operand1;
    }

    @Override
    public double getOperand2() {
        return operand2;
    }

    @Override
    public String getOperator() {
        return operator;
    }
}
