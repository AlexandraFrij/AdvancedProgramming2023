/* Author: Frij Alexandra-Stefania */
public class GasStation extends Location {
    private double gasPrice;

    /**
     * the constructor method, initialize the class with the given parameters
     * additionally, it uses the constructor of the parent class
     * @param name the name for the gas station
     * @param x the x coordinate
     * @param y the y coordinate
     * @param gasPrice the price for gas
     */
    public GasStation(String name, int x, int y, double gasPrice) {
        super(name, "gas station", x, y);
        this.gasPrice = gasPrice;
    }

    /**
     *  the getter method for the price field
     * @return the value of price
     */
    public double getGasPrice() {
        return gasPrice;
    }

    /**
     * the setter of the terminals field
     * @param gasPrice the given value for initialization
     */
    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }
}
