package Lab3;
import java.util.Collection;
import static java.lang.Integer.parseInt;

public class Company implements Comparable<Company>, Node {
    private String name;
    private int id;
    private static int idMax;
    public Company(String name)
    {
        this.name=name;
        idMax++;
        id=idMax;
    }

    public static int getIdMax() {
        return idMax;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Lab3.Company{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Company company) {
        return this.name.compareTo(company.name);
    }
}
