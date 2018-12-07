package controller.server;

import controller.Controller;
import model.Player;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 4124;
    private ServerSocket serverSocket;

    private Player p1;
    private Player p2;
    private Controller controller;

    public Server(Controller controller) {
        this.controller = controller;
    }


    public void start() {
        new Thread(new ConnectionHandler()).start();
    }

    class ConnectionHandler implements Runnable {

        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(PORT);
                System.out.println("Waiting for controller.client");
                Socket socket = serverSocket.accept();
                BufferedReader player1Reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter player1Writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String player1Info = player1Reader.readLine();
                System.out.println("Player1: " + player1Info);
                Socket socket1 = serverSocket.accept();

                BufferedReader player2Reader = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                BufferedWriter player2Writer = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
                String player2Info = player2Reader.readLine();
                System.out.println("Player2:" + player2Info);
                player1Writer.write(player2Info + "\n");
                player1Writer.flush();
                player2Writer.write(player1Info + "\n");
                player2Writer.flush();

                Receiver receiver = new Receiver(socket, socket1);

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}