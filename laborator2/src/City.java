/* Author: Frij Alexandra-Stefania */
public class City extends Location {
    private int population;

    /**
     * the constructor method, initialize the class with the given parameters
     * additionally, it uses the constructor of the parent class
     * @param name the name for the city
     * @param x the x coordinate
     * @param y the y coordinate
     * @param population the population of the city
     */
    public City(String name, int x, int y, int population) {
        super(name, "city", x, y);
        this.population = population;
    }

    /**
     * the getter method for the population field
     * @return the value of population field
     */
    public int getPopulation() {
        return population;
    }

    /**
     * the setter of the population field
     * @param population the given value for the field
     */
    public void setPopulation(int population) {
        this.population = population;
    }
}
