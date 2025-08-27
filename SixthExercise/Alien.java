public class Alien extends Kind {
    private String weakness;

    public Alien(String name, Integer strength, Integer intelligence, String ability, String weakness) {
        super(name, strength, intelligence, ability);
        this.weakness = weakness;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weakness: " + weakness);
        System.out.println("Species: Alien from distant galaxy");
    }

    @Override
    public void toPhilosophize() {
        if (intelligence > 6) {
            System.out.println(name + " contemplates the mysteries of the universe with advanced alien wisdom.");
        } else {
            System.out.println(name + " communicates in strange cosmic patterns beyond human comprehension.");
        }
    }

    @Override
    public void performAction() {
        System.out.println(name + " uses advanced alien technology to manipulate reality!");
    }

    public void useAlienPower() {
        System.out.println(name + " activates mysterious alien powers unknown to humans!");
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }
}
