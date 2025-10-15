package engines;

public class DieselEngine implements Engine {
    private final int horsepower;
    private final double fuelEfficiency;

    public DieselEngine(int horsepower, double fuelEfficiency) {
        this.horsepower = horsepower;
        this.fuelEfficiency = fuelEfficiency;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }
}
