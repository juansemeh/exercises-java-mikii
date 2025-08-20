public class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    
    public Motorcycle(String brand, String model, int year, boolean hasSidecar, double accelerationValue, double maxSpeed) {
        super(brand, model, year, accelerationValue, maxSpeed);
        this.hasSidecar = hasSidecar;
    }
    
    @Override
    public void accelerate() {
        if (speed < maxSpeed) {
            speed += accelerationValue;
            if (speed > maxSpeed) speed = maxSpeed;
            System.out.println("🏍️ " + brand + " " + model + " (Motorcycle) is accelerating like lightning!");
            System.out.println("Vroooom! New speed: " + speed + " km/h");
        } else {
            System.out.println("🏍️ " + brand + " " + model + " (Motorcycle) has reached maximum speed!");
        }
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
    
    @Override
    public void decelerate() {
        if (speed > 0) {
            speed -= 25.0;
            if (speed < 0) speed = 0;
            System.out.println("🏍️ " + brand + " " + model + " (Motorcycle) is braking aggressively!");
            System.out.println("Skidding to a stop! New speed: " + speed + " km/h");
        } else {
            System.out.println("🏍️ " + brand + " " + model + " (Motorcycle) is already stopped!");
        }
    }
}
