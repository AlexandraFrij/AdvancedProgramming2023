/* Author: Frij Alexandra-Stefania */
import static java.lang.Math.sqrt;
public class Road {
    public enum roadType {
        highway, express, country
    }

    private String name;
    private Location location1;
    private Location location2;
    private roadType type;
    private double length;
    private int speedLimit;

    /**
     * the constructor method for the class, initialize the class
     *
     * @param name       the given value for the name variable
     * @param location1  the given value for the location1 variable, can be either a city, airport or gas station
     * @param location2  the given value for the location2 variable, can be either a city, airport or gas station
     * @param type       the type of road, takes value from the roadType enum, can be either a highway, country or express
     * @param length     the given value for the length variable
     * @param speedLimit the given value for the speedLimit variable
     */
    public Road(String name, Location location1, Location location2, roadType type, double length, int speedLimit) {
        this.name = name;
        this.location1 = location1;
        this.location2 = location2;
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    /**
     * the getter method for the name field
     *
     * @return the value of name field
     */
    public String getName() {
        return name;
    }

    /**
     * the setter method for the name field
     *
     * @param name the string value given for initialization
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * the getter method for location1 field
     *
     * @return the value of location2 field
     */
    public Location getLocation1() {
        return location1;
    }

    /**
     * setter method for location1 field
     *
     * @param location1 the given location, that can be either a city, airport or gas station
     */
    public void setLocation1(Location location1) {
        this.location1 = location1;
    }

    /**
     * the getter method for location2 field
     *
     * @return the value of location2 field
     */
    public Location getLocation2() {
        return location2;
    }

    /**
     * setter method for location2 field
     *
     * @param location2 the given location, that can be either a city, airport or gas station
     */
    public void setLocation2(Location location2) {
        this.location2 = location2;
    }

    /**
     * getter method for type field
     *
     * @return the value of type field
     */
    public roadType getType() {
        return type;
    }

    /**
     * setter method for the type field
     *
     * @param type the roadType given value for initialization
     */
    public void setType(roadType type) {
        this.type = type;
    }

    /**
     * the getter method for length field
     *
     * @return the value of length field
     */
    public double getLength() {
        return length;
    }

    /**
     * the method sets the length of a road to the euclidean distance of the locations
     *
     * @param x1 x coordinate of the first location
     * @param y2 y coordinate of the first location
     * @param x2 x coordinate of the second location
     * @param y2 y coordinate of the second location
     */
    public void setLength(int x1, int y1, int x2, int y2) {
        this.length = sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    /**
     * the getter method for speedLimit field
     *
     * @return the value of speedLimit field
     */
    public int getSpeedLimit() {
        return speedLimit;
    }

    /**
     * setter method for the speedLimit field
     *
     * @param speedLimit the int given value for initialization
     */
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * the toString method override for the Location class
     *
     * @return information about an object from class Road (type, length, speed limit)
     */
    @Override
    public String toString() {
        return "Road{ name = " + name + " location 1 = " + location1 + " location 2 = " + location2 +
                " type = " + type + ", length = " + length + ", speed limit = " + speedLimit + " }";
    }

    /**
     * the method overrides the .equals function so that it returns false if the obj is null or not an instance of Road class, else true
     *
     * @param obj an object of a class
     * @return false if obj is null or not an instance of class Road, true otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Road))
            return false;
        Road other = (Road) obj;
        return name.equals(other.name);
    }
}
