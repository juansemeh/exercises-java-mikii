/**
 * Abstract class representing a transport vehicle.
 * Implements the Vehicle interface.
 */
public abstract class Transport implements Vehicle {
    protected String brand;
    protected String model;
    protected int maxSpeed;
    protected int currentSpeed;

    /**
     * Constructor for Transport.
     * @param brand the brand of the vehicle
     * @param model the model of the vehicle
     * @param maxSpeed the maximum speed of the vehicle
     */
    public Transport(String brand, String model, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0;
    }

    /**
     * Abstract method to get the fuel type.
     * @return the fuel type as a string
     */
    public abstract String fuelType();

    /**
     * Displays information about the vehicle.
     */
    public void showInformation() {
        System.out.printf("Brand: %s, Model: %s, Max Speed: %d, Current Speed: %d%n", brand, model, maxSpeed, currentSpeed);
    }

    /**
     * Accelerates the vehicle by the given amount, not exceeding maxSpeed.
     * @param amount the amount to accelerate
     */
    public void accelerate(int amount) {
        currentSpeed = Math.min(currentSpeed + amount, maxSpeed);
        System.out.println("Accelerated. Current speed: " + currentSpeed);
    }

    /**
     * Decelerates the vehicle by the given amount, not below 0.
     * @param amount the amount to decelerate
     */
    public void decelerate(int amount) {
        currentSpeed = Math.max(currentSpeed - amount, 0);
        System.out.println("Decelerated. Current speed: " + currentSpeed);
    }

    /**
     * Gets the current speed of the vehicle.
     * @return the current speed
     */
    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Abstract method to start the vehicle.
     */
    @Override
    public abstract void start();

    /**
     * Abstract method to stop the vehicle.
     */
    @Override
    public abstract void stop();
}
