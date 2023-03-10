package Lab3;

public class Designer extends Person{
    private int numberOfDrawings;
    public Designer(String name, String birthdate,int numberOfDrawings)
    {
        this.name=name;
        this.birthDate=birthdate;
        this.numberOfDrawings=numberOfDrawings;
        idMax++;
        id=idMax;
    }
}
