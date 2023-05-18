package org.example;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * describes the server for the game
 */
public class GameServer {
    public static final int PORT = 8100;
    private int countPlayers;
    private Game game;

    /**
     * constructor
     * @throws IOException at creating connection
     */
    public GameServer() throws IOException
    {
        countPlayers = 0;
        ServerSocket serverSocket = null ;
        try{
            serverSocket = new ServerSocket(PORT);
            while(true)
            {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                System.out.println("A client connected");
                if(countPlayers % 2 == 0)
                {
                    game = new Game();
                    countPlayers++;
                    game.setPlayer1();
                    ClientThread client =  new ClientThread(socket);
                    client.start();
                    client.setColor(game.getPlayer1().getColor());
                    client.setGame(game);
                }
                else {
                    countPlayers++;
                    game.setPlayer2();
                    ClientThread client =  new ClientThread(socket);
                    client.start();
                    client.setColor(game.getPlayer2().getColor());
                    client.setGame(game);
                }
            }
        }catch(IOException e) {
            System.out.println("Error at server..." + e);
        }
        finally {
            serverSocket.close();
            countPlayers--;
        }
    }

}
