import java.util.ArrayList;

public class Car implements CarRequirements {

    /**
     * Attributes for the class of car but it only takes 1 parameter in the constructor
     */
    private int maximum_capacity;
    private ArrayList <Passenger> current_passengers = new ArrayList <>();
    
    /**
     * additional variables that are used in this class
     * They could have been defined  inside of the methods themselves but oh well
     * I'm not sure if they should be private too
     */
    int free_space;
    int i;
    int empty_seats;

    /**
     * This is the constructor for a train car
     * @param maximum_capacity
     */
    public Car (int maximum_capacity){ 
        /**
         * String [] args????
         * Go and re-research why & when this is used
         */ 
        this.maximum_capacity=maximum_capacity;
        this.current_passengers = new ArrayList <Passenger> (maximum_capacity);
    }

    /**
     * This gets the capacity of seats in a train car
     * @return int: The number value for the total seats on a train car
     */
    public int getCapacity (){ 
        return this.maximum_capacity;
    }

    /**
     * This gets the number of seats remaining in the car of a train when used 
     * @return int: Number of available/empty seats on a train car
     */
    public int seatsRemaining(){
        return this.maximum_capacity - current_passengers.size();
        /**
         * Initially I had some long long method but you can use the attributes by themselves
         */
    }

    /**
     * This adds a passenger to a train car. Gives appropriate error messages too.
     * @return T/F: If a passenger has gotten onto the train car or not.
     */
    public Boolean addPassenger(Passenger p){
        int empty_seats = seatsRemaining();
    
        if (empty_seats > 0){
            if (current_passengers.contains(p)){
                System.out.println("This passenger is already on board the Train and cannot board again");
                return true;
            } else {
                current_passengers.add(p);
                return true; 
            }
        } else {
            return false;
        }
    }

    /**
     * This removes a passenger from a train car
     * @return T/F: If a passenger has been removed from a train car or not
     */
    public Boolean removePassenger(Passenger p){
        int array_size = current_passengers.size();
        if (array_size == 0){
            System.out.println("This train car is empty.");
            return false;
        }
        if (array_size > 0 && current_passengers.contains(p)){
            current_passengers.remove(p);
            return true;
        } else {
            System.out.println("This passenger does not exist");
            return false;
        }
            /**
             * NOTES:
             * In all java, you need to have a return outside of all loop/conditional statements. 
             * the program expects it. Think about it like paths to a castle
             * you can have an if statement which has a return 
             * then you can do if else with returns
             * but after the else return nothing else in the method can be accessed
             */
    }

    /**
     * This prints the passengers names in a train car
     */
    public void printManifest(){
        if (current_passengers.size() > 0){
            for (Passenger p:current_passengers){
                System.out.println(p.getName());
            } 
        } else {
            System.out.println ("This car is EMPTY");
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car(100);
        Passenger myPassenger1 = new Passenger ("Claire");
        Passenger myPassenger2 = new Passenger ("Chris");
        Passenger myPassenger3 = new Passenger ("Cathy");
        System.out.println(myCar.getCapacity());
        System.out.println(myCar.seatsRemaining());
        myCar.addPassenger(myPassenger1);
        myCar.addPassenger(myPassenger2);
        myCar.addPassenger(myPassenger3);
        myCar.printManifest();
        myCar.removePassenger(myPassenger3);
        myCar.printManifest();
        /**
         * All of my testing works. I needed to populate Passenger list in order to test my code.
         * Instead, I couldve done more information for the passenger or even add birthdates etc.
         * hello
         */
    }

}