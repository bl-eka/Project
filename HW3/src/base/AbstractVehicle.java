package base;

import engines.Engine;
import enums.FuelType;
import interfaces.Transport;

public abstract class AbstractVehicle implements Transport {
    protected Engine engine;
    protected FuelType fuelType;
    protected boolean engineRunning = false;
    protected double currentSpeed = 0;

    public AbstractVehicle(Engine engine, FuelType fuelType) {
        this.engine = engine;
        this.fuelType = fuelType;
    }

    @Override
    public void startEngine() {
        engineRunning = true;
        System.out.println("Engine started.");
    }

    @Override
    public void stopEngine() {
        engineRunning = false;
        System.out.println("Engine stopped.");
    }

    @Override
    public String getInfo() {
        return "Engine Type: " + engine.getClass().getSimpleName()
                + ", Fuel Type: " + fuelType
                + ", Engine Status: " + (engineRunning ? "Running" : "Stopped");
    }

    public abstract void move(double distance);
}
