public class Dwarf extends Kind {
    private String mountainHome;
    private String craftSpecialty;
    private Integer miningSkill;

    public Dwarf(String name, Integer strength, Integer intelligence, String ability, String mountainHome, String craftSpecialty, Integer miningSkill) {
        super(name, strength, intelligence, ability);
        this.mountainHome = mountainHome;
        this.craftSpecialty = craftSpecialty;
        this.miningSkill = miningSkill;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Mountain Home: " + mountainHome);
        System.out.println("Craft Specialty: " + craftSpecialty);
        System.out.println("Mining Skill: " + miningSkill + "/10");
        System.out.println("Race: Sturdy Dwarf");
    }

    @Override
    public void toPhilosophize() {
        if (intelligence > 4) {
            System.out.println(name + " shares practical dwarf wisdom about craftsmanship and honor.");
        } else {
            System.out.println(name + " believes in simple truths: gold, ale, and good company.");
        }
    }

    @Override
    public void performAction() {
        System.out.println(name + " demonstrates unmatched dwarf resilience!");
    }

    public void mineResources() {
        if (miningSkill > 6) {
            System.out.println(name + " expertly mines precious minerals from the mountains!");
        } else {
            System.out.println(name + " chips away at the rock with determination.");
        }
    }

    public void craftItem() {
        System.out.println(name + " skillfully crafts a magnificent " + craftSpecialty + "!");
    }

    public void drinkAle() {
        System.out.println(name + " enjoys a fine dwarven ale from " + mountainHome + "!");
    }

    public String getMountainHome() {
        return mountainHome;
    }

    public void setMountainHome(String mountainHome) {
        this.mountainHome = mountainHome;
    }

    public String getCraftSpecialty() {
        return craftSpecialty;
    }

    public void setCraftSpecialty(String craftSpecialty) {
        this.craftSpecialty = craftSpecialty;
    }

    public Integer getMiningSkill() {
        return miningSkill;
    }

    public void setMiningSkill(int miningSkill) {
        this.miningSkill = miningSkill;
    }
}
