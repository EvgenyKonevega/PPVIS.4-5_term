package controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Communication {

    private final String object = "object";
    private final String puck = "puck";
    private final String paddle = "paddle";
    private double x;
    private double y;
    private final BufferedReader inputStream;
    private final BufferedWriter outputStream;
    private GameWindowController windowController;

    public Communication(GameWindowController windowController, BufferedReader inputStream, BufferedWriter outputStream) {
        this.windowController = windowController;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void formingMessage(String message, double x, double y){
        JSONObject jmessage = new JSONObject();
        jmessage.put(object, message);
        jmessage.put("x", x);
        jmessage.put("y", y);
        sendMessage(jmessage.toString());
    }

    public void sendMessage(String message){
        try {
            outputStream.write(message);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String message = inputStream.readLine();
                    JSONParser parser = new JSONParser();
                    JSONObject info = (JSONObject) parser.parse(message);
                    actionToMessage(info);
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    public void actionToMessage(JSONObject jsonObject) {
        x = (double) jsonObject.get("x");
        y = (double) jsonObject.get("y");

        if (jsonObject.get(object) == paddle) {
            windowController.drawPaddleByCoordinates(x, y);
        } else if (jsonObject.get(object) == puck) {
            windowController.redrawPuck(x, y);
        }
    }
}