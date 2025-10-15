package vehicles;

import base.AbstractVehicle;
import engines.Engine;
import enums.FuelType;

public class Airplane extends AbstractVehicle {
    private final int numberOfEngines;
    private final double wingSpan; // в метрах

    public Airplane(Engine engine, FuelType fuelType, int numberOfEngines, double wingSpan) {
        super(engine, fuelType);
        this.numberOfEngines = numberOfEngines;
        this.wingSpan = wingSpan;
    }

    @Override
    public void move(double distance) {
        if (engineRunning) {
            System.out.println("Flying " + distance + " km...");
            currentSpeed = 800; // условная скорость
        } else {
            System.out.println("Start the engine first.");
        }
    }

    @Override
    public String getInfo() {
        return "Airplane: " + super.getInfo()
                + ", Engines: " + numberOfEngines
                + ", Wingspan: " + wingSpan + " m";
    }
}
