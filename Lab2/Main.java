package Lab2;

import Lab2.Locations.Airport;
import Lab2.Locations.City;
import Lab2.Locations.GasStation;
import Lab2.Locations.Location;
import Lab2.Roads.Country;
import Lab2.Roads.Express;
import Lab2.Roads.Highway;
import Lab2.Roads.Road;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Problem pb = new Problem();
        Location[] sites = new Location[4];
        sites[0]= new City("Iasi",134,124,1000);
        sites[1]= new Airport("Otopeni",17,20,3);
        sites[2]=new City("Bucuresti",234,544,3000);
        sites[3]=new GasStation("Petrom",23,14,6.5);
        Location locationInvalid=new City("Iasi",134,124,1000);
        Location locationValid=new City("Cluj",16,124,2000);

        int index=0;
       while(index<4)
       {
           pb.AddLocation(sites[index]);
           index++;
       }
        System.out.println(pb.validLocation(locationInvalid));
        System.out.println(pb.validLocation(locationValid));
        Road[] roads = new Road[5];
       roads[0]=new Highway(40,130);
       roads[1]=new Highway(50,130);
       roads[2]=new Country(21,60);
       roads[3]=new Express(100,100);
       roads[4]=new Express(56,100);
       index=0;
        while(index<4)
        {
            pb.AddRoad(roads[index]);
            index++;
        }

        System.out.println(pb.toString());
        ArrayList<Road> roadsGiven=new ArrayList<Road>();
        roadsGiven.add(roads[0]);
        roadsGiven.add(roads[1]);
        roadsGiven.add(roads[3]);
        System.out.println(pb.validPath(sites[1],sites[3],roadsGiven));
    }
}