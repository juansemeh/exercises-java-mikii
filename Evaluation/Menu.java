import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Inventor> inventors;
    private Scanner scanner;

    public Menu(List<Inventor> inventors) {
        this.inventors = inventors;
        this.scanner = new Scanner(System.in);
    }

    public void startCompetition() {
        System.out.println("Welcome to the Inventors Competition!");
        
        System.out.println("\nPresentations to the jury:");
        for (Inventor inventor : inventors) {
            inventor.presentInvention();
            System.out.println();
        }
        // Award creativity points to inventors
        for (Inventor inventor : inventors) {
            System.out.print("Enter creativity points to award to " + inventor.getName() + ": ");
            int points = readInt();
            inventor.gainCreativityPoints(points);
        }


    }

    private int readInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
        }
    }
}
