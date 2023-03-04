package Lab3;

public class Person implements Comparable<Person>, Node {
    private String name;

    public Person(String name) {
        this.name = name;
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

    public int compareTo(Person person)
    {
        if (this.name == null || person.name == null) {
            NullPointerException e=new NullPointerException();
            throw(e);
        }
        int x;
        if(this.name.length()>person.name.length())
            x=person.name.length();
        else
            x=this.name.length();
        for(int i=0;i<x;i++)
        {
            if(this.name.charAt(i)!=person.name.charAt(i))
            {
                return (this.name.charAt(i)-person.name.charAt(i));
            }
        }
        if(this.name.length()==person.name.length())
            return 0;
        else
        {
            if(this.name.length()>person.name.length())
            {
                return 1;
            }
            else  return -1;
        }
    }
}
