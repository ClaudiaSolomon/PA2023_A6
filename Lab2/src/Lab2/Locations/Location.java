package Lab2.Locations;

import java.util.Objects;

public abstract class Location {
    protected String type;
    protected String name;
    protected int x,y;
    public Location(){

    }
    public Location(String type,String name,int x,int y)
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


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Lab1.Location{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return getX() == location.getX() && getY() == location.getY() && getType().equals(location.getType()) && getName().equals(location.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getName(), getX(), getY());
    }
}

