import java.util.ArrayList;
import java.util.Arrays;

public class Car {

    // Make a list from the words here:
    // http://www.fantasynamegenerators.com/car-names.php and pick 2 randomly for each instance.
    String name = "";
    // the normal speed of the car. Set to a random number in the constructor between 80-110km/h.
    Integer Speed = 0;
    Integer originalSpeed = 0;

    // holds the current distance traveled.
    Integer distanceTraveled = 0;

    private static ArrayList<String > CarNames = new ArrayList<String >(Arrays.asList(
            "Meridian", "Evolution", "Silver", "Aeon", "Onyx", "Scorpion", "Freedom",
            "Momentum", "Prestige", "Dawn", "Climax", "Adventure", "Presence", "Elysium",
            "Raven", "Voyage", "Motion", "Falcon", "Pulse", "Obsidian" ));

    // -----------=== CONSTRUCTOR ===--------------------------
    public Car(){
        //Randomize Car name
        int  CarName1 = Main.RandNumber(0,CarNames.size());
        int  CarName2 = Main.RandNumber(0,CarNames.size());

        this.name = CarNames.get(CarName1) + " " + CarNames.get(CarName2);
        this.Speed = Main.RandNumber(80,110);
        this.originalSpeed = this.Speed;
    }

    // Since cars are so fast there is a 30% chance that they can go only with 70km/h speed.
    // Call this from the Main class!
    public void setSpeedLimit(int limit) {
        this.Speed = limit;
    }

    // The vehicle travels for an hour. It increases the distance traveled.
    // Call this from the main class only!
    public void moveForAnHour() {

        this.distanceTraveled += Speed;
        // Get bac to normal speed
        this.Speed = this.originalSpeed;
    }
}
