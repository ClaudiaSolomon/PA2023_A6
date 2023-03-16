package org.example.Lab4;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    private static Map<Student, List<Project>> prefMap = new TreeMap<>();
    private static Map<Student,Project> greedyMap=new TreeMap<>();

    @Override
    public String toString() {
        return "Problem{" +
                "prefMap=" + prefMap +
                '}';
    }

    public static Map<Student, List<Project>> getPrefMap() {
        return prefMap;
    }

    public static Map<Student, Project> getGreedyMap() {
        return greedyMap;
    }

    public static void AddList(Student student, List<Project> projects) {
        prefMap.put(student,projects);
        //System.out.println(prefMap.get(student).size());
    }
    public static List<Student> DisplayLessPref()
    {
        int avg=prefMap.entrySet().stream()
        .mapToInt(e-> e.getValue().size())
        .sum();
        List<Student> pref = prefMap.entrySet().stream()
                .filter(e -> e.getValue().size()<avg/prefMap.size())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return pref;
    }
    public static void GreedyAlg()
    {
        List<Project> projectsToRemove=new ArrayList<>();
        int iterator,ok;
        for(Student i:prefMap.keySet()) {
            List<Project> j=prefMap.get(i);
                //System.out.println(j);
                iterator=0;
                ok=1;
                while(iterator<j.size()) {
                    if (projectsToRemove.size() == 0) {
                        greedyMap.put(i, j.get(iterator));
                        projectsToRemove.add(j.get(iterator));
                        break;
                    } else {
                        for (int poz = 0; poz < projectsToRemove.size(); poz++) {
                            if (j.get(iterator) == projectsToRemove.get(poz)) {
                                ok = 0;
                                break;
                            }
                        }
                        if (ok == 1) {
                            greedyMap.put(i, j.get(iterator));
                            projectsToRemove.add(j.get(iterator));
                            break;
                        }
                        if (ok == 0)
                        {
                            iterator++;
                            ok=1;
                        }
                    }
                }
            }
        }
    }

