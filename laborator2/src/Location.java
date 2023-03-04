/**
 * the Location class contains information about a location such as name( a string), type (an enum) and coordinates x,y (int)
 */
public class Location {
    enum locationsType {
        city, airport, gasStation
    }

    private String name;
    private locationsType type;
    private int coordinateX;
    private int coordinateY;

    /**
     * constructor method for Location class, initialize the variables of the class
     *
     * @param name the given value for the name variable
     * @param type the given value for the type variable
     * @param x    the given value for the coordinateX variable
     * @param y    the given for the coordinateY variable
     */
    public Location(String name, locationsType type, int x, int y) {
        this.name = name;
        this.type = type;
        this.coordinateX = x;
        this.coordinateY = y;
    }

    /**
     * getter for the name field
     *
     * @return the given value of name variable
     */
    public String getName() {
        return name;
    }

    /**
     * the setter for the name field, initializes the variable with the given value
     *
     * @param name the string given value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method for the type field
     *
     * @return the value of type variable
     */
    public locationsType getType() {
        return type;
    }

    /**
     * the setter for the type field, initializes the variable with the given value
     *
     * @param type the locationsType(enum) given value
     */
    public void setType(locationsType type) {
        this.type = type;
    }

    /**
     * getter method for the coordinateX field
     *
     * @return the value of coordinateX
     */
    public int getCoordinateX() {
        return coordinateX;
    }

    /**
     * the setter for the coordinateX field, initializes the variable with the given value
     *
     * @param coordinateX the int given value
     */
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * getter method for the coordinateY field
     *
     * @return the value of coordinateY
     */
    public int getCoordinateY() {
        return coordinateY;
    }

    /**
     * the setter for the coordinateY field, initializes the variable with the given value
     *
     * @param coordinateY the int given value
     */
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    /**
     * the toString method overriden for the Location class
     *
     * @return information about an object from class Location (name, type, coordinates)
     */
    @Override
    public String toString() {
        return "Location{ name = " + name + ", type = " + type + ", x coordinate = " + coordinateX
                + ", y coordinate = " + coordinateY + " }";
    }
}
