public class Main {
    public static void main(String[] args) {

       Location location=new Location(Location.LocationType.CITY,"Iasi",134,124);
        System.out.println(location.getName());
        Road road=new Road(Road.RoadType.HIGHWAY,40,100);
        System.out.println(road.toString());
    }
}