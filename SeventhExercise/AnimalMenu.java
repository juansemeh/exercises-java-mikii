import java.util.ArrayList;
import java.util.Scanner;

public class AnimalMenu {
    private ArrayList<Animal> animals = new ArrayList<>();
    private Scanner scanner;

    public AnimalMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            System.out.println("1. Add animal\n2. List animals\n3. Adopt\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Type (Dog/Cat/Bird): ");
                String type = scanner.nextLine();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                if (type.equals("Dog")) animals.add(new Dog(name, age));
                else if (type.equals("Cat")) animals.add(new Cat(name, age));
                else if (type.equals("Bird")) animals.add(new Bird(name, age));
                else System.out.println("Invalid");
            } else if (choice == 2) {
                for (int i = 0; i < animals.size(); i++) {
                    Animal a = animals.get(i);
                    System.out.println((i+1) + ". " + a.getName() + " " + a.getAge());
                    a.makeSound();
                }
            } else if (choice == 3) {
                if (animals.isEmpty()) System.out.println("No animals");
                else {
                    System.out.print("Index: ");
                    int i = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (i >= 0 && i < animals.size()) {
                        animals.get(i).adopt();
                        animals.remove(i);
                    }
                }
            } else if (choice == 4) break;
            else System.out.println("Invalid");
        }
    }
}
