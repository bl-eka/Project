// Main.java
public class Main {
    public static void main(String[] args) {
        IVector v1 = new Vector(1, 2, 3);
        IVector v2 = new Vector(4, 5, 6);

        System.out.println("Vector 1: " + v1);
        System.out.println("Vector 2: " + v2);
        System.out.println("Length of Vector 1: " + v1.length());
        System.out.println("Dot product: " + v1.dotProduct(v2));
        System.out.println("Cross product: " + v1.crossProduct(v2));
        System.out.println("Angle: " + v1.angle(v2));
        System.out.println("Add: " + v1.add(v2));
        System.out.println("Subtract: " + v1.subtract(v2));
    }
}
