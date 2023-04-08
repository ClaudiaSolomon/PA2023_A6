package org.example.Lab7;


import org.example.Lab7.Exploration;
import org.example.Lab7.ExplorationMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Robot implements Runnable {
    private String name;
    private boolean running=true;
    private static Map<Robot,Integer> numberOfTokens=new HashMap<>();
    Exploration explore;
    public Robot(String name) {
        this.name = name;
        this.explore=new Exploration();
    }

    public static Map<Robot, Integer> getNumberOfTokens() {
        return numberOfTokens;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        while (running) {
//            pick a new cell to explore
            int row= (int) (Math.random()*(ExplorationMap.getMatrix().length));
            int col=(int)(Math.random()*(ExplorationMap.getMatrix()[0].length));
            if(explore.getMap().visit(row, col, this)==false)
            {
                running=false;
            }
            //System.out.println(this.name+" visited a new cell");
            //            make the robot sleep for some time
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void stop()
    {
        running=false;
    }
    public void sleep(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}