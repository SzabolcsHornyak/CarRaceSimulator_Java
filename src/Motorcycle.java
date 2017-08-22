public class Motorcycle {

    // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
    String name = "";
    // The number of the instance created. Used for its name.
    Integer nameNumber = 1;

    // speed is 100km/h. If rains, travels with 5-50km/h slower (randomly).
    Integer Speed = 100;

    Integer distanceTraveled = 0;

    public  Motorcycle(){
        this.name = "Motorcycle " + nameNumber.toString();
        nameNumber++;
    }
    // The vehicle travels for an hour. It increases the distance traveled.
    // Call this from the main class only!
    public void moveForAnHour() {
        if (Main.isRaining) {
            this.Speed = Main.RandNumber(5,50);
        } else
        {
            this.Speed = 100;
        }
        this.distanceTraveled += this.Speed;
    }
}
