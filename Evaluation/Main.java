import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Inventor> inventors = new ArrayList<>();

        // Register inventors
        inventors.add(new Engineer("Yuse", 30, 50, "Automated Gear System"));
        inventors.add(new SoftwareDeveloper("Sebastián", 25, 60, "Database AI Assistant", "Rust"));
        inventors.add(new Chemist("Alix", 35, 45, "Eco-Friendly Solvent"));

        // Start the competition menu
        Menu menu = new Menu(inventors);
        menu.startCompetition();
    }
}
