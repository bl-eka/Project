// OperationFactory.java
package com.example.calculator;

public interface OperationFactory {
    Operation create(String operator, double operand1, double operand2);
}
