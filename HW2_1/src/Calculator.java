// Calculator.java
public class Calculator {
    public double calculate(String expression) {
        String[] parts = expression.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат выражения. Используйте 'число оператор число'.");
        }    double operand1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double operand2 = Double.parseDouble(parts[2]);

        Operation operation = createOperation(operand1, operator, operand2);
        return operation.calculate();
    }

    private Operation createOperation(double operand1, String operator, double operand2) {
        switch (operator) {
            case "+":
                return new Addition(operand1, operand2);
            case "-":
                return new Subtraction(operand1, operand2);
            case "*":
                return new Multiplication(operand1, operand2);
            case "/":
                return new Division(operand1, operand2);
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }
    }

}
