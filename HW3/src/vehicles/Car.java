package vehicles;

import base.AbstractVehicle;
import engines.Engine;
import enums.FuelType;

public class Car extends AbstractVehicle {
    private final int numberOfSeats;
    private final String bodyType;

    public Car(Engine engine, FuelType fuelType, int numberOfSeats, String bodyType) {
        super(engine, fuelType);
        this.numberOfSeats = numberOfSeats;
        this.bodyType = bodyType;
    }

    @Override
    public void move(double distance) {
        if (engineRunning) {
            System.out.println("Driving " + distance + " km...");
            currentSpeed = 60; // условная скорость
        } else {
            System.out.println("Start the engine first.");
        }
    }

    @Override
    public String getInfo() {
        return "Car: " + super.getInfo()
                + ", Seats: " + numberOfSeats
                + ", Body Type: " + bodyType;
    }
}
