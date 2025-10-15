// Calculator.java
package com.example.calculator;

public class Calculator {
    private final OperationFactory operationFactory;

    public Calculator(OperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    public double calculate(ParsedExpression parsedExpression) {
        Operation operation = operationFactory.create(parsedExpression.getOperator(), parsedExpression.getOperand1(), parsedExpression.getOperand2());
        return operation.calculate();
    }
}
