// Main.java
// Этот класс содержит метод main, который создает и тестирует класс Vector.
public class Main { // Объявление класса Main.
    public static void main(String[] args) { // Объявление метода main.
        // Создаем два экземпляра класса Vector.
        Vector vector1 = new Vector(1, 2, 3);
        Vector vector2 = new Vector(4, 5, 6);

        // Выводим информацию о векторах в консоль.
        System.out.println("Vector 1: " + vector1);
        System.out.println("Vector 2: " + vector2);

        // Вычисляем и выводим длину вектора 1.
        System.out.println("Length of vector 1: " + vector1.length());

        // Вычисляем и выводим скалярное произведение векторов 1 и 2.
        System.out.println("Dot product: " + vector1.dotProduct(vector2));

        // Вычисляем и выводим векторное произведение векторов 1 и 2.
        System.out.println("Cross product: " + vector1.crossProduct(vector2));

        // Вычисляем и выводим угол между векторами 1 и 2.
        System.out.println("Angle: " + vector1.angle(vector2));

        // Вычисляем и выводим сумму векторов 1 и 2.
        System.out.println("Sum: " + vector1.add(vector2));

        // Вычисляем и выводим разность векторов 1 и 2.
        System.out.println("Difference: " + vector1.subtract(vector2));

        // Создаем массив из 5 случайных векторов и выводим их в консоль.
        Vector[] randomVectors = Vector.generateRandomVectors(5);
        System.out.println("Random vectors:");
        for (Vector vector : randomVectors) {
            System.out.println(vector);
        }
    }
}
