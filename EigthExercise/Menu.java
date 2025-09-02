import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Menu class to interact with the user and manage Transport objects.
 */
public class Menu {
    private Transport currentVehicle = null;
    private ArrayList<Transport> vehicles = new ArrayList<>();

    private boolean vehicleStarted = false;

    public Menu() {
        vehicles.add(new Car("Koenigsegg", "Jesko", 180));
        vehicles.add(new Motorcycle("BAJAJ", "Boxer", 200));
        vehicles.add(new Bicycle("Giant", "Escape", 30));
    }

    /**
     * Runs the menu loop for vehicle management.
     */
    public void runMenu() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                displayMenu();
                int choice = getIntInput(sc, "Enter your choice: ");
                switch (choice) {
                    case 1:
                        createNewVehicle(sc);
                        break;
                    case 2:
                        if (currentVehicle != null) {
                            currentVehicle.start();
                            vehicleStarted = true;
                        } else {
                            System.out.println("No current vehicle selected.");
                        }
                        break;
                    case 3:
                        if (currentVehicle != null) {
                            currentVehicle.stop();
                            vehicleStarted = false;
                        } else {
                            System.out.println("No current vehicle selected.");
                        }
                        break;
                    case 4:
                        if (currentVehicle != null) {
                            if (vehicleStarted) {
                                int amount = getIntInput(sc, "Enter acceleration amount: ");
                                currentVehicle.accelerate(amount);
                            } else {
                                System.out.println("Vehicle is not started. Please start the vehicle first.");
                            }
                        } else {
                            System.out.println("No current vehicle selected.");
                        }
                        break;
                    case 5:
                        if (currentVehicle != null) {
                            if (vehicleStarted) {
                                int amount = getIntInput(sc, "Enter deceleration amount: ");
                                currentVehicle.decelerate(amount);
                            } else {
                                System.out.println("Vehicle is not started. Please start the vehicle first.");
                            }
                        } else {
                            System.out.println("No current vehicle selected.");
                        }
                        break;
                    case 6:
                        if (currentVehicle != null) {
                            System.out.println("Current speed: " + currentVehicle.getCurrentSpeed());
                        } else {
                            System.out.println("No current vehicle selected.");
                        }
                        break;
                    case 7:
                        listVehicles();
                        break;
                    case 8:
                        selectVehicle(sc);
                        break;
                    case 9:
                        if (currentVehicle != null) {
                            System.out.println("Fuel type: " + currentVehicle.fuelType());
                            currentVehicle.showInformation();
                        } else {
                            System.out.println("No current vehicle selected.");
                        }
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    /**
     * Displays the menu options.
     */
    private void displayMenu() {
        System.out.println("\n--- Vehicle Menu ---");
        System.out.println("1. Create a new vehicle");
        System.out.println("2. Start current vehicle");
        System.out.println("3. Stop current vehicle");
        System.out.println("4. Accelerate");
        System.out.println("5. Decelerate");
        System.out.println("6. View current speed");
        System.out.println("7. List vehicles");
        System.out.println("8. Select a vehicle");
        System.out.println("9. Show vehicle info");
        System.out.println("10. Exit");
    }

    /**
     * Creates a new vehicle based on user input.
     * @param sc the Scanner for input
     */
    private void createNewVehicle(Scanner sc) {
        System.out.println("Enter vehicle type (car, motorcycle, bicycle):");
        String type = sc.nextLine().toLowerCase();

        System.out.println("Enter brand:");
        String brand = sc.nextLine();

        System.out.println("Enter model:");
        String model = sc.nextLine();

        int maxSpeed = getIntInput(sc, "Enter max speed (positive integer): ");
        if (maxSpeed <= 0) {
            System.out.println("Max speed must be positive.");
            return;
        }

        Transport t = null;
        if (type.equals("car")) {
            t = new Car(brand, model, maxSpeed);
        } else if (type.equals("motorcycle")) {
            t = new Motorcycle(brand, model, maxSpeed);
        } else if (type.equals("bicycle")) {
            t = new Bicycle(brand, model, maxSpeed);
        } else {
            System.out.println("Invalid type");
            return;
        }
        vehicles.add(t);
        currentVehicle = t;
    }

    /**
     * Lists the vehicles.
     */
    private void listVehicles() {
        System.out.println("Vehicles:");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.printf("%d. %s %s (Max Speed: %d)%n", i + 1, vehicles.get(i).brand, vehicles.get(i).model, vehicles.get(i).maxSpeed);
        }
    }

    /**
     * Selects a vehicle.
     * @param sc the Scanner for input
     */
    private void selectVehicle(Scanner sc) {
        listVehicles();
        int index = getIntInput(sc, "Enter the number of the vehicle to select: ") - 1;
        if (index >= 0 && index < vehicles.size()) {
            currentVehicle = vehicles.get(index);
            System.out.println("Selected: " + currentVehicle.brand + " " + currentVehicle.model);
        } else {
            System.out.println("Invalid selection.");
        }
    }

    /**
     * Gets an integer input from the user with validation.
     * @param sc the Scanner
     * @param prompt the prompt message
     * @return the integer input
     */
    private int getIntInput(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = sc.nextInt();
                sc.nextLine(); // consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.nextLine(); // consume invalid input
            }
        }
    }
}
