/**
 * Represents a Bicycle, a type of transport vehicle.
 */
public class Bicycle extends Transport {

    /**
     * Constructor for Bicycle.
     * @param brand the brand of the bicycle
     * @param model the model of the bicycle
     * @param maxSpeed the maximum speed of the bicycle
     */
    public Bicycle(String brand, String model, int maxSpeed) {
        super(brand, model, maxSpeed);
    }

    /**
     * Returns the fuel type for the bicycle.
     * @return "no fuel"
     */
    @Override
    public String fuelType() {
        return "no fuel";
    }

    /**
     * Starts the bicycle.
     */
    @Override
    public void start() {
        System.out.println("Bicycle started");
    }

    /**
     * Stops the bicycle.
     */
    @Override
    public void stop() {
        System.out.println("Bicycle stopped");
    }

    /**
     * Gets the current speed of the bicycle.
     * @return the current speed
     */
    @Override
    public int getCurrentSpeed() {
        return super.getCurrentSpeed();
    }
}
