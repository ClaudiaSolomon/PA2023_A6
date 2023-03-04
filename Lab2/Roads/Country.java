package Lab2.Roads;

import Lab2.Roads.Road;

public class Country extends Road {
    public Country(int length,int speedLimit)
    {
        this.length=length;
        this.speedLimit=speedLimit;
        this.type="country";
    }
}
