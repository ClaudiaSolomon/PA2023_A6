package Lab2.Locations;

import Lab2.Locations.Location;

public class Airport extends Location {
    public int numberOfTerminals;
    public Airport(String name, int x, int y,int numberOfTerminals) {
        this.type = "airport";
        this.name = name;
        this.x = x;
        this.y = y;
        this.numberOfTerminals=numberOfTerminals;
    }

    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }

    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }
}