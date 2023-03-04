package Lab2.Locations;

import Lab2.Locations.Location;

public class City extends Location {
    private int population;
public City(String name,int x,int y,int population)
{
    this.type="city";
    this.name=name;
    this.x=x;
    this.y=y;
    this.population=population;
}

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }
}
