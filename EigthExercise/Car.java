/**
 * Represents a Car, a type of transport vehicle.
 */
public class Car extends Transport {

    /**
     * Constructor for Car.
     * @param brand the brand of the car
     * @param model the model of the car
     * @param maxSpeed the maximum speed of the car
     */
    public Car(String brand, String model, int maxSpeed) {
        super(brand, model, maxSpeed);
    }

    /**
     * Returns the fuel type for the car.
     * @return "gasoline"
     */
    @Override
    public String fuelType() {
        return "gasoline";
    }

    /**
     * Starts the car.
     */
    @Override
    public void start() {
        System.out.println("Car started");
    }

    /**
     * Stops the car.
     */
    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    /**
     * Gets the current speed of the car.
     * @return the current speed
     */
    @Override
    public int getCurrentSpeed() {
        return super.getCurrentSpeed();
    }
}
