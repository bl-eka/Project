// Main.java
package com.example.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        ExpressionParser parser = new ExpressionParser(validator);
        SimpleOperationFactory operationFactory = new SimpleOperationFactory();
        Calculator calculator = new Calculator(operationFactory);

        System.out.println("Введите выражение (например, 2 + 2):");
        String expression = scanner.nextLine();

        try {
            ParsedExpression parsedExpression = parser.parse(expression);
            double result = calculator.calculate(parsedExpression);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
