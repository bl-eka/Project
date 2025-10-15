// ExpressionParser.java
package com.example.calculator;

public class ExpressionParser {

    private final Validator validator;

    public ExpressionParser(Validator validator) {
        this.validator = validator;
    }

    public ParsedExpression parse(String expression) {
        String[] parts = expression.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат выражения. Используйте 'число оператор число'.");
        }

        double operand1;
        double operand2;
        String operator = parts[1];

        try {
            operand1 = Double.parseDouble(parts[0]);
            operand2 = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Операнды должны быть числами.", e);
        }


        if (!validator.isValidExpression(expression)) {
            throw new IllegalArgumentException("Невалидное выражение");
        }

        return new SimpleParsedExpression(operand1, operand2, operator);
    }
}
