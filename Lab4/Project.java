package org.example.Lab4;

public class Project implements Comparable<Project> {
    private String name;
    public Project(String name)
    {
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public int compareTo(Project projects)
    {
        return this.name.compareTo(projects.name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}
