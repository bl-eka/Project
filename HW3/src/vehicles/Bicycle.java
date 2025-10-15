package vehicles;

import interfaces.Transport;

public class Bicycle implements Transport {
    private final int numberOfGears;
    private final String type;

    public Bicycle(int numberOfGears, String type) {
        this.numberOfGears = numberOfGears;
        this.type = type;
    }

    @Override
    public void startEngine() {
        System.out.println("No engine to start.");
    }

    @Override
    public void stopEngine() {
        System.out.println("No engine to stop.");
    }

    @Override
    public void move(double distance) {
        System.out.println("Riding " + distance + " km...");
    }

    @Override
    public String getInfo() {
        return "Bicycle: Gears: " + numberOfGears + ", Type: " + type;
    }
}
