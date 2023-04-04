package org.example.Lab7;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private static final SharedMemory mem = new SharedMemory(10);
    private final ExplorationMap map = new ExplorationMap(2);
    private final List<Robot> robots = new ArrayList<>();
    public void start() {
        for (Robot robot : robots) {
             Thread thread = new Thread(robot);
             thread.start();
        }
    }
    public static void main(String args[]) {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }

    private void addRobot(Robot robot) {
        robots.add(robot);
    }

    public ExplorationMap getMap() {
        return this.map;
    }

    public static SharedMemory getMem() {
        return mem;
    }
}