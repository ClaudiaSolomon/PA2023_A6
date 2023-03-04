package Lab2.Locations;

import Lab2.Locations.Location;

public class GasStation extends Location {
    private double gasPrice;
    public GasStation(String name, int x, int y,double gasPrice) {
        this.type = "gas station";
        this.name = name;
        this.x = x;
        this.y = y;
        this.gasPrice=gasPrice;
    }

    public void setGasPrice(float gasPrice) {
        this.gasPrice = gasPrice;
    }

    public double getGasPrice() {
        return gasPrice;
    }
}