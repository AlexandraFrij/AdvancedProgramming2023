package org.example;

/**
 * describes the game
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private int placedPieces;
    private boolean existsWinner;
    private String winnerColor;

    /**
     * constructor
     * initialise the game
     */
    public Game()
    {

        board = new Board(7);
        existsWinner = false;
        winnerColor = "gray";
        placedPieces = 0;
    }

    /**
     * setters for players
     */
    public void setPlayer1()
    {
        player1 = new Player("white");
    }
    public void setPlayer2()
    {
        player2 = new Player("black");
    }

    /**
     * getters for players
     * @return the player
     */
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String getWinnerColor() {
        return winnerColor;
    }

    public boolean isExistsWinner() {
        return existsWinner;
    }

    /**
     * @param request command from client
     * @param color client's color
     * @return  an answer to the command
     */
    public String serverAnswer(String request, String color)
    {
        String answer = "Unknown command";
        if(request.contains("submit move"))
        {
            String num[] = request.split(" ");
            int x = Integer.parseInt(num[2].split(",")[0]);
            int y = Integer.parseInt(num[2].split(",")[1]);
            if(isWinner(color) && !existsWinner )
            {
                existsWinner = true;
                winnerColor = color;
            }
            else if(placedPieces == board.getDimension()* board.getDimension())
            {
                existsWinner = true;
                winnerColor = "gray";
            }
            answer = submitMove(x,y,color);
        }
        else if(request.contains("see position"))
        {
            String num[] = request.split(" ");
            int x = Integer.parseInt(num[2].split(",")[0]);
            int y = Integer.parseInt(num[2].split(",")[1]);
            answer = seePosition(x,y);
        }
        return answer;
    }

    /**
     * when the command given was submit move
     * @param x  x position of a piece
     * @param y  y position of a piece
     * @param color  client's color
     * @return message according to the command
     */
    public String submitMove(int x, int y, String color)
    {
        String answer;
        if( x < 0 || x > board.getDimension()|| y < 0 || y > board.getDimension() )
            answer = "Position doesn't exist";
        else if(board.existsPiece(x,y))
            answer = "Piece of color "+ board.getPieceColor(x,y)+" already exists on the position";
        else {
            board.placePiece(x,y, color);
            answer = "Piece placed on position "+ x +", "+y;
        }
        return answer;
    }

    /**
     * if command was see position
     * @param x  x coordinate of piece
     * @param y  y coordinate of piece
     * @return  the piece on the given position
     */
    public String seePosition(int x, int y)
    {
        String color = board.getPieceColor(x,y);
        if(color.equals("gray"))
            return "Position not occupied";
        else return "Position occupied with color "+ color;
    }

    /**
     *
     * @param x  x coordinate of a piece
     * @param y  y coordinate of a piece
     * @return  the count of pieces of the same color on the same line as the given piece
     */
    public int piecesOnLine(int x, int y)
    {
        String[][] matrix = board.getBoard();
        int dim = board.getDimension();
        int count = 1;
        for(int i = y; i < dim; i++ )
            if(matrix[x][i].equals(matrix[x][y]))
                count++;
        return count;
    }
    /**
     *
     * @param x  x coordinate of a piece
     * @param y  y coordinate of a piece
     * @return  the count of pieces of the same color on the same column as the given piece
     */
    public int piecesOnColumn(int x, int y)
    {
        String[][] matrix = board.getBoard();
        int dim = board.getDimension();
        int count = 1 ;
        for(int i = x; i < dim; i++ )
            if(matrix[i][y].equals(matrix[x][y]))
                count++;
        return count;
    }

    /**
     *
     * @param color client's color
     * @return true if is winner
     */
    public boolean isWinner(String color)
    {
        int dim = board.getDimension();
        for(int i = 0 ; i < dim ; i++)
            for(int j = 0; j < dim ; j++)
                if(board.getPieceColor(i,j).equals(color))
                    if(piecesOnLine(i,j) >= 5)
                        return true;
        else if(piecesOnColumn(i,j) >= 5)
            return true;
        return false;
    }
}
