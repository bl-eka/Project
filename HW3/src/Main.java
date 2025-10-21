import java.util.Scanner;

// Интерфейс Транспорт
interface Transport {
    void startEngine();
    void stopEngine();
    void move(double distance);
    double getSpeed();
    String getInfo();
}

// Класс Велосипед
class Bicycle implements Transport {
    private final int numberOfGears;
    private final String type;
    private double currentSpeed = 0;

    public Bicycle(int numberOfGears, String type) {
        this.numberOfGears = numberOfGears;
        this.type = type;
    }

    @Override
    public void startEngine() {
        System.out.println("Bicycle has no engine.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Bicycle has no engine to stop.");
    }

    @Override
    public void move(double distance) {
        System.out.println("Cycling " + distance + " km...");
        currentSpeed = 20; // условная скорость
    }

    @Override
    public double getSpeed() {
        return currentSpeed;
    }

    @Override
    public String getInfo() {
        return "Bicycle: " + type + ", Gears: " + numberOfGears + ", Speed: " + currentSpeed + " km/h";
    }
}

// Класс Двигатель
abstract class Engine {
    private final int power;

    protected Engine(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    // Подклассы двигателей
    static class GasolineEngine extends Engine {
        private final double fuelConsumption;

        public GasolineEngine(int power, double fuelConsumption) {
            super(power);
            this.fuelConsumption = fuelConsumption;
        }
    }

    static class DieselEngine extends Engine {
        private final double fuelConsumption;

        public DieselEngine(int power, double fuelConsumption) {
            super(power);
            this.fuelConsumption = fuelConsumption;
        }
    }

    static class ElectricEngine extends Engine {
        private final int batteryCapacity;

        public ElectricEngine(int power, int batteryCapacity) {
            super(power);
            this.batteryCapacity = batteryCapacity;
        }
    }

    static class JetEngine extends Engine {
        public JetEngine(int power) {
            super(power);
        }
    }
}

// Класс Автомобиль
class Car implements Transport {
    private final Engine engine;
    private final String fuelType;
    private final int numberOfSeats;
    private final String model;
    private double currentSpeed = 0;

    public Car(Engine engine, String fuelType, int numberOfSeats, String model) {
        this.engine = engine;
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.model = model;
    }

    @Override
    public void startEngine() {
        System.out.println(model + " engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println(model + " engine stopped.");
    }

    @Override
    public void move(double distance) {
        System.out.println("Driving " + distance + " km in " + model + "...");
        currentSpeed = 80; // условная скорость
    }

    @Override
    public double getSpeed() {
        return currentSpeed;
    }

    @Override
    public String getInfo() {
        return "Car: " + model + ", Seats: " + numberOfSeats + ", Fuel: " + fuelType + ", Speed: " + currentSpeed + " km/h";
    }
}

// Класс Самолет
class Airplane implements Transport {
    private final Engine engine;
    private final String fuelType;
    private final int numberOfEngines;
    private double currentSpeed = 0;
    private final double altitude;

    public Airplane(Engine engine, String fuelType, int numberOfEngines, double altitude) {
        this.engine = engine;
        this.fuelType = fuelType;
        this.numberOfEngines = numberOfEngines;
        this.altitude = altitude;
    }

    @Override
    public void startEngine() {
        System.out.println("Airplane engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Airplane engine stopped.");
    }

    @Override
    public void move(double distance) {
        System.out.println("Flying " + distance + " km...");
        currentSpeed = 250; // условная скорость
    }

    @Override
    public double getSpeed() {
        return currentSpeed;
    }

    @Override
    public String getInfo() {
        return "Airplane: " + ", Engines: " + numberOfEngines + ", Fuel: " + fuelType + ", Speed: " + currentSpeed + " km/h, Altitude: " + altitude + " m";
    }
}

// Класс Корабль
class Ship implements Transport {
    private final Engine engine;
    private final String fuelType;
    private final int tonnage;
    private double currentSpeed = 0;

    public Ship(Engine engine, String fuelType, int tonnage, double currentSpeed) {
        this.engine = engine;
        this.fuelType = fuelType;
        this.tonnage = tonnage;
        this.currentSpeed = currentSpeed;
    }

    @Override
    public void startEngine() {
        System.out.println("Ship engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Ship engine stopped.");
    }

    @Override
    public void move(double distance) {
        System.out.println("Sailing " + distance + " km...");
        currentSpeed = 30; // условная скорость
    }

    @Override
    public double getSpeed() {
        return currentSpeed;
    }

    @Override
    public String getInfo() {
        return "Ship: " + ", Tonnage: " + tonnage + " tons, Fuel: " + fuelType + ", Speed: " + currentSpeed + " km/h";
    }
}

// Главный класс программы
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаём двигатели
        Engine gasolineEngine = new Engine.GasolineEngine(150, 0.3);
        Engine dieselEngine = new Engine.DieselEngine(500, 0.2);
        Engine electricEngine = new Engine.ElectricEngine(400, 85);
        Engine jetEngine = new Engine.JetEngine(500);

        // Транспортные средства
        Car myCar = new Car(gasolineEngine, "Gasoline", 5, "Sedan");
        Airplane myPlane = new Airplane(jetEngine, "Jet Fuel", 2, 35.5);
        Ship myShip = new Ship(dieselEngine, "Diesel", 1200, 6.0);
        Bicycle myBike = new Bicycle(21, "Mountain");

        // Массив с элементами типа Transport
        Transport[] fleet = {myCar, myPlane, myShip, myBike};

        // Простое меню
        while (true) {
            System.out.println("\nChoose a transport:");
            System.out.println("1. Car");
            System.out.println("2. Airplane");
            System.out.println("3. Ship");
            System.out.println("4. Bicycle");
            System.out.println("5. Exit");

            int choice = getInput(scanner);

            if (choice == 5) break;

            Transport selected;
            switch (choice) {
                case 1 -> selected = myCar;
                case 2 -> selected = myPlane;
                case 3 -> selected = myShip;
                case 4 -> selected = myBike;
                default -> {
                    System.out.println("Invalid choice");
                    continue;
                }
            }

            System.out.println("\nChoose an action:");
            System.out.println("1. Start Engine");
            System.out.println("2. Move");
            System.out.println("3. Stop Engine");
            System.out.println("4. Get Info");

            int action = getInput(scanner);

            switch (action) {
                case 1 -> selected.startEngine();
                case 2 -> {
                    System.out.print("Enter distance (km): ");
                    double distance = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    selected.move(distance);
                }
                case 3 -> selected.stopEngine();
                case 4 -> System.out.println(selected.getInfo());
                default -> System.out.println("Invalid action");
            }
        }

        System.out.println("Good bye!");
        scanner.close();
    }

    // Метод для безопасного получения ввода целого числа
    private static int getInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
