package org.example.Lab7;


import org.example.Lab7.Exploration;
import org.example.Lab7.ExplorationMap;

public class Robot implements Runnable {
    private String name;
    private boolean running;
    Exploration explore;
    public Robot(String name) {
        this.name = name;
        this.explore=new Exploration();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        running=true;
        Boolean vizitare;
        while (running) {
//            pick a new cell to explore
            int row= (int) (Math.random()*(ExplorationMap.getMatrix().length));
            int col=(int)(Math.random()*(ExplorationMap.getMatrix()[0].length));
            vizitare=explore.getMap().visit(row, col, this);
            //System.out.println(this.name+" visited a new cell");
            //            make the robot sleep for some time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                running=false;
                throw new RuntimeException(e);
            }
            if(vizitare==false) return;
        }
    }
}