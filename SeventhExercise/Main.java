import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalMenu menu = new AnimalMenu(scanner);
        menu.run();
        scanner.close();
    }
}
