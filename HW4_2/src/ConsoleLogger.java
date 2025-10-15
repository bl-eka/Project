package HW4_2; // Или другой пакет

public class ConsoleLogger implements StringBuilderObserver {
    @Override
    public void onStringBuilderChanged(ObservableStringBuilder builder) {
        System.out.println("StringBuilder changed: " + builder.toString());
    }
}
