package HW4_2; // Или другой пакет

public class Main {
    public static void main(String[] args) {
        ObservableStringBuilder observableStringBuilder = new ObservableStringBuilder();
        ConsoleLogger logger = new ConsoleLogger();

        observableStringBuilder.addObserver(logger);

        observableStringBuilder.append("Hello");
        observableStringBuilder.append(" World");
        observableStringBuilder.insert(5, ",");
        observableStringBuilder.delete(11, 12);

        observableStringBuilder.removeObserver(logger); // Пример удаления
        observableStringBuilder.append("!"); // Ничего не выведется в консоль
    }
}
