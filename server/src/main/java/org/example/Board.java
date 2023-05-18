package org.example;

/**
 * the board for the game
 */
public class Board {
    private String[][] board;
    private int dimension;

    /**
     * constructor
     * @param dimension board dimension
     */
    public Board(int dimension)
    {
        this.dimension = dimension;
        board = new String[dimension][dimension];
        for(int i = 0; i < dimension; i++)
            for(int j = 0; j < dimension; j++)
                board[i][j] = "gray"; //initially, all board is gray, when a piece is placed on a position (x,y), then board[x][y] = player's color;
    }
    public void placePiece(int x, int y, String color)
    {
        board[x][y] = color;
    }
    public boolean existsPiece(int x, int y)
    {
        if(!board[x][y].equals("gray"))
            return true;
        else return false;
    }

    public String[][] getBoard() {
        return board;
    }

    public int getDimension() {
        return dimension;
    }
    public String getPieceColor(int x, int y)
    {
        return board[x][y];
    }
}
