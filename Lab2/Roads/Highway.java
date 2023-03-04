package Lab2.Roads;

import Lab2.Roads.Road;

public class Highway extends Road {
    public Highway(int length,int speedLimit)
    {
        this.length=length;
        this.speedLimit=speedLimit;
        this.type="highway";
    }
}
