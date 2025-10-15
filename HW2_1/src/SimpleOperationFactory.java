// SimpleOperationFactory.java
package com.example.calculator;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Constructor;

public class SimpleOperationFactory implements OperationFactory {

    private final Map<String, Class<? extends Operation>> operationMap = new HashMap<>();

    public SimpleOperationFactory() {
        operationMap.put("+", Addition.class);
        operationMap.put("-", Subtraction.class);
        operationMap.put("*", Multiplication.class);
        operationMap.put("/", Division.class);
    }

    @Override
    public Operation create(String operator, double operand1, double operand2) {
        Class<? extends Operation> operationClass = operationMap.get(operator);

        if (operationClass == null) {
            throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }

        try {
            Constructor<? extends Operation> constructor = operationClass.getDeclaredConstructor(double.class, double.class);
            return constructor.newInstance(operand1, operand2);
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка при создании операции: " + operator, e);
        }
    }
}
