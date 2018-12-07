package controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Communication {

    private final String action = "action";
    private final String connect = "connect";
    private final String update = "update";
    private final String draw = "draw";
    private final String startGame = "start game";
    private final BufferedReader inputStream;
    private final BufferedWriter outputStream;

    public Communication(BufferedReader inputStream, BufferedWriter outputStream) {

        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void formingMessage(String message){
        JSONObject jmessage = new JSONObject();
        jmessage.put("action", message);
        sendMessage(jmessage.toString());
    }

    public void formingMessage(String message, double x, double y){
        JSONObject jmessage = new JSONObject();
        jmessage.put("action", message);
        jmessage.put("x", x);
        jmessage.put("y", y);
        sendMessage(jmessage.toString());
    }

    public void sendMessage(String message){
        try {
            outputStream.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public void receiveMessage() throws ParseException {
//
//        String enemyInfo = inputStream.readLine();
//        JSONParser parser = new JSONParser();
//        JSONObject info = (JSONObject) parser.parse(enemyInfo);
//
//        if (jsonObject.get(action) == startGame) {
//
//        } else if (jsonObject.get(action) == connect) {
//
//        } else if (jsonObject.get(action) == update) {
//
//        } else if (jsonObject.get(action) == draw) {
//
//        }
//    }

    public void actionToMessage(JSONObject jsonObject) {


        if (jsonObject.get(action) == startGame) {

        } else if (jsonObject.get(action) == update) {

        }

    }

    public void message(String action, double x, double y) {
        JSONObject jsonString = new JSONObject();
        jsonString.put("action", action);
        jsonString.put("x", x);
        jsonString.put("y", y);
    }
}