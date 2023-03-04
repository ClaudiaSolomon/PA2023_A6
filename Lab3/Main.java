package Lab3;

import Lab3.Company;

public class Main {
    public static void main(String[] args) {
        Company company1=new Company("claudiu");
        Company company2=new Company(null);
        System.out.println(company1.compareTo(company2));

    }
}