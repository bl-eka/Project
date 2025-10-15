// Validator.java
package com.example.calculator;

public class Validator {
    public boolean isValidExpression(String expression) {
        // TODO:  Реализовать более сложную логику валидации
        // Например, проверить, что есть два числа и один оператор,
        // и что оператор является допустимым.
        String[] parts = expression.split(" ");
        if (parts.length != 3) {
            return false;
        }
        String operator = parts[1];
        return "+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator);
    }
}
