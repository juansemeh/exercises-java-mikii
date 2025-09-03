public class Chemist extends Inventor {
    private String chemicalInvention;

    public Chemist(String name, Integer age, Integer creativityLevel, String chemicalInvention) {
        super(name, age, creativityLevel);
        this.chemicalInvention = chemicalInvention;
    }

    @Override
    public void presentInvention() {
        System.out.println("Chemist " + getName() + " presents the invention: " + chemicalInvention);
        System.out.println("Description: A chemical experiment to demonstrate new reactions.");
        System.out.println("Reaction: Involves mixing compounds to produce a visible change.");
    }

    // Getters and setters
    public String getChemicalInvention() {
        return chemicalInvention;
    }

    public void setChemicalInvention(String chemicalInvention) {
        this.chemicalInvention = chemicalInvention;
    }
}
