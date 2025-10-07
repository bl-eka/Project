// Vector.java
// Этот класс представляет вектор в трехмерном пространстве.
import java.util.Random; // Для генерации случайных векторов.

public class Vector { // Объявление класса Vector.  Только ОДНО такое объявление должно быть в файле.
    // Поля класса: координаты x, y и z.
    private final double x;
    private final double y;
    private final double z;

    // Конструктор класса: принимает координаты x, y и z в качестве аргументов.
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Геттеры для получения значений координат.
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    // Метод для вычисления длины вектора.
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Метод для вычисления скалярного произведения двух векторов.
    public double dotProduct(Vector other) {
        return x * other.x + y * other.y + z * other.z;
    }

    // Метод для вычисления векторного произведения двух векторов.
    public Vector crossProduct(Vector other) {
        double newX = y * other.z - z * other.y;
        double newY = z * other.x - x * other.z;
        double newZ = x * other.y - y * other.x;
        return new Vector(newX, newY, newZ);
    }

    // Метод для вычисления угла между двумя векторами в радианах.
    public double angle(Vector other) {
        double dotProduct = dotProduct(other);
        double length1 = length();
        double length2 = other.length();
        return Math.acos(dotProduct / (length1 * length2));
    }

    // Метод для сложения двух векторов.
    public Vector add(Vector other) {
        return new Vector(x + other.x, y + other.y, z + other.z);
    }

    // Метод для вычитания двух векторов.
    public Vector subtract(Vector other) {
        return new Vector(x - other.x, y - other.y, z - other.z);
    }

    // Статический метод для создания массива случайных векторов.
    public static Vector[] generateRandomVectors(int n) {
        Vector[] vectors = new Vector[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double z = random.nextDouble();
            vectors[i] = new Vector(x, y, z);
        }
        return vectors;
    }

    // Метод toString() для представления вектора в виде строки.
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
