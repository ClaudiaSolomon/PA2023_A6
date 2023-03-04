package Lab3;

import static java.lang.Integer.parseInt;

public class Company implements Comparable<Company>, Node {
    private String name;
    public Company(String name)
    {
        this.name=name;
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

    public int compareTo(Company company)
    {
        if (this.name == null || company.name == null) {
            NullPointerException e=new NullPointerException();
            throw(e);
        }


        int x;
        if(this.name.length()>company.name.length())
            x=company.name.length();
        else
            x=this.name.length();
        for(int i=0;i<x;i++)
        {
            if(this.name.charAt(i)!=company.name.charAt(i))
            {
                return (this.name.charAt(i)-company.name.charAt(i));
            }
        }
        if(this.name.length()==company.name.length())
            return 0;
        else
        {
            if(this.name.length()>company.name.length())
            {
                return 1;
            }
            else  return -1;
        }

    }
}
