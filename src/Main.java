import java.util.Random;

public class Main {

    static Boolean isRaining = false; //30% chance of rain every hour
    static Car[] cars;
    static Truck[] trucks;
    static Motorcycle[] motorcycles;

    public static void main(String[] args) {
        NewGame();
    }


    public static void NewGame(){
        createVehicles(10);
        simulateRace();
        printRaceResults();
    }

    public static Integer RandNumber(Integer MinValue,Integer MaxValue){
        Random rand = new Random();
        int  ReturnRandValue = rand.nextInt ((MaxValue-MinValue)) + MinValue;
        return  ReturnRandValue;
    }

    // creates 10 cars, 10 trucks and 10 motorcycles
    public static void createVehicles(int vehicleNumbers){

        // Cars
        cars = new Car[vehicleNumbers];
        for(int i=0; i<cars.length; i++){
            cars[i] = new Car();
        }

        // Trucks
        trucks = new Truck[vehicleNumbers];
        for(int i = 0; i < trucks.length; i++){
            trucks[i] = new Truck();
        }

        // Motorcycles
        motorcycles = new Motorcycle[vehicleNumbers];
        for(int i = 0; i < motorcycles.length; i++){
            motorcycles[i] = new Motorcycle();
        }

    }

    // simulates the race by calling moveForAnHour() on every vehicle 50 times and setting whether its raining.
    public static void simulateRace() {

        for (int j=1; j<50; j++) {

            // rain
            if (RandNumber(0, 100) < 31) {
                isRaining = true;
            }

            // --------------------- CARS ----------------------------------------------------------
            // Since cars are so fast there is a 30% chance that they can go only with 70km/h speed.
            if (RandNumber(0, 100) < 31) {
                for (int i = 0; i < cars.length; i++) {
                    cars[i].setSpeedLimit(70);
                }
            }
            for (int i = 0; i < cars.length; i++) {
                cars[i].moveForAnHour();
            }

            // --------------------- TRUCKS --------------------------------------------------------
            for (int i = 0; i < trucks.length; i++) {
                trucks[i].moveForAnHour();
            }

            // --------------------- MOTORBIKE -----------------------------------------------------
            for (int i = 0; i < motorcycles.length; i++) {
                motorcycles[i].moveForAnHour();
            }

            isRaining = false;
        }
    }

    // prints each vehicle's name, distance traveled ant type.
    public static void printRaceResults() {
        System.out.printf("%-8s %-20s %-6s \n","Type", "Name", "Distance\n");
        for (Car actcar : cars) {
            System.out.printf("%-8s %-20s %-6s \n","CAR", actcar.name, actcar.distanceTraveled + " km");
        }
        for (Truck actcar : trucks) {
            System.out.printf("%-8s %-20s %-6s \n","TRUCK", actcar.name, actcar.distanceTraveled + " km");
        }
        for (Motorcycle actcar : motorcycles) {
            System.out.printf("%-8s %-20s %-6s \n","MBIKE", actcar.name, actcar.distanceTraveled + " km");
        }
    }

}
