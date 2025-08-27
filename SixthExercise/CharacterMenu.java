import java.util.List;
import java.util.Scanner;

public class CharacterMenu {
    private List<Kind> characterList;
    private Scanner scanner;

    public CharacterMenu(List<Kind> characterList, Scanner scanner) {
        this.characterList = characterList;
        this.scanner = scanner;
    }

    public void displayMainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Character Management Menu ===");
            System.out.println("1. Create a new character");
            System.out.println("2. Display character information");
            System.out.println("3. Make character philosophize");
            System.out.println("4. Make character perform action");
            System.out.println("5. Use character special ability");
            System.out.println("6. List all characters");
            System.out.println("7. Close Main Menu");
            System.out.print("Choose an option: ");
            Integer choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createCharacter();
                    break;
                case 2:
                    displayCharacterInfo();
                    break;
                case 3:
                    makeCharacterPhilosophize();
                    break;
                case 4:
                    makeCharacterPerformAction();
                    break;
                case 5:
                    useCharacterSpecialAbility();
                    break;
                case 6:
                    listAllCharacters();
                    break;
                case 7:
                    running = false;
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void createCharacter() {
        System.out.println("\n=== Create New Character ===");
        System.out.println("1. Human");
        System.out.println("2. Elf");
        System.out.println("3. Dwarf");
        System.out.println("4. Alien");
        System.out.print("Choose character race: ");
        Integer race = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter strength (1-10): ");
        Integer strength = scanner.nextInt();
        System.out.print("Enter intelligence (1-10): ");
        Integer intelligence = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter special ability: ");
        String ability = scanner.nextLine();
        
        switch (race) {
            case 1:
                createHuman(name, strength, intelligence, ability);
                break;
            case 2:
                createElf(name, strength, intelligence, ability);
                break;
            case 3:
                createDwarf(name, strength, intelligence, ability);
                break;
            case 4:
                createAlien(name, strength, intelligence, ability);
                break;
            default:
                System.out.println("Invalid race selection!");
                return;
        }
        System.out.println("Character created successfully!");
    }

    private void createHuman(String name, int strength, int intelligence, String ability) {
        System.out.print("Enter homeland: ");
        String homeland = scanner.nextLine();
        System.out.print("Enter occupation: ");
        String occupation = scanner.nextLine();
        characterList.add(new Human(name, strength, intelligence, ability, homeland, occupation));
    }

    private void createElf(String name, int strength, int intelligence, String ability) {
        System.out.print("Enter forest home: ");
        String forestHome = scanner.nextLine();
        System.out.print("Enter magical affinity (1-10): ");
        Integer magicalAffinity = scanner.nextInt();
        characterList.add(new Elf(name, strength, intelligence, ability, forestHome, magicalAffinity));
    }

    private void createDwarf(String name, int strength, int intelligence, String ability) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter mountain home: ");
        String mountainHome = scanner.nextLine();
        System.out.print("Enter craft specialty: ");
        String craftSpecialty = scanner.nextLine();
        System.out.print("Enter mining skill (1-10): ");
        Integer miningSkill = scanner.nextInt();
        characterList.add(new Dwarf(name, strength, intelligence, ability, mountainHome, craftSpecialty, miningSkill));
    }

    private void createAlien(String name, int strength, int intelligence, String ability) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter weakness: ");
        String weakness = scanner.nextLine();
        characterList.add(new Alien(name, strength, intelligence, ability, weakness));
    }

    private void displayCharacterInfo() {
        if (characterList.isEmpty()) {
            System.out.println("No characters created yet!");
            return;
        }
        
        listAllCharacters();
        System.out.print("Enter character number to display: ");
        Integer index = scanner.nextInt() - 1;
        
        if (index >= 0 && index < characterList.size()) {
            characterList.get(index).displayInfo();
        } else {
            System.out.println("Invalid character number!");
        }
    }

    private void makeCharacterPhilosophize() {
        if (characterList.isEmpty()) {
            System.out.println("No characters created yet!");
            return;
        }
        
        listAllCharacters();
        System.out.print("Enter character number to philosophize: ");
        Integer index = scanner.nextInt() - 1;
        
        if (index >= 0 && index < characterList.size()) {
            characterList.get(index).toPhilosophize();
        } else {
            System.out.println("Invalid character number!");
        }
    }

    private void makeCharacterPerformAction() {
        if (characterList.isEmpty()) {
            System.out.println("No characters created yet!");
            return;
        }
        
        listAllCharacters();
        System.out.print("Enter character number to perform action: ");
        Integer index = scanner.nextInt() - 1;
        
        if (index >= 0 && index < characterList.size()) {
            characterList.get(index).performAction();
        } else {
            System.out.println("Invalid character number!");
        }
    }

    private void useCharacterSpecialAbility() {
        if (characterList.isEmpty()) {
            System.out.println("No characters created yet!");
            return;
        }
        
        listAllCharacters();
        System.out.print("Enter character number to use special ability: ");
        Integer index = scanner.nextInt() - 1;
        
        if (index >= 0 && index < characterList.size()) {
            Kind character = characterList.get(index);
            if (character instanceof Human) {
                ((Human) character).useHumanSkill();
            } else if (character instanceof Elf) {
                ((Elf) character).useNatureMagic();
            } else if (character instanceof Dwarf) {
                ((Dwarf) character).craftItem();
            } else if (character instanceof Alien) {
                ((Alien) character).useAlienPower();
            }
        } else {
            System.out.println("Invalid character number!");
        }
    }

    private void listAllCharacters() {
        if (characterList.isEmpty()) {
            System.out.println("No characters created yet!");
            return;
        }
        
        System.out.println("\n=== All Characters ===");
        for (Integer i = 0; i < characterList.size(); i++) {
            Kind character = characterList.get(i);
            System.out.println((i + 1) + ". " + character.getName() + 
                             " (" + character.getClass().getSimpleName() + ")");
        }
    }
}
