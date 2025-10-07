//Импорт класса Scanner
//Класс Scanner предоставляет методы для чтения данных различных типов
//Без импорта пришлось бы писать полное имя класса каждый раз при использовании
import java.util.Scanner;

//Виды топлива
//enum - перечисление
enum FuelType {
    GASOLINE,
    DIESEL,
    ELECTRICITY,
    JET_FUEL
}


//Класс Двигатели
//Не public – поэтому может жить в том же файле, что и Main
//sealed ограничивает наследование класса классами после permits
//abstract ограничивает создание экземпляра двигателя напрямую, только перечисленными классами
sealed abstract class Engine
        permits Engine.GasolineEngine,
        Engine.DieselEngine,
        Engine.ElectricEngine,
        Engine.JetEngine {

    //Абстрактный метод
    //Метод должен быть реализован в каждом подклассе двигателей и возвращает описание
    public abstract String getDescription();

    //Бензиновый двигатель
    //от final класса нельзя наследоваться, последний в иерархии
    public static final class GasolineEngine extends Engine {

        //Лошадинная сила
        //Приватный, только для одного класса
        //final означает, что значение этого поля можно установить только один раз
        private final int horsepower;

        //Эффективность использования топлива
        private final double fuelEfficiency;   // л/100 км

        // Конструктор класса GasolineEngine, принимающий мощность и эффективность топлива
        public GasolineEngine(int horsepower, double fuelEfficiency) {
            this.horsepower = horsepower;
            this.fuelEfficiency = fuelEfficiency;
        }

        //Переопределение метода
        //Возвращает строку, описывающий бензиновый двигатель
        @Override
        public String getDescription() {
            return "Gasoline Engine with " + horsepower + " HP (" +
                    fuelEfficiency + " L/100km)";
        }
    }

    //С другими двигателями аналогично бензиновому
    public static final class DieselEngine extends Engine {
        private final int torque;               // Н·м
        private final double fuelConsumption;   // л/100 км

        public DieselEngine(int torque, double fuelConsumption) {
            this.torque = torque;
            this.fuelConsumption = fuelConsumption;
        }

        @Override
        public String getDescription() {
            return "Diesel Engine with " + torque + " Nm (" +
                    fuelConsumption + " L/100km)";
        }
    }

    public static final class ElectricEngine extends Engine {
        private final int voltage;          // В
        private final int batteryCapacity;  // kWh

        public ElectricEngine(int voltage, int batteryCapacity) {
            this.voltage = voltage;
            this.batteryCapacity = batteryCapacity;
        }

        @Override
        public String getDescription() {
            return "Electric Engine " + voltage + " V, " +
                    batteryCapacity + " kWh battery";
        }
    }

    public static final class JetEngine extends Engine {
        private final double thrust;        // кН

        public JetEngine(double thrust) {
            this.thrust = thrust;
        }

        @Override
        public String getDescription() {
            return "Jet Engine with " + thrust + " kN thrust";
        }
    }
}

//Интерфейс транспорт
//Общие операции для любого транспорта
interface Transport {

    //Метод старт двигателя
    void startEngine();

    //стоп двигателя
    void stopEngine();

    //движение (на какую дистанцию)
    void move(double distance);

    //Текущая скорость
    double getSpeed();

    //Информация об объекте
    String getInfo();
}

//Абстрактный базовый класс для транспортных средств с двигателем
abstract class AbstractVehicle implements Transport {
    //protected - защищенные поля, доступные в текущем классе, в подклассах и в классах, находящихся в том же пакете
    protected Engine engine;
    protected FuelType fuelType;
    protected double currentSpeed;
    protected boolean engineRunning;

    //Абстрактоное ТС
    protected AbstractVehicle(Engine engine, FuelType fuelType) {
        //двигатель
        this.engine = engine;
        //тип топлива
        this.fuelType = fuelType;
        //Текущая скорость
        this.currentSpeed = 0;
        //запуск двигателя
        this.engineRunning = false;
    }

    @Override
    public void startEngine() {
        //если не заведен
        if (!engineRunning) {
            //Запуск двигателя
            System.out.println("Starting engine...");
            engineRunning = true;
        } else {
            //Уже запущен
            System.out.println("Engine is already running.");
        }
    }

    @Override
    public void stopEngine() {
        if (engineRunning) {
            System.out.println("Stopping engine...");
            engineRunning = false;
            currentSpeed = 0;
        } else {
            System.out.println("Engine is already stopped.");
        }
    }

    @Override
    public double getSpeed() {
        return currentSpeed;
    }

    @Override
    public String getInfo() {
        return "Engine: " + engine.getDescription()
                + ", Fuel: " + fuelType
                + ", Speed: " + currentSpeed + " km/h";
    }

    @Override
    public abstract void move(double distance);
}

//Машина
class Car extends AbstractVehicle {
    //кол-во дверей
    private final int numberOfDoors;
    //тип кузова
    private final String bodyType;

