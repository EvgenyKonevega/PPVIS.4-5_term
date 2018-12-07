package controller.client;

import controller.Communication;
import controller.GameWindowController;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import model.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import view.GameWindow;

import java.io.*;
import java.net.Socket;

public class Client {
    private final Player player;
//    private static final int PORT = 6263;
//    private static final String HOST = "127.0.0.1";

    private Socket connection;
    private String HOST;
    private int PORT;


    public Client(String ip, Player player) {
        this.player = player;
        String[] parts = ip.split(":");
        HOST = parts[0];
        PORT = Integer.parseInt(parts[1]);
//        createConnection();
    }

    public void createConnection() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            try {
                System.out.println("Connecting to " + HOST + " port:" + PORT);
                connection = new Socket(HOST, PORT);
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
                System.out.println("Connected to " + connection.getLocalSocketAddress());

                JSONObject Info = new JSONObject();
                Info.put("path", player.getPath());
                Info.put("name", player.getName());
                String playerInfo = Info.toString();
                writer.write(playerInfo + "\n");
                writer.flush();

                String enemyInfo = reader.readLine();
                JSONParser parser = new JSONParser();
                JSONObject info = (JSONObject) parser.parse(enemyInfo);

                System.out.println("Current: "+playerInfo);
                System.out.println("Enemy: "+enemyInfo);

                Platform.runLater(() -> {
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Information!");
//                    alert.setHeaderText(null);
//                    alert.setContentText("You connected");
//                    alert.showAndWait();
//                    alert.setOnCloseRequest(event -> {


                    Player enemy = new Player(info);
                    Communication communication = new Communication(reader,writer);
                    GameWindowController windowController = new GameWindowController(communication, player, enemy);
                    new GameWindow(windowController);
//                    });
                });


            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }).start();

    }

}