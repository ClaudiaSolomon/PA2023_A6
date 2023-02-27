public class Location {
    public enum LocationType {
       AIRPORT,
        CITY
    }
    private LocationType type;
    private String name;
    private int x,y;
    Location(LocationType type,String name,int x,int y)
    {
        this.type=type;
        this.name=name;
        this.x=x;
        this.y=y;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setType(LocationType type) {
        this.type = type;
    }
    public LocationType getType()
    {
        return this.type;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
