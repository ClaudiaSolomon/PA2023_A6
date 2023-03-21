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
        Problem.GreedyAlg();
        System.out.println(Problem.getGreedyMap());
        System.out.println("Least than the average of preferences: "+Problem.DisplayLessPref());

        Faker faker = new Faker();

        Student student1 = new Student(faker.name().name());
        Student student2 = new Student(faker.name().name());
        Student student3 = new Student(faker.name().name());
        //System.out.println(name_student);
        Project project1=new Project(faker.company().name());
        Project project2=new Project(faker.company().name());
        Project project3=new Project(faker.company().name());

        List<Student> fakerStudent=new ArrayList<>();
        fakerStudent.add(student1);
        fakerStudent.add(student2);
        fakerStudent.add(student3);

        List<Project> fakerProject1=new ArrayList<>();
        fakerProject1.add(project1);
        fakerProject1.add(project2);
        fakerProject1.add(project3);

        List<Project> fakerProject2=new ArrayList<>();
        fakerProject2.add(project1);
        fakerProject2.add(project2);

        List<Project> fakerProject3=new ArrayList<>();
        fakerProject3.add(project1);

        Collections.sort(fakerStudent);
       // System.out.println(name_project);
        Problem.AddList(fakerStudent.get(0),fakerProject1);
        Problem.AddList(fakerStudent.get(1), fakerProject2);
        Problem.AddList(fakerStudent.get(2), fakerProject3);
        System.out.println(Problem.getPrefMap());

        Problem.GreedyAlg();
        System.out.println(Problem.getGreedyMap());
    }
}