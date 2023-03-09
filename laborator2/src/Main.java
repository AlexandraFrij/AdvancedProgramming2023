/* Author: Frij Alexandra-Stefania */
public class Main {
    public static void main(String[] args) {
        City location1 = new City("Iasi", 120, 230, 150000);
        Airport location2 = new Airport("Henri Coanda", 455, 670, 14);
        GasStation location3 = new GasStation("Petrom", 400, 500, 7.3);
        Problem problem1 = new Problem();
        problem1.addCity("Iasi", 120, 230, 150000);
        problem1.addAirport("Henri Coanda", 455, 670, 14);
        problem1.addGasStation("Petrom", 400, 500, 7.3);
        problem1.addRoad("AN23", location1, location2, Road.roadType.highway, 5600, 100);
        Road road1 = new Road("AN23", location1, location2, Road.roadType.highway, 5600, 100);
        Road road2 = new Road("DN12", location2, location3, Road.roadType.country, 1050, 70);
        Road road3 = new Road("D34", location1, location3, Road.roadType.express, 300, 80);
        problem1.addRoad("DN12", location2, location3, Road.roadType.country, 1050, 70);
        problem1.addRoad("D34", location1, location3, Road.roadType.express, 300, 80);
        problem1.determineRoute(location1, location3);
        // System.out.println(problem1.getRoad(1));
        problem1.addRoad("DN12", location2, location3, Road.roadType.country, 1050, 70);
       /* road1.setLength(location1.getCoordinateX(), location1.getCoordinateY(), location2.getCoordinateX(), location2.getCoordinateY());
        road2.setLength(location2.getCoordinateX(), location2.getCoordinateY(), location3.getCoordinateX(), location3.getCoordinateY());
        road3.setLength(location1.getCoordinateX(), location1.getCoordinateY(), location3.getCoordinateX(), location3.getCoordinateY());*/
    }
}