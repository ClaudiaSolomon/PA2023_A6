package Lab2;

import Lab2.Locations.Location;
import Lab2.Roads.Road;

import java.util.ArrayList;

public class Problem {
    private ArrayList<Location> locations=new ArrayList<Location>();
    private ArrayList<Road> roads=new ArrayList<Road>();

    /**
     * This method adds an object of type Location to the array of locations only if it's valid
     * @param location an object of type Location
     */
    public void AddLocation(Location location)
    {
        if(validLocation(location)==true)
            locations.add(location);
    }

    /**
     * This method adds an object of type Road to the array of roads only if it's valid
     * @param road an object of type Road
     */
    public void AddRoad(Road road)
    {
      if(validRoad(road)==true)
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
                '}';
    }

    /**
     * This method checks if the location given is valid
     * @param location an object of type Location
     * @return uses the equals overridden method from Location to check if it's valid (true) or not (false)
     */
    public boolean validLocation(Location location)
    {
        for(Location i:locations) {
            if (location.equals(i) == true) {
                return false;
            }
        }
       return true;
    }

    /**
     * This method checks if the road given is valid
     * @param road an object of type Road
     * @return uses the equals overridden method from Road to check if it's valid (true) or not (false)
     */
    public boolean validRoad(Road road)
    {
        for(Road i:roads) {
            if (roads.equals(i) == true) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method checks if there is a road from the array of roads given which has the length >= euclidean distance between the coordinates of the two locations given
     * @param location1 an object of type Location
     * @param location2 an object of type Location
     * @param roadsGiven an array of objects of type Road
     * @return if there is at least a road that is valid, it returns true, otherwise false
     */
    public boolean validPath(Location location1,Location location2,ArrayList<Road> roadsGiven)
    {
        double euclideanDistance=Math.sqrt((location2.getX()-location1.getX())*(location2.getX()-location1.getX())+(location2.getY()-location1.getY())*(location2.getY()-location1.getY()));
        for(Road i:roadsGiven)
        {
            if(euclideanDistance<=i.getLength()) return true;
        }

        return false;
    }
}
