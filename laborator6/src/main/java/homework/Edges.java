package homework;

/**
 * describes the graph
 * contains the adjacency matrix as well as an adjacency matrix of colors
 */
public class Edges {
    private int[][] matrix;
    private String[][] colorMatrix;
    private int dimension;

    /**
     * constructor method, initiate the matrix
     *
     * @param dimension matrix dimension
     */
    public Edges(int dimension) {
        this.dimension = dimension;
        matrix = new int[dimension][dimension];
        colorMatrix = new String[dimension][dimension];
    }

    /**
     * initiate adjacency matrix with 0 and colors matrix with gray
     */
    public void initMatrix() {
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                matrix[i][j] = 0;
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                colorMatrix[i][j] = "gray";
    }

    /**
     * set 1 where an edge exists
     *
     * @param x node 1 of the edge
     * @param y node 2 of the edge
     */
    public void setEdge(int x, int y) {
        matrix[x][y] = 1;
    }

    /**
     * set the color of an edge
     *
     * @param x     node 1 of the edge
     * @param y     node 2 of the edge
     * @param color edge's color
     */
    public void setColor(int x, int y, String color) {
        colorMatrix[x][y] = color;
    }

    /**
     * return 0 if edge exist between x and y, 1 otherwise
     *
     * @param x node 1
     * @param y node 2
     * @return 0 or 1
     */
    public int getEdge(int x, int y) {
        return matrix[x][y];
    }

    /**
     * compute the number of edges colored with the same color and having a common node
     *
     * @param color the edge's color
     * @param node  the common node
     * @return number of edges with the same color
     */
    public int howManyColored(String color, int node) {
        int count = 0;
        for (int i = 0; i < dimension; i++)
            if (colorMatrix[node][i].equals(color))
                count++;
        return count;
    }

    /**
     * return whenever there might be a winner with the given color
     *
     * @param color winner's color
     * @return true or false
     */
    public boolean mightExistWinner(String color) {
        for (int i = 0; i < dimension; i++)
            if (howManyColored(color, i) >= 2)
                return true;
        return false;
    }

    /**
     * return if there exists a triangle in the given color
     *
     * @param color the color
     * @return true or false
     */
    public boolean existsTriangle(String color) {
        int line = -1;
        for (int i = 0; i < dimension; i++) {
            // if there are at least 2 edges with the same color starting in the same node, remember the line
            if (howManyColored(color, i) >= 2)
                line = i;
            if (line != -1) {
                int[] nodes = new int[dimension];
                int count = 0;
                // get the edge's second nodes
                for (int j = 0; j < dimension; j++)
                    if (colorMatrix[line][j].equals(color)) {
                        nodes[count] = j;
                        count++;
                    }
                // if there is an edge in the same color between 2 of the nodes, there is a triangle
                for (int j = 0; j < count - 1; j++)
                    for (int k = j + 1; k < count; k++)
                        if (matrix[nodes[j]][nodes[k]] == 1 && colorMatrix[nodes[j]][nodes[k]].equals(color))
                            return true;
            }
        }
        return false;
    }

    /**
     * finds the winner
     *
     * @return winner's color or another message if there is no winner
     */
    public String getWinner() {
        if (mightExistWinner("red")) {
            if (existsTriangle("red"))
                return "Red is winner!";
        } else if (mightExistWinner("blue")) {
            if (existsTriangle("blue"))
                return "Blue is winner!";
        }
        return "No winner yet";
    }
}
