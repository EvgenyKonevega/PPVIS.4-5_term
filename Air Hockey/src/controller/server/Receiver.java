package controller.server;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.Socket;

public class Receiver implements Runnable {

    private BufferedReader player1Reader;
    private BufferedWriter player1Writer;
    private BufferedReader player2Reader;
    private BufferedWriter player2Writer;
    private String message;
    private JSONObject jsonMessage;

    public Receiver(Socket socket, Socket socket1) throws IOException {

        player1Reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        player1Writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        player2Reader = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        player2Writer = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
    }

    @Override
    public void run() {
        firstPlayerMessage();
        secondPlayerMessage();

    }

    public synchronized void firstPlayerMessage(){
        try{
        message = player1Reader.readLine();

        
        }catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public synchronized void secondPlayerMessage(){

    }


}
