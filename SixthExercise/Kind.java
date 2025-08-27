public class Kind {
    // Protected attributes for encapsulation
    protected String name;
    protected Integer strength;
    protected Integer intelligence; 
    protected String ability;

    // Constructor
    public Kind(String name, Integer strength, Integer intelligence, String ability) {
        this.name = name; 
        this.strength = strength;
        this.intelligence = intelligence;
        this.ability = ability;
    }

    // Method to display information
    public void displayInfo() {
        System.out.println("Character Information:");
        System.out.println("Name: " + name);
        System.out.println("Strength: " + strength);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Ability: " + ability);
    }

    // Method for critical thinking
    public void toPhilosophize() {
        if (intelligence > 4) {
            System.out.println(name + " engages in deep philosophical thought.");
        } else {
            System.out.println(name + " finds philosophical thinking too complex.");
        }
    }

    // Method to perform a basic action (to be overridden by subclasses)
    public void performAction() {
        System.out.println(name + " performs a generic action.");
    }

    // Getters and Setters for authentication
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
}


