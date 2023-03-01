package Lab2.Roads;

import java.util.Objects;

public abstract class Road {
    protected String type;
    protected int length,speedLimit;
    public Road(){

    }
    public Road(String type,int length,int speedLimit)
    {
        this.length=length;
        this.speedLimit=speedLimit;
        this.type=type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setLength(int length)
    {
        this.length=length;
    }
   public void setSpeedLimit(int speedLimit)
    {
        this.speedLimit=speedLimit;
    }

    public String getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    @Override
    public String toString() {
        return "Lab1.Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return getLength() == road.getLength() && getSpeedLimit() == road.getSpeedLimit() && getType() == road.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLength(), getSpeedLimit());
    }
}
