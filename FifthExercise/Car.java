public class Car extends Vehicle {
    private int numberOfDoors;
    
    public Car(String brand, String model, int year, int numberOfDoors, double accelerationValue, double maxSpeed) {
        super(brand, model, year, accelerationValue, maxSpeed);
        this.numberOfDoors = numberOfDoors;
    }
    
    @Override
    public void accelerate() {
        if (speed < maxSpeed) {
            speed += accelerationValue;
            if (speed > maxSpeed) speed = maxSpeed;
            System.out.println("🚗 " + brand + " " + model + " (Car) is accelerating rapidly!");
            System.out.println("Sports mode activated! New speed: " + speed + " km/h");
        } else {
            System.out.println("🚗 " + brand + " " + model + " (Car) has reached maximum speed!");
        }
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of doors: " + numberOfDoors);
    }
    
    @Override
    public void decelerate() {
        if (speed > 0) {
            speed -= accelerationValue;
            if (speed < 0) speed = 0;
            System.out.println("🚗 " + brand + " " + model + " (Car) is braking hard!");
            System.out.println("ABS activated! New speed: " + speed + " km/h");
        } else {
            System.out.println("🚗 " + brand + " " + model + " (Car) is already stopped!");
        }
    }
}
