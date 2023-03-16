package org.example.Lab4;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);
        List<Student> listOfStudents=new LinkedList<>();
        for (Student s : students) {
            listOfStudents.add(s);
        }
        Collections.sort(listOfStudents);
       // System.out.println(listOfStudents);
        Set<Project> listOfProjects=new TreeSet<>();
        for (Project p : projects) {
            listOfProjects.add(p);
        }
        //System.out.println(listOfProjects);
        List<Project> listProj = new ArrayList<>(listOfProjects);
        List<Project> listProj2= new ArrayList<>();
        listProj2.add(listProj.get(0));
        listProj2.add(listProj.get(1));

        List<Project> listProj3= new ArrayList<>();
        listProj3.add(listProj.get(0));

        Problem.AddList(listOfStudents.get(0),listProj);
        Problem.AddList(listOfStudents.get(1), listProj2);
        Problem.AddList(listOfStudents.get(2), listProj3);
        System.out.println(Problem.getPrefMap());
       // System.out.println(Problem.DisplayLessPref());

        Faker faker = new Faker();

        String name_student = faker.name().name();
        //System.out.println(name_student);
        String name_project=faker.company().name();
       // System.out.println(name_project);

        Problem.GreedyAlg();
        System.out.println(Problem.getGreedyMap());
    }
}