/**
 * Interface for vehicles that can start and stop.
 */
public interface Vehicle {

    /**
     * Starts the vehicle.
     */
    void start();

    /**
     * Stops the vehicle.
     */
    void stop();

    /**
     * Gets the current speed of the vehicle.
     * @return the current speed
     */
    int getCurrentSpeed();
}
