import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vehicles.Car;
import vehicles.Airplane;
import vehicles.Ship;
import vehicles.Bicycle;
import engines.GasolineEngine;
import engines.JetEngine;
import engines.DieselEngine;
import enums.FuelType;
import interfaces.Transport;
import engines.Engine;

public class Main {
    public static void main(String[] args) {
        // Создаём двигатели
        Engine gasolineEngine = new GasolineEngine(150, 0.3);
        Engine jetEngine = new JetEngine(500);
        Engine dieselEngine = new DieselEngine(500, 0.2);

        // Транспортные средства
        Car myCar = new Car(gasolineEngine, FuelType.GASOLINE, 5, "Sedan");
        Airplane myPlane = new Airplane(jetEngine, FuelType.JET_FUEL, 2, 35.5);
        Ship myShip = new Ship(dieselEngine, FuelType.DIESEL, 1200, 6.0);
        Bicycle myBike = new Bicycle(21, "Mountain");

        // Список транспорта
        List<Transport> transports = new ArrayList<>();
        transports.add(myCar);
        transports.add(myPlane);
        transports.add(myShip);
        transports.add(myBike);

        // Создаем экземпляр MenuHandler с внедренными зависимостями
        MenuHandler menuHandler = new MenuHandler(transports, new Scanner(System.in));
        menuHandler.run();
    }
}
