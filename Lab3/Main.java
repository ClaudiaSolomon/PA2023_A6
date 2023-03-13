package Lab3;

import Lab3.Company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Company> companies=new ArrayList<>();
        Company company1=new Company("centric");
        Company company2=new Company("amazon");
        Company company3=new Company("levi9");
        companies.add(company1);
        companies.add(company2);
        companies.add(company3);
        Collections.sort(companies);

        ArrayList<Person> persons= new ArrayList<>();
        Person person1=new Programmer("andrei","19-01-1999",100);
        Person person2=new Designer("marius","10-11-2000",45);
        Person person3=new Programmer("andreea","01-01-1997",89);
        Person person4=new Designer("maria","11-09-2001",78);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        Collections.sort(persons);

        Network network=new Network();
        for(Company i:companies)
        {
            network.addNode(i);
        }
        for(Person i:persons)
        {
            network.addNode(i);
        }
        //System.out.println(network);

       person1.addRelationship(person2,"best-friends");
       person1.addRelationship(company1,"boss");
       person2.addRelationship(person1,"best-friends");
       person2.addRelationship(company3,"boss");
        person3.addRelationship(company2,"boss");
        person4.addRelationship(person3,"best-friends");
        person3.addRelationship(company3,"boss");

        //System.out.println(Person.PrintMatrixRelationships());
        Network.Importance();
        //System.out.println(Network.getNumberOfConnections());
        System.out.println(Network.PrintWithImportance());
        System.out.println(Network.GetRelationships());


    }
}