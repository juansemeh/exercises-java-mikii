public class Vehicle {
    // Protected attributes for encapsulation
    protected String brand;
    protected String model;
    protected int year;
    protected double speed;
    protected double accelerationValue;
    protected double maxSpeed;
    
    // Constructor
    public Vehicle(String brand, String model, int year, double accelerationValue, double maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = 0.0;
        this.accelerationValue = accelerationValue;
        this.maxSpeed = maxSpeed;
    }
    
    // Method to display vehicle information
    public void displayInfo() {
        System.out.println("Vehicle Information:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Current Speed: " + speed + " km/h");
    }
    
    // Method to simulate acceleration (to be overridden by subclasses)
    public void accelerate() {
        if (speed < maxSpeed) {
            speed += accelerationValue;
            if (speed > maxSpeed) speed = maxSpeed;
            System.out.println(brand + " " + model + " is accelerating...");
            System.out.println("New speed: " + speed + " km/h");
        } else {
            System.out.println(brand + " " + model + " has reached maximum speed!");
        }
    }
    
    // Method to simulate deceleration/braking (to be overridden by subclasses)
    public void decelerate() {
        if (speed > 0) {
            speed -= accelerationValue;
            if (speed < 0) speed = 0;
            System.out.println(brand + " " + model + " is decelerating...");
            System.out.println("New speed: " + speed + " km/h");
        } else {
            System.out.println(brand + " " + model + " is already stopped!");
        }
    }
    
    // Getters and setters for encapsulation
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
