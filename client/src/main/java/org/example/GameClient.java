package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private String serverAddress;
    private int PORT;
    public GameClient(String serverAddress, int port)
    {
        this.serverAddress = serverAddress;
        this.PORT = port;
    }
    public void connect() throws IOException{
        Socket socket = new Socket(serverAddress, PORT);
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true );
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        String request = "";
        String response = "";
        while(!request.equals("exit"))
        {
            System.out.println("Possible commands: submit move, see position, stop, exit");
            System.out.println("Write a command: ");
            request = consoleInput.readLine();
            output.println(request);
            output.flush();
            response = serverInput.readLine();
            System.out.println("Server response: "+ response );

        }
        System.out.println("You exited");

    }

}
