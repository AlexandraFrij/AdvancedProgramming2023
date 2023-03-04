public class Main {
    public static void main(String[] args) {
        Location location1 = new Location("Iasi", Location.locationsType.city, 120, 350);
        System.out.println(location1);
        Location location2 = new Location("Oradea", Location.locationsType.city, 455, 670);
        System.out.println(location2);
        Road road1 = new Road(Road.roadType.highway, 5600, 100);
        System.out.println(road1);
        Road road2 = new Road(Road.roadType.country, 1050, 70);
        System.out.println(road2);
    }
}