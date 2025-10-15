package HW4_2; // Или другой пакет

import java.util.ArrayList;
import java.util.List;

public class ObservableStringBuilder {
    private StringBuilder stringBuilder = new StringBuilder();
    private List<StringBuilderObserver> observers = new ArrayList<>();

    public ObservableStringBuilder append(String str) {
        stringBuilder.append(str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        notifyObservers();
        return this;
    }

    // Добавьте другие методы StringBuilder, которые вы хотите делегировать

    public String toString() {
        return stringBuilder.toString();
    }

    public void addObserver(StringBuilderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StringBuilderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (StringBuilderObserver observer : observers) {
            observer.onStringBuilderChanged(this);
        }
    }
}
