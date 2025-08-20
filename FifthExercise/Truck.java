public class Truck extends Vehicle {
    private double loadCapacity;
    
    public Truck(String brand, String model, int year, double loadCapacity, double accelerationValue, double maxSpeed) {
        super(brand, model, year, accelerationValue, maxSpeed);
        this.loadCapacity = loadCapacity;
    }
    
    @Override
    public void accelerate() {
        if (speed < maxSpeed) {
            speed += accelerationValue;
            if (speed > maxSpeed) speed = maxSpeed;
            System.out.println("🚛 " + brand + " " + model + " (Truck) is accelerating with heavy load!");
            System.out.println("Power mode engaged! New speed: " + speed + " km/h");
        } else {
            System.out.println("🚛 " + brand + " " + model + " (Truck) has reached maximum speed!");
        }
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load capacity: " + loadCapacity + " tons");
    }
    
    @Override
    public void decelerate() {
        if (speed > 0) {
            speed -= 8.0;
            if (speed < 0) speed = 0;
            System.out.println("🚛 " + brand + " " + model + " (Truck) is braking with heavy load!");
            System.out.println("Engine brake engaged! New speed: " + speed + " km/h");
        } else {
            System.out.println("🚛 " + brand + " " + model + " (Truck) is already stopped!");
        }
    }
}
