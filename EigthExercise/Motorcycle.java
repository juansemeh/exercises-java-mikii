/**
 * Represents a Motorcycle, a type of transport vehicle.
 */
public class Motorcycle extends Transport {

    /**
     * Constructor for Motorcycle.
     * @param brand the brand of the motorcycle
     * @param model the model of the motorcycle
     * @param maxSpeed the maximum speed of the motorcycle
     */
    public Motorcycle(String brand, String model, int maxSpeed) {
        super(brand, model, maxSpeed);
    }

    /**
     * Returns the fuel type for the motorcycle.
     * @return "gasoline"
     */
    @Override
    public String fuelType() {
        return "gasoline";
    }

    /**
     * Starts the motorcycle.
     */
    @Override
    public void start() {
        System.out.println("Motorcycle started");
    }

    /**
     * Stops the motorcycle.
     */
    @Override
    public void stop() {
        System.out.println("Motorcycle stopped");
    }

    /**
     * Gets the current speed of the motorcycle.
     * @return the current speed
     */
    @Override
    public int getCurrentSpeed() {
        return super.getCurrentSpeed();
    }
}
