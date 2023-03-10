package Lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Person implements Comparable<Person>, Node {
    protected String name;
    protected String birthDate;
    protected  static int idMax;
    protected int id;
    private Map<Node, String> relationships = new HashMap<>();
    public static int[][] matrixRelationships =new int[25][25];
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    public static int getIdMax() {
        return idMax;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Lab3.Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
        if(node instanceof Person) {
            matrixRelationships[this.getId()][node.getId()]=1;
        }
        if(node instanceof Company) {
            matrixRelationships[this.getId()][node.getId()+Person.getIdMax()]=1;
        }
    }
    public static int PrintMatrixRelationships() {
        for (int i = 1; i <= Network.getNumberOfNodes(); i++) {
            for (int j = 1; j <= Network.getNumberOfNodes(); j++) {
                System.out.print(matrixRelationships[i][j]+" ");
            }
            System.out.println();
        }
        return 0;
    }
}
