package org.example.Lab4;

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
        System.out.println(listOfStudents);
        Set<Project> listOfProjects=new TreeSet<>();
        for (Project p : projects) {
            listOfProjects.add(p);
        }
        System.out.println(listOfProjects);
    }
}