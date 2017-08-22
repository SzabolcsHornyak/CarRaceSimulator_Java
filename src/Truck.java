public class Truck {
    // speed: 100km/h. 5% chance of breaking down for 2 hours.
    public Integer speed = 100;

    // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
    public String name="";

    // holds how long its still broken down.
    public Integer breakdownTurnsLeft = 0;

    public Integer distanceTraveled = 0;

    // The vehicle travels for an hour. It increases the distance traveled.
    // Call this from the main class only!
    public static void moveForAnHour() {

    }
}
