import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Fantasy Character Management System ===\n");
        
        List<Kind> characterList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        // Add some sample characters to start with
        initializeSampleCharacters(characterList);
        
        CharacterMenu characterMenu = new CharacterMenu(characterList, scanner);
        characterMenu.displayMainMenu();
        
        scanner.close();
        System.out.println("\nThank you for using the Fantasy Character Management System!");
    }
    
    private static void initializeSampleCharacters(List<Kind> characterList) {
        characterList.add(new Human("Mikiii", 8, 7, "Leadership", "Armenia", "Ranger"));
        characterList.add(new Elf("Legolas", 6, 8, "Archery", "Mirkwood", 7));
        characterList.add(new Dwarf("Durin", 9, 5, "Axe Mastery", "Erebor", "Weaponsmithing", 8));
        characterList.add(new Alien("Iluminate", 7, 9, "Telepathy", "Water"));
        
        System.out.println("Sample characters have been loaded:");
        System.out.println("- Mikiii (Human)");
        System.out.println("- Legolas (Elf)");
        System.out.println("- Durin (Dwarf)");
        System.out.println("- Iluminate (Alien)");
    }
}
