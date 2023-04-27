package compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Describes a Robot that visited the SharedMap
 */
public class Robot implements Runnable {
    private final String name;
    private boolean running;
    Exploration explore;
    private int placedTokens;

    /**
     * initialize the Robot
     *
     * @param name    Robot's name
     * @param explore Exploration object
     */
    public Robot(String name, Exploration explore) {
        this.name = name;
        this.running = true;
        this.explore = explore;
        placedTokens = 0;
    }

    public void updatePlacedTokens() {
        placedTokens++;
    }

    public String getName() {
        return name;
    }

    /**
     * the visit process
     */
    public void run() {
        // retain the index for every cell
        List<Integer> rowIndex = new ArrayList<>();
        List<Integer> colIndex = new ArrayList<>();
        int n = explore.getSize();
        for (int i = 0; i < n; i++) {
            rowIndex.add(i);
            colIndex.add(i);
        }
        //shuffle so the visit process is different for every robot
        Collections.shuffle(rowIndex);
        Collections.shuffle(colIndex);
        int row = 0;
        int col = 0;
        while (running) {
            // if he visited every cell
            if (row == n) {
                running = false;
                System.out.println("Robot " + this.name + " placed " + placedTokens + " tokens.");
            }
            // when the robot visited all the cells on a row
            else if (col == n) {
                col = 0;
                row++;
            } else {
                explore.getMap().visit(rowIndex.get(row), colIndex.get(col), this);
                col++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
