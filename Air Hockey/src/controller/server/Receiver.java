package controller.server;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.Socket;

public class Receiver {

    private BufferedReader player1Reader;
    private BufferedWriter player1Writer;
    private BufferedReader player2Reader;
    private BufferedWriter player2Writer;
    private String message;

    public Receiver(Socket socket, Socket socket1) throws IOException {
        player1Reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        player1Writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        player2Reader = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        player2Writer = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
    }

    public void startReceiver() {
        new Thread(new Receiver1Handler()).start();
        new Thread(new Receiver2Handler()).start();
    }

    class Receiver1Handler implements Runnable {
        @Override
        public void run() {
            try {
                message = player1Reader.readLine();
                sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class Receiver2Handler implements Runnable {
        @Override
        public void run() {
            try {
                message = player2Reader.readLine();
                sendMessage(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sendMessage(String message) {
        try {
            player1Writer.write(message + "\n");
            player1Writer.flush();
            player2Writer.write(message + "\n");
            player2Writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
