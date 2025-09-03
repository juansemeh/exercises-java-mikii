public class SoftwareDeveloper extends Inventor {
    private String softwareInvention;
    private String primaryLanguage;

    public SoftwareDeveloper(String name, Integer age, Integer creativityLevel, String softwareInvention, String primaryLanguage) {
        super(name, age, creativityLevel);
        this.softwareInvention = softwareInvention;
        this.primaryLanguage = primaryLanguage;
    }

    @Override
    public void presentInvention() {
        System.out.println("Software Developer " + getName() + " presents the invention: " + softwareInvention);
        System.out.println("Description: A software application to solve complex problems.");
        System.out.println("Primary Language: " + primaryLanguage);
        System.out.println("Functioning: Runs algorithms to process data efficiently.");
    }

    // Getters and setters
    public String getSoftwareInvention() {
        return softwareInvention;
    }

    public void setSoftwareInvention(String softwareInvention) {
        this.softwareInvention = softwareInvention;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    public void setPrimaryLanguage(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
    }
}
