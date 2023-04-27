package compulsory;

import java.util.List;
import java.util.ArrayList;
import java.lang.Thread;
import java.util.Scanner;

/**
 * Describes the exploration of the SharedMemory by a Robot
 */
public class Exploration {
    private final int size;
    private final SharedMemory sharedMemory;
    private final ExplorationMap explorationMap;
    private final List<Robot> robots = new ArrayList<>();
    private final List<Thread> threads = new ArrayList<>();
    private Scanner scanner;

    /**
     * initialize the exploration
     *
     * @param explorationMap the map
     * @param sharedMemory   the memory
     */
    public Exploration(ExplorationMap explorationMap, SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
        this.explorationMap = explorationMap;
        this.size = sharedMemory.getSize();
    }

    /**
     * adds a Robot object in an array
     *
     * @param robot robot to be added
     */
    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    /**
     * creates a thread for every Robot and starts it
     */
    public void start() {
        for (Robot robot : robots) {
            Thread t = new Thread(robot);
            threads.add(t);
            t.start();
        }
    }

    /**
     * @return the size of the SharedMemory
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the ExplorationMap
     */
    public ExplorationMap getMap() {
        return explorationMap;
    }

    /**
     * stops the Robot identified by the name
     *
     * @param name Robot's name
     */
    public void stopRobot(String name) {
        for (Thread thread : threads)
            if (thread.getName().equals(name))
                if (thread.isAlive()) {
                    thread.interrupt();
                    System.out.println("Robot " + thread.getName() + " stopped");
                    break;
                }
    }

    /**
     * starts the Robot identified by the name
     *
     * @param name Robot's name
     */
    public void startRobot(String name) {
        for (Thread thread : threads)
            if (thread.getName().equals(name))
                if (!thread.isAlive()) {
                    thread.start();
                    System.out.println("Robot " + thread.getName() + " started");
                    break;
                }
    }

    /**
     * starts all the Robots
     */
    public void startAll() {
        for (Thread thread : threads)
            if (!thread.isAlive())
                thread.start();
    }

    /**
     * stops all the Robots
     */
    public void stopAll() {
        for (Thread thread : threads)
            if (thread.isAlive())
                thread.interrupt();
        System.out.println("All Robots stopped");
    }

    /**
     * manages the commands to a Robot
     */
    public void startRobots() {
        this.addRobot(new Robot("Wall-E", this));
        this.addRobot(new Robot("R2D2", this));
        this.addRobot(new Robot("Optimus Prime", this));
        this.start();
        while (true) {
            //reads a command
            String cmd = scanner.nextLine();
            //if command is one of starting
            if (cmd.startsWith("start")) {
                if (cmd.endsWith("all"))
                    startAll();
                else {
                    String[] s = cmd.split(" ");
                    startRobot(s[1]);
                }
            }
            //if command is one of stopping
            else if (cmd.startsWith("stop")) {
                if (cmd.endsWith("all"))
                    stopAll();
                else {
                    String[] s = cmd.split(" ");
                    stopRobot(s[1]);
                }
            }
        }

    }

}
