public class Engine implements EngineRequirements{

    private FuelType fuel_type; 
    /**
    * Fuel type has to of fueltype since an enum was made elsewhere
    */
    private double current_fuel;
    private double maximum_fuel;

    /**
     * This is the constructor for a train's engine
     * @param fuel_type
     * @param current_fuel
     * @param maximum_fuel
     */
    public Engine(FuelType fuel_type, double current_fuel, double maximum_fuel){
        this.fuel_type = fuel_type;
        this.current_fuel = current_fuel;
        this.maximum_fuel = maximum_fuel;
    }

    /**
     * Im not sure which methods need to be public or private...
     * Especially since most mthods need to be accessed outside of the class, I will just make all of them public
     */

    /**
     * Gives the trains fuel type
     * @return Fueltype
     */
    public FuelType getFuelType(){
        return this.fuel_type;
    }

    /**
     * This gives the maximum amount of fuel for a train car
     * @return double: the number value for maximum fuel
     */
    public double getMaxFuel(){
        return this.maximum_fuel;
    }

    /**
     * This tells you the amount of fuel in a train car at a certain point
     * @return double: numerical value of fuel currently remaining in a train car
     */
    public double getCurrentFuel(){
        return this.current_fuel;
    }

    /**
     * This refuels a train car when needed
     */
    public void refuel(){
        this.maximum_fuel = this.current_fuel;
        /**
         * This changes the current fuel to maximum fuel when necessary
         * I cannot lie, cannot tell if it accurately works
         */
    }

    /**
     * This makes a train move and refuels when necessary
     * @return T/F: if the train is moving or not
     */
    public Boolean go(){
        if (this.current_fuel > 0){
            this.current_fuel = this.current_fuel - 10;
            System.out.println("The remaining fuel level is: " + this.current_fuel);
            return true;
        } else {
            System.out.println("There is no fuel left " + this.current_fuel);
            refuel();
            /**
             * This method initially went in an endless
             *  when its out of fuel refuel, not sure if its needed
            */
            return false;
        }

    }
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }

}