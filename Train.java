import java.util.ArrayList;

public class Train implements TrainRequirements{

    public Engine engine;
    //public Car car;
    //public int nCars;
    //public int passenger_capacity;
    public ArrayList <Car> cars_attached = new ArrayList <>();

    /**
     * This is the constructor for a Train 
     * @param fuelType
     * @param currentFuelLevel
     * @param fuelCapacity
     * @param nCars
     * @param passengerCapacity
     */
    public Train (FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity);
        //this.nCars = nCars;
        //this.passenger_capacity = passengerCapacity;
        //this.car = new Car(passengerCapacity);
        this.cars_attached = new ArrayList <Car>(nCars);
        /**
         * There is no limit of the number of cars that ik of so i'll leave it like this
         */
        for (int i = 0; i < nCars; i++){
            //this.car = new Car(passengerCapacity);
            cars_attached.add(new Car(passengerCapacity));
        }
    }

    /**
     * This retrieves the engine type of a train
     * @return Engine: train's engine type
     */
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * This retrieves a certain car from a train using a number
     * @return Car: a train car with a certain number
     */
    public Car getCar(int i){
        return cars_attached.get(i);
    }

    /**
     * This gets a train's maximum capacity
     * @return int: the number of maximum seats in a train
     */
    public int getMaxCapacity(){
        // Car current_car; //this does not initalize it many times
        // int car_size;
        // for (int i = 0; i < this.nCars; i++){
        //     current_car = cars_attached.get(i);
        //     car_size = current_car.getCapacity();
        //     train_capacity = car_size + train_capacity;
        // }
        // getCapacity()
        // return 
        //
        /**
         * NOT NEEDED SINCE I CAN DO FUNCTIONS DIRECTLY ON THE ATTRIBUTES/PARAMETERS OF THE CLASS
         */
        //we need to add the number of passengers in each car

        int maximum_capacity = 0;
        
        for (Car car: cars_attached){
            maximum_capacity += car.getCapacity();
        }
        return maximum_capacity;
    }

    /**
     * This returns the amount of remaining seats in a train
     * @return: Numerical value for train seats available
     */
    public int seatsRemaining(){
        //Car current_car; 
        ///int car_size;
        int train_capacity = 0;
        /**
         * By putting the variable here, they will not be initialised many times within a loop or
         * be very far up in the attributes because it will be inconvenient
         */
        for (Car car: cars_attached){
            train_capacity += car.seatsRemaining();
            // current_car = cars_attached.get(i);
            // car_size = current_car.seatsRemaining();
            // train_capacity = car_size + train_capacity;
        }
        return train_capacity;
    }

    /**
     * This prints the users in each train car.
     */
    public void printManifest (){
        for (int i = 0; i < cars_attached.size(); i++){
            System.out.println("_______________________________________________");
            System.out.println(" ");
            System.out.println("These are all the passengers in car number " + (i+1));
            System.out.println(" ");
            cars_attached.get(i).printManifest(); 
            /**
            * I doubt this would work... LATER... this worked!!!
            */ 
            System.out.println("_______________________________________________");
        }

    }
    public static void main(String[] args){
        Train myTrain = new Train (FuelType.ELECTRIC, 700,1000,3,75);
        myTrain.getEngine();
        myTrain.getCar(1);
        Passenger myPassenger1 = new Passenger ("Claire");
        myTrain.getCar(1).addPassenger(myPassenger1);
        Passenger myPassenger2 = new Passenger ("Chris");
        myTrain.getCar(1).addPassenger(myPassenger2);
        Passenger myPassenger3 = new Passenger ("Cathy");
        myTrain.getCar(0).addPassenger(myPassenger3);
        System.out.println(myTrain.getMaxCapacity());
        System.out.println(myTrain.seatsRemaining());
        myTrain.printManifest();
        /**
         * All of my testing works :). But i would like for the train cars to not start at 0 and rather start at 1
         */
    }

}
