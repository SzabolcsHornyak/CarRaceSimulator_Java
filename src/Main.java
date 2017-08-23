import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        System.out.println("---------> CAR RACE RESULST <---------");
        System.out.printf("%-8s %-20s %-6s \n","Rank", "Name", "Distance");
        List<ArrayList<String>> carResults = new ArrayList();
        for (Car actcar : cars) {
            ArrayList<String> carInstance = new ArrayList<>();
            carInstance.add(actcar.name);
            carInstance.add(actcar.distanceTraveled.toString());
            carResults.add(carInstance);
            }
        carResults.sort((p1, p2) -> (new Integer(p1.get(1)).compareTo(new Integer(p2.get(1)))));
        Collections.reverse(carResults);

        int rank=1;
        for (List result : carResults) {
            System.out.printf("%-8s %-20s %-6s\n",rank, result.get(0), result.get(1) + " km");
            rank += 1;
        }

        System.out.println("\n\n--------> TRUCK RACE RESULST <--------");
        System.out.printf("%-8s %-20s %-6s \n","Rank", "Name", "Distance");
        List<ArrayList<String>> truckResults = new ArrayList();
        for (Truck actcar : trucks) {
            ArrayList<String> truckInstance = new ArrayList<>();
            truckInstance.add(actcar.name);
            truckInstance.add(actcar.distanceTraveled.toString());
            truckResults.add(truckInstance);
        }
        truckResults.sort((p1, p2) -> (new Integer(p1.get(1)).compareTo(new Integer(p2.get(1)))));
        Collections.reverse(truckResults);

        rank=1;
        for (List result : truckResults) {
            System.out.printf("%-8s %-20s %-6s\n",rank, result.get(0), result.get(1) + " km");
            rank += 1;
        }

        System.out.println("\n\n--------> MBIKE RACE RESULST <--------");
        System.out.printf("%-8s %-20s %-6s \n","Rank", "Name", "Distance");
        List<ArrayList<String>> mbikeResults = new ArrayList();
        for (Motorcycle actcar : motorcycles) {
            ArrayList<String> mbikeInstance = new ArrayList<>();
            mbikeInstance.add(actcar.name);
            mbikeInstance.add(actcar.distanceTraveled.toString());
            mbikeResults.add(mbikeInstance);
        }
        mbikeResults.sort((p1, p2) -> (new Integer(p1.get(1)).compareTo(new Integer(p2.get(1)))));
        Collections.reverse(mbikeResults);

        rank=1;
        for (List result : mbikeResults) {
            System.out.printf("%-8s %-20s %-6s\n",rank, result.get(0), result.get(1) + " km");
            rank += 1;
        }
    }

}
