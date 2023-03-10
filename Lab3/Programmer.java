package Lab3;

public class Programmer extends Person{
    private int numberOfLinesWritten;
public Programmer(String name, String birthdate,int numberOfLinesWritten)
{
    this.name=name;
    this.birthDate=birthdate;
    this.numberOfLinesWritten=numberOfLinesWritten;
    idMax++;
    id=idMax;
}

}
