package vehicles;

import base.AbstractVehicle;
import engines.Engine;
import enums.FuelType;

public class Ship extends AbstractVehicle {
    private final int tonnage;
    private final double draft; // осадка в метрах

    public Ship(Engine engine, FuelType fuelType, int tonnage, double draft) {
        super(engine, fuelType);
        this.tonnage = tonnage;
        this.draft = draft;
    }

    @Override
    public void move(double distance) {
        if (engineRunning) {
            System.out.println("Sailing " + distance + " km...");
            currentSpeed = 30; // условная скорость
        } else {
            System.out.println("Start the engine first.");
        }
    }

    @Override
    public String getInfo() {
        return "Ship: " + super.getInfo()
                + ", Tonnage: " + tonnage
                + ", Draft: " + draft + " m";
    }
}
