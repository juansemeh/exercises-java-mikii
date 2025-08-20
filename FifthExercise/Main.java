import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Management System ===\n");
        
        List<Vehicle> vehicleList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Add some sample vehicles to start with
        vehicleList.add(new Car("Toyota", "Supra", 2023, 2, 25.0, 250.0));
        vehicleList.add(new Motorcycle("Yamaha", "R1", 2022, false, 35.0, 300.0));
        vehicleList.add(new Truck("Volvo", "FH16", 2021, 25.5, 15.0, 120.0));

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Register a vehicle");
            System.out.println("2. Accelerate a vehicle");
            System.out.println("3. Decelerate a vehicle");
            System.out.println("4. Display vehicle information");
            System.out.println("5. List all vehicles");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerVehicle(vehicleList, scanner);
                    break;
                case 2:
                    accelerateVehicle(vehicleList, scanner);
                    break;
                case 3:
                    decelerateVehicle(vehicleList, scanner);
                    break;
                case 4:
                    displayVehicleInfo(vehicleList, scanner);
                    break;
                case 5:
                    listAllVehicles(vehicleList);
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
    
    private static void registerVehicle(List<Vehicle> vehicleList, Scanner scanner) {
        System.out.println("\nRegister a new vehicle:");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Truck");
        System.out.print("Choose vehicle type: ");
        int type = scanner.nextInt();
        
        System.out.print("Enter brand: ");
        String brand = scanner.next();
        System.out.print("Enter model: ");
        String model = scanner.next();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        
        switch (type) {
            case 1:
                System.out.print("Enter number of doors: ");
                int doors = scanner.nextInt();
                System.out.print("Enter acceleration value: ");
                double carAccel = scanner.nextDouble();
                System.out.print("Enter max speed: ");
                double carMaxSpeed = scanner.nextDouble();
                vehicleList.add(new Car(brand, model, year, doors, carAccel, carMaxSpeed));
                break;
            case 2:
                System.out.print("Has sidecar? (true/false): ");
                boolean hasSidecar = scanner.nextBoolean();
                System.out.print("Enter acceleration value: ");
                double motorcycleAccel = scanner.nextDouble();
                System.out.print("Enter max speed: ");
                double motorcycleMaxSpeed = scanner.nextDouble();
                vehicleList.add(new Motorcycle(brand, model, year, hasSidecar, motorcycleAccel, motorcycleMaxSpeed));
                break;
            case 3:
                System.out.print("Enter load capacity (tons): ");
                double capacity = scanner.nextDouble();
                System.out.print("Enter acceleration value: ");
                double truckAccel = scanner.nextDouble();
                System.out.print("Enter max speed: ");
                double truckMaxSpeed = scanner.nextDouble();
                vehicleList.add(new Truck(brand, model, year, capacity, truckAccel, truckMaxSpeed));
                break;
            default:
                System.out.println("Invalid vehicle type!");
                return;
        }
        System.out.println("Vehicle registered successfully!");
    }
    
    private static void accelerateVehicle(List<Vehicle> vehicleList, Scanner scanner) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles registered yet!");
            return;
        }
        
        listAllVehicles(vehicleList);
        System.out.print("Enter vehicle number to accelerate: ");
        int index = scanner.nextInt() - 1;
        
        if (index >= 0 && index < vehicleList.size()) {
            Vehicle vehicle = vehicleList.get(index);
            System.out.println("Accelerating: " + vehicle.getBrand() + " " + vehicle.getModel());
            vehicle.accelerate();
        } else {
            System.out.println("Invalid vehicle number!");
        }
    }
    
    private static void decelerateVehicle(List<Vehicle> vehicleList, Scanner scanner) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles registered yet!");
            return;
        }
        
        listAllVehicles(vehicleList);
        System.out.print("Enter vehicle number to decelerate: ");
        int index = scanner.nextInt() - 1;
        
        if (index >= 0 && index < vehicleList.size()) {
            Vehicle vehicle = vehicleList.get(index);
            System.out.println("Decelerating: " + vehicle.getBrand() + " " + vehicle.getModel());
            vehicle.decelerate();
        } else {
            System.out.println("Invalid vehicle number!");
        }
    }
    
    private static void displayVehicleInfo(List<Vehicle> vehicleList, Scanner scanner) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles registered yet!");
            return;
        }
        
        listAllVehicles(vehicleList);
        System.out.print("Enter vehicle number to display: ");
        int index = scanner.nextInt() - 1;
        
        if (index >= 0 && index < vehicleList.size()) {
            vehicleList.get(index).displayInfo();
        } else {
            System.out.println("Invalid vehicle number!");
        }
    }
    
    private static void listAllVehicles(List<Vehicle> vehicleList) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles registered yet!");
            return;
        }
        
        System.out.println("\nRegistered Vehicles:");
        for (int i = 0; i < vehicleList.size(); i++) {
            Vehicle vehicle = vehicleList.get(i);
            System.out.println((i + 1) + ". " + vehicle.getBrand() + " " + vehicle.getModel() + 
                             " (" + vehicle.getClass().getSimpleName() + ")");
        }
    }
}
