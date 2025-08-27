public class Elf extends Kind {
    private String forestHome;
    private Integer magicalAffinity;

    public Elf(String name, Integer strength, Integer intelligence, String ability, String forestHome, Integer magicalAffinity) {
        super(name, strength, intelligence, ability);
        this.forestHome = forestHome;
        this.magicalAffinity = magicalAffinity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Forest Home: " + forestHome);
        System.out.println("Magical Affinity: " + magicalAffinity + "/10");
        System.out.println("Race: Ancient Elf");
    }

    @Override
    public void toPhilosophize() {
        if (intelligence > 7) {
            System.out.println(name + " shares ancient elven wisdom spanning centuries.");
        } else {
            System.out.println(name + " connects with nature's simple truths.");
        }
    }

    @Override
    public void performAction() {
        System.out.println(name + " moves with graceful elven precision!");
    }

    public void useNatureMagic() {
        if (magicalAffinity > 5) {
            System.out.println(name + " channels powerful nature magic from " + forestHome + "!");
        } else {
            System.out.println(name + " uses basic elven nature connection.");
        }
    }

    public void elvenArchery() {
        System.out.println(name + " demonstrates masterful elven archery skills!");
    }

    public String getForestHome() {
        return forestHome;
    }

    public void setForestHome(String forestHome) {
        this.forestHome = forestHome;
    }

    public Integer getMagicalAffinity() {
        return magicalAffinity;
    }

    public void setMagicalAffinity(int magicalAffinity) {
        this.magicalAffinity = magicalAffinity;
    }
}
