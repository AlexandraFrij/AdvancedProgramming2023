import static java.lang.Math.floor;
import static java.lang.Math.ceil;

public class Main {

    /**
     * the method creates a matrix in which each line is a permutation of numbers from 1 to n (the dimesnion of the matrix)
     * @param matrix matrix of integers
     * @param dimension dimesndion of matrix
     * @return the created matrix
     */
    public static int[][] CreateMatrix( int[][] matrix, int dimension )
    {
        for(int i = 0; i < dimension; i++)
        {
            matrix[0][i] = i+1;
        }
        for(int i = 1; i < dimension; i++)
        {
            for( int j = 0; j < dimension; j++ )
            {
                if(j == 0)
                    matrix[i][j] = matrix[i-1][dimension-1];
                else
                    matrix[i][j] = matrix[i-1][j-1];
            }
        }

        return matrix;
    }


    /**
     * the method creates a string array in which the String objects are representing the concatenation of the symbols in the respective line
     * @param matrix matrix of integers
     * @param dimension dimension of matrix
     * @return the string array
     */
    public static String[] CreateStringFromMatrixLines(int[][] matrix, int dimension)
    {
        String[] stringLines = new String[dimension];
        for(int i = 0; i < dimension; i++)
            for(int j = 0; j < dimension; j++)
                if(j == 0)
                    stringLines[i] = Integer.toString(matrix[i][j]);
        else
            stringLines[i] = stringLines[i] + Integer.toString(matrix[i][j]);
        return stringLines;
    }

    /**
     * the method creates a string array in which the String objects are representing the concatenation of the symbols in the respective column.
     * @param matrix matrix of integers
     * @param dimension dimension of matrix
     * @return the string array
     */
    public static String[] CreateStringFromMatrixColumns(int[][] matrix, int dimension)
    {
        String[] stringColumns = new String[dimension];
        for(int i = 0; i < dimension; i++)
            for(int j = 0; j < dimension; j++)
                if(j == 0)
                    stringColumns[i] = Integer.toString(matrix[j][i]);
                else
                    stringColumns[i] = stringColumns[i] + Integer.toString(matrix[j][i]);
        return stringColumns;
    }


    /**
     * the method creates an adjacency matrix of a k-regulat graph
     * using the fact that an adjacency matrix of a k-regulat graph is symmetrical to the main diagonal, the matrix is completed traversing only the superior half of the matrix
     * from the first course: if k is even: put the vertices around a circle, and join each to its k/2-nearest neighbors on either side
     * if k is is odd and n is even: do as above and also to the vertex directly opposite
     * @param verticesNumber n, the number of vertices
     * @param vertexDegree k, the degree of every vertex
     * @return the adjacency matrix
     */
    public static int[][] CreateMatrixOfRegularGraph(int verticesNumber, int vertexDegree)
    {
        int[][] adjancenceyMatrix = new int[verticesNumber][verticesNumber];
        for( int i = 0; i < verticesNumber; i++)
           for(int j = 0; j < verticesNumber; j++)
               adjancenceyMatrix[i][j] = 0;
        for(int i = 0; i < verticesNumber; i++)
        {
            int rightNeighbors = 0;
            for (int j = i + 1; j < verticesNumber && rightNeighbors < vertexDegree/2; j++)
            {
                adjancenceyMatrix[i][j] = 1;
                adjancenceyMatrix[j][i] = 1;
                rightNeighbors++;
            }
            int leftNeighbors = 0;
            for(int j = 0; j < i; j++)
            {
                if(adjancenceyMatrix[i][j] == 1)
                    leftNeighbors++;
            }
            for (int j = verticesNumber - 1; j > i && leftNeighbors < vertexDegree/2; j--)
            {
                adjancenceyMatrix[i][j] = 1;
                adjancenceyMatrix[j][i] = 1;
                leftNeighbors++;
            }
            if(vertexDegree % 2 == 1 && i < verticesNumber/2)
            {
                adjancenceyMatrix[i][i + verticesNumber / 2] = 1;
                adjancenceyMatrix[i + verticesNumber / 2][i] = 1;
            }
        }
           return adjancenceyMatrix;
    }
    public static void main(String[] args)
    {
       /*if(args.length > 1)    // verify the number of given arguments, there should be only 1 given argument
            throw new IllegalArgumentException("Too many argumets");
        else if(args.length == 0)
            throw new IllegalArgumentException("There are no argumets");
        else    // verify if argument is string
            try
            {
                int n = Integer.parseInt(args[0]);
                System.out.println("The argument " + n + " is an integer");
            }
            catch(NumberFormatException e)   //the given argument is not string, an error message will be printed
            {
                System.out.println("The given argument is not a integer");
            } */

       /* int[][]  matrix = new int[3][3];
        CreateMatrix(matrix, 3);
        System.out.println("The Latin Square as a matrix:");
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }*/
       /* int dimension = 30_500;
        if(dimension > 30_000)
        {
            long initialTime = System.currentTimeMillis();
            int[][] matrix1 = new int[dimension][dimension];
            CreateMatrix(matrix1, dimension);
            long runningTime = System.currentTimeMillis() - initialTime;
            System.out.println("The running time in miliseconds is: " + runningTime);

        }*/

        /*String[] stringLines = CreateStringFromMatrixLines(matrix, 3);
        System.out.println("Each line of the matrix as a string:");
        for(int i = 0; i < 3; i++)
        {
            System.out.println(stringLines[i]);
        }

        String[] stringColumns = CreateStringFromMatrixColumns(matrix, 3);
        System.out.println("Each column of the matrix as a string:");
        for(int i = 0; i < 3; i++)
        {
            System.out.println(stringColumns[i]);
        }*/
        int verticesNumber = 8;
        int vertexDegree = 3;
        int[][] adjacencyMatrix = new int[verticesNumber][verticesNumber];
        adjacencyMatrix = CreateMatrixOfRegularGraph(verticesNumber, vertexDegree);
        for(int i = 0; i < verticesNumber; i++)
        {
            for(int j = 0; j < verticesNumber; j++)
                System.out.print(adjacencyMatrix[i][j]);
            System.out.println();
        }

    }
}