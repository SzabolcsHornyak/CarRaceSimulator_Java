
public class Truck {
    // speed: 100km/h. 5% chance of breaking down for 2 hours.
    Integer Speed = 100;

    // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
    String name = "";

    // holds how long its still broken down.
    Integer breakdownTurnsLeft = 0;

    Integer distanceTraveled = 0;

    public Truck(){
        int  truckNumber = Main.RandNumber (0,1000);
        this.name = Integer.toString(truckNumber);
    }
    // The vehicle travels for an hour. It increases the distance traveled.
    // Call this from the main class only!
    public void moveForAnHour() {

        // speed: 100km/h. 5% chance of breaking down for 2 hours.
        if (Main.RandNumber(1,100)<6) {
            if (this.breakdownTurnsLeft<1){
                this.breakdownTurnsLeft = 2;
            }
        }

        if (breakdownTurnsLeft==0)
        {
            this.distanceTraveled += this.Speed;
        } else
        {
            this.breakdownTurnsLeft --;
        }
    }
}
