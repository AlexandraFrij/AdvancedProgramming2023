/**
 * the Road class contains information about a road such as type (an enum), length( float) and speedLimit(int)
 */
public class Road {
    enum roadType {
        highway, express, country
    }

    private roadType type;
    private float length;
    private int speedLimit;

    /**
     * constructor method for Road class
     *
     * @param type       the given value for the type variable
     * @param length     the given value for the length variable
     * @param speedLimit the given value for the speedLimit variable
     */
    public Road(roadType type, float length, int speedLimit) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
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
    public float getLength() {
        return length;
    }

    /**
     * setter method for the length field
     *
     * @param length the float given value for initialization
     */
    public void setLength(float length) {
        this.length = length;
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
     * the toString method overriden for the Location class
     *
     * @return information about an object from class Road (type, length, speed limit)
     */
    @Override
    public String toString() {
        return "Road{ type = " + type + ", length = " + length + ", speed limit = " + speedLimit + " }";
    }
}
