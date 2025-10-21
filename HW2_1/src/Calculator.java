import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static final Map<String, Operation> operators = new HashMap<>();

    static {
        operators.put("+", new Addition(0, 0));
        operators.put("-", new Subtraction(0, 0));
        operators.put("*", new Multiplication(0, 0));
        operators.put("/", new Division(0, 0));
    }

    public double calculate(String expression) {
        // Валидируем выражение
        Validator.isValidExpression(expression);

        String[] parts = expression.trim().split(" ");
        double operand1 = Double.parseDouble(parts[0]);
        double operand2 = Double.parseDouble(parts[2]);
        String operator = parts[1];

        // Получаем нужную операцию
        Operation operation = operators.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }

        // Устанавливаем операнды
        operation.operand1 = operand1;
        operation.operand2 = operand2;

        // Выполняем вычисление
        return operation.calculate();
    }
}
