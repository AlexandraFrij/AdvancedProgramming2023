/* Author: Frij Alexandra-Stefania */
public class Airport extends Location {
    private int terminals;

    /**
     * the constructor method, initialize the class with the given parameters
     * additionally, it uses the constructor of the parent class
     * @param name the name for the airport
     * @param x the x coordinate
     * @param y the y coordinate
     * @param terminals the number of terminals
     */
    public Airport(String name, int x, int y, int terminals) {
        super(name, "airport", x, y);
        this.terminals = terminals;
    }

    /**
     *  the getter method for the terminal field
     * @return the number of existing terminals
     */
    public int getTerminals() {
        return terminals;
    }

    /**
     * the setter of the terminals field
     * @param terminals the given value for initialization
     */
    public void setTerminals(int terminals) {
        this.terminals = terminals;
    }
}
