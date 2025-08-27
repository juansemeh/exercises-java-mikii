public class Human extends Kind {
    private String homeland;
    private String occupation;

    public Human(String name, Integer strength, Integer intelligence, String ability, String homeland, String occupation) {
        super(name, strength, intelligence, ability);
        this.homeland = homeland;
        this.occupation = occupation;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Homeland: " + homeland);
        System.out.println("Occupation: " + occupation);
        System.out.println("Race: Human");
    }

    @Override
    public void toPhilosophize() {
        if (intelligence > 5) {
            System.out.println(name + " engages in deep human philosophical discourse.");
        } else {
            System.out.println(name + " prefers practical thinking over abstract philosophy.");
        }
    }

    @Override
    public void performAction() {
        System.out.println(name + " demonstrates human ingenuity and adaptability!");
    }

    public void useHumanSkill() {
        System.out.println(name + " uses specialized " + occupation + " skills!");
    }

    public void showPatriotism() {
        System.out.println(name + " expresses pride for " + homeland + "!");
    }

    public String getHomeland() {
        return homeland;
    }

    public void setHomeland(String homeland) {
        this.homeland = homeland;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
