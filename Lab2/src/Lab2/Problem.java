package Lab2;

import Lab2.Locations.Location;
import Lab2.Roads.Road;

import java.util.ArrayList;

public class Problem {
    private ArrayList<Location> locations=new ArrayList<Location>();
    private ArrayList<Road> roads=new ArrayList<Road>();
    private int countRoads=0;
    public void AddLocation(Location location)
    {
        locations.add(location);
    }
    public void AddRoad(Road road)
    {
      roads.add(road);
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "locations=" + locations + "\n"+
                ", roads=" + roads +
                ", countRoads=" + countRoads +
                '}';
    }
    public boolean validLocation(Location location)
    {
        for(Location i:locations) {
            if (location.equals(i) == true) {
                return false;
            }
        }
       return true;
    }
    public boolean validRoad(Road road)
    {
        for(Road i:roads) {
            if (roads.equals(i) == true) {
                return false;
            }
        }
        return true;
    }
    public boolean validPath(Location location1,Location location2,ArrayList<Road> roadsGiven)
    {
        double euclidianDistance=Math.sqrt((location2.getX()-location1.getX())*(location2.getX()-location1.getX())+(location2.getY()-location1.getY())*(location2.getY()-location1.getY()));
        int sumOfRoads=0;
        for(Road i:roadsGiven)
        {
            sumOfRoads+=i.getLength();
        }
        if(euclidianDistance>sumOfRoads) return false;
        return true;
    }
}
