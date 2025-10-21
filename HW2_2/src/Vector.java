import java.util.Random;

public class Vector {
    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double dotProduct(Vector other) {
        if (other == null) throw new IllegalArgumentException("Вектор не может быть null.");
        return x * other.x + y * other.y + z * other.z;
    }

    public Vector crossProduct(Vector other) {
        if (other == null) throw new IllegalArgumentException("Вектор не может быть null.");
        return new Vector(
                y * other.z - z * other.y,
                z * other.x - x * other.z,
                x * other.y - y * other.x
        );
    }

    public double angle(Vector other) {
        if (other == null) throw new IllegalArgumentException("Вектор не может быть null.");
        double dotProduct = dotProduct(other);
        double length1 = length();
        double length2 = other.length();
        if (length1 == 0 || length2 == 0) {
            throw new ArithmeticException("Длина одного из векторов равна нулю, нельзя вычислить угол.");
        }
        return Math.acos(dotProduct / (length1 * length2));
    }

    public Vector add(Vector other) {
        if (other == null) throw new IllegalArgumentException("Вектор не может быть null.");
        return new Vector(x + other.x, y + other.y, z + other.z);
    }

    public Vector subtract(Vector other) {
        if (other == null) throw new IllegalArgumentException("Вектор не может быть null.");
        return new Vector(x - other.x, y - other.y, z - other.z);
    }

    public static Vector[] generateRandomVectors(int n) {
        if (n <= 0) throw new IllegalArgumentException("Количество векторов должно быть положительным.");
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

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
