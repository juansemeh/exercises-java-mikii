public class Engineer extends Inventor {
    private String engineeringInvention;

    public Engineer(String name, Integer age, Integer creativityLevel, String engineeringInvention) {
        super(name, age, creativityLevel);
        this.engineeringInvention = engineeringInvention;
    }

    @Override
    public void presentInvention() {
        System.out.println("Engineer " + getName() + " presents the invention: " + engineeringInvention);
        System.out.println("Description: A mechanical device designed to improve efficiency.");
        System.out.println("Functioning: Operates using gears and levers.");
    }

    // Getters and setters 
    public String getEngineeringInvention() {
        return engineeringInvention;
    }

    public void setEngineeringInvention(String engineeringInvention) {
        this.engineeringInvention = engineeringInvention;
    }
}
