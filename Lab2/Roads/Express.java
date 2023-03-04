package Lab2.Roads;

import Lab2.Roads.Road;

public class Express extends Road {
    public Express(int length,int speedLimit)
    {
        this.length=length;
        this.speedLimit=speedLimit;
        this.type="express";
    }
}
