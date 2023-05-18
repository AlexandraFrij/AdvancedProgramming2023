package org.example;

import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * thread for every client
 */
public class ClientThread extends Thread {
    private Socket socket = null;
    private String color;
    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public ClientThread(Socket socket) {
        this.socket = socket;

    }

    /**
     * executed by every thread
     */
    public void run() {
        try {
            //read from client
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String answer;
            String request = "";
            // while there is still a connection
            while (!socket.isClosed() && !request.equals("stop")) {
                request = in.readLine();
                if (request.equals("stop")) {
                    out.println("Server stopped");

                }
                answer = game.serverAnswer(request, color);
                if (game.isExistsWinner()) {
                    if (game.getWinnerColor().equals(color)) {
                        out.println("You win");
                    } else {
                        out.println("You lost");
                    }
                    out.flush();
                    socket.close();
                } else {
                    out.println(answer);
                    out.flush();
                }

            }
        } catch (IOException e) {
            System.out.println("Exception at server " + e);
        }
    }

    public void setColor(String color) {
        this.color = color;
    }
}
