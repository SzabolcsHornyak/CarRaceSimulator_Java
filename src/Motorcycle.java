public class Motorcycle {

    // speed is 100km/h. If rains, travels with 5-50km/h slower (randomly).
    public Integer speed = 100;

    // The number of the instance created. Used for its name.
    static Integer nameNumber = 1;

    // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
    static String name = "";

    static Integer distanceTraveled = 0;

    // The vehicle travels for an hour. It increases the distance traveled.
    // Call this from the main class only!
    public static void moveForAnHour() {

    }
}
