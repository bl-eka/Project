// IVector.java
public interface IVector {
    double getX();
    double getY();
    double getZ();
    double length();
    double dotProduct(IVector other);
    IVector crossProduct(IVector other);
    double angle(IVector other);
    IVector add(IVector other);
    IVector subtract(IVector other);
    String toString();
}