    public Car(Engine engine, FuelType fuelType,
               int numberOfDoors, String bodyType) {
        //вызов конструктора родительского класса
        //super - вызывает конструктор родительского (супер) класса
        //Вызывает конструктор Vehicle: public Vehicle(Engine engine, String fuelType)
        super(engine, fuelType);
        this.numberOfDoors = numberOfDoors;
        this.bodyType = bodyType;
    }

    @Override
    public void move(double distance) {
        if (engineRunning) {
            System.out.println("Driving " + distance + " km...");
            currentSpeed = 60; // условная средняя скорость
        } else {
            System.out.println("Start the engine first.");
        }
    }

    @Override
    public String getInfo() {
        return "Car: " + super.getInfo()
                + ", Doors: " + numberOfDoors
                + ", Body: " + bodyType;
    }
}

// Класс Самолеты
class Airplane extends AbstractVehicle {
    //кол-во двигателей
    private final int numberOfEngines;
    //размах крыльев
    private final double wingSpan; // в метрах

    public Airplane(Engine engine, FuelType fuelType,
                    int numberOfEngines, double wingSpan) {
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

//Класс Корабли
class Ship extends AbstractVehicle {
    //тоннаж, объем внутр. помещений судна
    private final double tonnage; // в тоннах
    //осадка, на какую глубину
    private final double draft;   // осадка в метрах

    public Ship(Engine engine, FuelType fuelType,
                double tonnage, double draft) {
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
                + ", Tonnage: " + tonnage + " t"
                + ", Draft: " + draft + " m";
    }
}

//Класс велосипеды
class Bicycle implements Transport {
    //кол-во передач
    private final int numberOfGears;
    //тип
    private final String type;
    //текущ скорость
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
        return "Bicycle: " + type
                + ", Gears: " + numberOfGears
                + ", Speed: " + currentSpeed + " km/h";
    }
}

//НАЧАЛО
public class Main {
    //Главный метод программы
    public static void main(String[] args) {
        //Создание объекта класса Scanner для ввода данных с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Создаём двигатели
        Engine gasolineEngine = new Engine.GasolineEngine(150, 0.3);
        Engine dieselEngine    = new Engine.DieselEngine(500, 0.2);
        Engine electricEngine  = new Engine.ElectricEngine(400, 85);
        Engine jetEngine       = new Engine.JetEngine(500);

        // Транспортные средства
        Car       myCar     = new Car(gasolineEngine, FuelType.GASOLINE,
                5, "Sedan");
        Airplane  myPlane   = new Airplane(jetEngine, FuelType.JET_FUEL,
                2, 35.5);
        Ship      myShip    = new Ship(dieselEngine, FuelType.DIESEL,
                1200, 6.0);
        Bicycle   myBike    = new Bicycle(21, "Mountain");

        //Массив с элементами типа Transport
        Transport[] fleet = {myCar, myPlane, myShip, myBike};

        // Простое меню
        //Бесконечный цикл пока внутри цикла не будет break
        while (true) {
            //Выводи пустую строку, выберите транспорт
            System.out.println("\nChoose a transport:");
            System.out.println("1. Car");
            System.out.println("2. Airplane");
            System.out.println("3. Ship");
            System.out.println("4. Bicycle");
            System.out.println("5. Exit");

            //Считываем номер выбранного в переменную
            int choice = scanner.nextInt();
            //очищаем буфер ввода
            scanner.nextLine(); // consume newline

            if (choice == 5) break;

            //Переменная selected типа Transport будет хранить выбранный объект транспорта
            Transport selected;
            //выбирает действие в зависимости от введённого числа
            switch (choice) {
                case 1 -> selected = myCar;
                case 2 -> selected = myPlane;
                case 3 -> selected = myShip;
                case 4 -> selected = myBike;
                //если что-то другое, то по умолчанию
                default -> {
                    System.out.println("Invalid choice");
                    //новая итерация цикла
                    continue;
                    }
            }

            System.out.println("\nChoose an action:");
            System.out.println("1. Start Engine");
            System.out.println("2. Move");
            System.out.println("3. Stop Engine");
            System.out.println("4. Get Info");

            //Считывание номера выбранного действия в переменную action
            int action = scanner.nextInt();
            //Очищаем буфер ввода от оставшегося
            scanner.nextLine(); // consume newline

            switch (action) {
                //Включает двигатель ТС
                //Благодаря полиморфизму будет вызван метод startEngine() класса, к которому относится объект
                case 1 -> selected.startEngine();
                //Если выбрано движение
                case 2 -> {
                    //просим ввести расстояние
                    System.out.print("Enter distance (km): ");
                    //считываем число
                    double distance = scanner.nextDouble();
                    //очищаем буфер
                    scanner.nextLine();
                    //вызываем метод перемещения
                    selected.move(distance);
                }
                //выключить
                case 3 -> selected.stopEngine();
                //инфа
                case 4 -> System.out.println(selected.getInfo());
                //иначе по умолчанию
                default -> System.out.println("Invalid action");
            }
        }

        //При выходе из цикла (если 5): пока
        System.out.println("Good bye!");
        //закрываем объект Scanner
        //это освобождает системный ресурс (в данном случае System.in)
        scanner.close();
    }
}
