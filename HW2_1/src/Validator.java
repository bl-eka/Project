public class Validator {
    public static boolean isValidExpression(String expression) {
        // Проверяем, что строка не пустая
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Выражение не может быть пустым.");
        }

        // Разделяем строку на части
        String[] parts = expression.trim().split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Некорректный формат выражения. Пример: 2 + 2");
        }

        // Проверяем, что первый и последний элементы — числа
        try {
            Double.parseDouble(parts[0]);
            Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректный формат числа.");
        }

        // Проверяем, что оператор допустим
        String operator = parts[1];
        if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
            throw new IllegalArgumentException("Некорректный оператор. Допустимые операторы: +, -, *, /");
        }

        return true;
    }
}
