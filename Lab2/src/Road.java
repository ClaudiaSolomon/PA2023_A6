public class Road {
    public enum RoadType {
        HIGHWAY,
        EXPRESS;
    }
    private RoadType type;
    private int length,speedLimit;
    Road(RoadType type,int length,int speedLimit)
    {
        this.length=length;
        this.speedLimit=speedLimit;
        this.type=type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }
    public RoadType getType(RoadType type)
    {
        return this.type;
    }

   public void setLength(int length)
    {
        this.length=length;
    }
   public void setSpeedLimit(int speedLimit)
    {
        this.speedLimit=speedLimit;
    }

    public int getLength() {
        return length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
