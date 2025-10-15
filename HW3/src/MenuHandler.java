import java.util.List;
import java.util.Scanner;
import interfaces.Transport;

class MenuHandler {
    private final List<Transport> transports;
    private final Scanner scanner;

    public MenuHandler(List<Transport> transports, Scanner scanner) {
        this.transports = transports;
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            System.out.println("\nChoose a transport:");
            for (int i = 0; i < transports.size(); i++) {
                System.out.println((i + 1) + ". " + transports.get(i).getClass().getSimpleName());
            }
            System.out.println((transports.size() + 1) + ". Exit");

            int choice = getIntInput("Enter your choice: ");

            if (choice == transports.size() + 1) {
                break;
            }

            if (choice < 1 || choice > transports.size()) {
                System.out.println("Invalid choice.");
                continue;
            }

            Transport selected = transports.get(choice - 1);
            handleTransportActions(selected);
        }

        System.out.println("Good bye!");
        scanner.close();
    }

    private void handleTransportActions(Transport selected) {
        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Start Engine");
            System.out.println("2. Move");
            System.out.println("3. Stop Engine");
            System.out.println("4. Get Info");
            System.out.println("5. Back to transport selection");

            int action = getIntInput("Enter your choice: ");
            switch (action) {
                case 1:
                    selected.startEngine();
                    break;
                case 2:
                    double distance = getDoubleInput("Enter distance (km): ");
                    selected.move(distance);
                    break;
                case 3:
                    selected.stopEngine();
                    break;
                case 4:
                    System.out.println(selected.getInfo());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid action.");
            }
        }
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // discard invalid input
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // discard invalid input
            }
        }
    }
}
