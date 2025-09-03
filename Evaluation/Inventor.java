public abstract class Inventor {
    private String name;
    private Integer age;
    private Integer creativityLevel;

    public Inventor(String name, Integer age, Integer creativityLevel) {
        this.name = name;
        this.age = age;
        this.creativityLevel = creativityLevel;
    }

    // Method to display the Inventor
    public void displayInfo() {
        System.out.println("Inventor's information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Creativity level: " + creativityLevel);
    }

    // Controlled method to increase creativity level
    public void gainCreativityPoints(int points) {
        this.creativityLevel += points;
    }

    // Abstract method for presenting invention
    public abstract void presentInvention();

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCreativityLevel() {
        return creativityLevel;
    }

}
