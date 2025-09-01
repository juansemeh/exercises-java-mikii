public abstract class Animal implements Adoptable {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void adopt() {
        System.out.println(name + " has been adopted!");
    }
}
