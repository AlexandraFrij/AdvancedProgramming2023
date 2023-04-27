package compulsory;

import java.util.List;

/**
 * Describes a map (matrix) of Token arrays
 */
public class ExplorationMap {
    private final Cell[][] matrix;
    private SharedMemory sharedMemory;
    int n;

    /**
     * initialize the exploration map
     *
     * @param sharedMemory the memory shared by every robot
     * @param n            the size of the map
     */
    public ExplorationMap(SharedMemory sharedMemory, int n) {
        this.n = n;
        this.sharedMemory = sharedMemory;
        matrix = new Cell[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                // each element of the matrix is an object of type Cell
                matrix[i][j] = new Cell();
                // add the element from SharedMemory class
                matrix[i][j].addToken(sharedMemory.getTokens());
            }
    }

    /**
     * manages which Robot visited a cell
     *
     * @param row   visited cell's row
     * @param col   visited cell's column
     * @param robot the robot visiting
     * @return true if the entire cell was visited, false otherwise
     */
    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (matrix[row][col].isVisited() == false) {
                // cell is not visited, extract Token array and add it
                List<Token> extracted = sharedMemory.extractTokens(n);
                matrix[row][col].getTokens().addAll(extracted);
                matrix[row][col].wasVisited();
                //print the name of the Robot
                System.out.println("Robot " + robot.getName() + " visited cell (" + row + " " + col + ")");
                robot.updatePlacedTokens();
                return true;
            } else {
                System.out.println("Robot " + robot.getName() + " : Cell (" + row + " " + col + ") already visited");
                return false;
            }
        }
    }

    /**
     * @return a representation of the matrix ( where each cell is an array)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                sb.append(matrix[row][col].toString());
                sb.append("   ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
