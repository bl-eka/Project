// Vector.java
public class Vector implements IVector {
    private double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double dotProduct(IVector other) {
        return x * other.getX() + y * other.getY() + z * other.getZ();
    }

    @Override
    public IVector crossProduct(IVector other) {
        return new Vector(
                y * other.getZ() - z * other.getY(),
                z * other.getX() - x * other.getZ(),
                x * other.getY() - y * other.getX()
        );
    }

    @Override
    public double angle(IVector other) {
        double dot = dotProduct(other);
        double len1 = length();
        double len2 = other.length();
        return Math.acos(dot / (len1 * len2));
    }

    @Override
    public IVector add(IVector other) {
        return new Vector(x + other.getX(), y + other.getY(), z + other.getZ());
    }

    @Override
    public IVector subtract(IVector other) {
        return new Vector(x - other.getX(), y - other.getY(), z - other.getZ());
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
