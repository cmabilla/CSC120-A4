public class Passenger implements PassengerRequirements {
    
    private String name;

    /**
     * This is a constructor for a train passenger
     * @param name
     */
    public Passenger(String name) {
        this.name = name;
        /**
         * I could have added something like DOB
         * Honestly this class is underwhelming
         * but it uses methods from other classes so...
         */
    }

    /**
     * This makes a passenger board a train car, and returns appropriate error messages
     */
    public void boardCar(Car c){
        if (c.addPassenger(this)){
            System.out.println("You have boarded the car");
        } else {
            System.out.println("You have not boarded the car");
        }
    }

    /**
     * This makes a passenger get off a train car, and returns appropriate error messages
     */
    public void getOffCar(Car c){
        if (c.removePassenger(this)){
            System.out.println("You have gotten off of the train car");
        } else {
            System.out.println ("You cannot get off of the train car");
        }
    }

    /**
     * This gets the name of a passenger on the car of a train
     * @return String: passenger name
     */
    public String getName (){
        return this.name;
    }

}
