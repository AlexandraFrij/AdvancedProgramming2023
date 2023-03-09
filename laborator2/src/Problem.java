/* Author: Frij Alexandra-Stefania */
public class Problem {
    private Location[] locations;
    private Road[] roads;
    private int locationsCount;
    private int roadsCount;

    /**
     * the constructor of class Problem, initialize the locations and roads arrays as well the count of both arrays
     */
    public Problem() {
        locations = new Location[100];
        roads = new Road[100];
        locationsCount = 0;
        roadsCount = 0;
    }

    /**
     * the method allows to add a new location of type city as long as it doesn't exist already
     * @param name the name for city
     * @param x the x coordinate of the city
     * @param y the y coordinate of the city
     * @param population the population number
     */
    public void addCity(String name, int x, int y, int population) {
        City city = new City(name, x, y, population);
        boolean exists = false;
        for (int i = 0; i < locationsCount && !exists; i++)
            if (locations[i].equals(city)) {
                System.out.println("Instance already exists");
                exists = true;
            }
        if (!exists) {
            locations[locationsCount] = city;
            locationsCount++;
        }

    }

    /**
     * the method allows to add a new location of type airport as long as it doesn't exist already
     * @param name the airport's name
     * @param x the x coordinate for airport
     * @param y the y coordinate for airport
     * @param terminals the number of terminals
     */
    public void addAirport(String name, int x, int y, int terminals) {
        Airport airport = new Airport(name, x, y, terminals);
        boolean exists = false;
        for (int i = 0; i < locationsCount && !exists; i++)
            if (locations[i].equals(airport)) {
                System.out.println("Instance already exists");
                exists = true;
            }
        if (!exists) {
            locations[locationsCount] = airport;
            locationsCount++;
        }

    }

    /**
     * the method allows to add a new location of type gas station as long as it doesn't exist already
     * @param name the gas station's name
     * @param x the x coordinate for gas station
     * @param y the y coordinate of gas station
     * @param price the gas price
     */
    public void addGasStation(String name, int x, int y, double price) {
        GasStation station = new GasStation(name, x, y, price);
        boolean exists = false;
        for (int i = 0; i < locationsCount && !exists; i++)
            if (locations[i].equals(station)) {
                System.out.println("Instance already exists");
                exists = true;
            }
        if (!exists) {
            locations[locationsCount] = station;
            locationsCount++;
        }

    }

    /**
     * the method allows to add a new road as long as it doesn't exist already
     * @param name the name of the road
     * @param location1 the first location of the road, can be either a city, gas station or airport
     * @param location2 the second location of the road,  can be either a city, gas station or airport
     * @param type the type of the road, can be either a highway, country or express
     * @param length the length of the road
     * @param speedLimit the speed limit of the road
     */
    public void addRoad(String name, Location location1, Location location2, Road.roadType type, float length, int speedLimit) {
        Road road = new Road(name, location1, location2, type, length, speedLimit);
        boolean exists = false;
        for (int i = 0; i < roadsCount; i++)
            if (roads[i].equals(road)) {
                System.out.println("Instance already exists");
                exists = true;
            }
        if (!exists) {
            roads[roadsCount] = road;
            roadsCount++;
        }

    }

    /**
     * the method determines a route between 2 given locations
     * it prints the roads' information if a route is found or a negative message otherwise
     * @param startLocation the start location
     * @param endLocation the end location
     */
    public void determineRoute(Location startLocation, Location endLocation) {
        int i = 0;
        while (i < roadsCount && roads[i].getLocation1().equals(startLocation) != true)
            i++;
        if (i == roadsCount)
            System.out.println("There is no route from start location to end location");
        else {
            Location currentLocation = roads[i].getLocation2();
            Road[] route = new Road[100];
            route[0] = roads[i];
            int j = 1;
            while (currentLocation.equals(endLocation) != true) {
                i = 0;
                while (i < roadsCount)
                    if (roads[i].getLocation1().equals(currentLocation))
                        break;
                    else i++;
                if (i == roadsCount) {
                    System.out.println("There is no route from start location to end location");
                    return;
                } else {
                    currentLocation = roads[i].getLocation2();
                    if (j < route.length) {
                        route[j] = roads[i];
                        j++;
                    }

                }
            }
            System.out.println("The route is: ");
            for (i = 0; i < j; i++) {
                System.out.println(route[i]);
            }
        }

    }
}
