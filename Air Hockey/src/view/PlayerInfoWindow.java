package view;

import controller.Controller;
import controller.client.Client;
import controller.server.Server;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Player;

public class PlayerInfoWindow {

    private Stage stage;
    private GridPane gridPane;
    private TextField nicknameText;
    private Label nickname;
    private Label label;
    private Label paddle;
    private ImageView currImageView;
    private Button startGame;
    private Button back;
    private Label connectToIp;
    private TextField ip;
    private CheckBox host;
    private CheckBox client;
    private Controller controller;

    private String currColor = "";
    private final String red = "file:images/redPaddle.png";
    private final String green = "file:images/greenPaddle.png";
    private final String blue = "file:images/bluePaddle.png";
    private final String lightBlue = "file:images/lightBluePaddle.png";
    private final String orange = "file:images/orangePaddle.png";
    private final String yellow = "file:images/yellowPaddle.png";
    private final String purple = "file:images/purplePaddle.png";
    private final String black = "file:images/blackPaddle.png";

    public PlayerInfoWindow(Controller controller) {
        this.controller = controller;
        stage = new Stage();
        stage.setTitle("Players settings");
        gridPane = new GridPane();
        input();
    }

    public void input() {

        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(25);
        gridPane.setVgap(15);

        label = new Label("Input Nickname and choose paddle");
        gridPane.add(label, 0, 0, 2, 1);

        nickname = new Label("Nickname");
        gridPane.add(nickname, 0, 1);

        nicknameText = new TextField();
        gridPane.add(nicknameText, 1, 1);

        host = new CheckBox("Host");
        host.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                client.setSelected(!host.isSelected());
                connectToIp.setVisible(false);
                ip.setVisible(false);
            }
        });


        client = new CheckBox("Client");
        client.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                host.setSelected(!client.isSelected());
                connectToIp.setVisible(true);
                ip.setVisible(true);
            }
        });
        gridPane.add(host, 0, 2);
        gridPane.add(client, 1, 2);

        connectToIp = new Label("IP:");
        gridPane.add(connectToIp, 0, 3);

        ip = new TextField();
        gridPane.add(ip, 1, 3, 2, 1);
        connectToIp.setVisible(false);
        ip.setVisible(false);

        paddle = new Label("Your paddle: ");
        gridPane.add(paddle, 0, 4, 2, 1);

        currImageView = new ImageView(new Image("file:images/redPaddle.png"));
        gridPane.add(currImageView, 0, 5, 2, 2);
        currColor = red;

        ImageView imageViewR = new ImageView(new Image(red));
        Button R = new Button("", imageViewR);
        addButton(R, 4, 0);
        R.setOnAction(event -> {
            addPic(red);
            currColor = red;
        });

        ImageView imageViewG = new ImageView(new Image(green));
        Button G = new Button("", imageViewG);
        addButton(G, 6, 0);
        G.setOnAction(event -> {
            addPic(green);
            currColor = green;
        });

        ImageView imageViewB = new ImageView(new Image(blue));
        Button B = new Button("", imageViewB);
        addButton(B, 4, 2);
        B.setOnAction(event -> {
            addPic(blue);
            currColor = blue;
        });

        ImageView imageViewLB = new ImageView(new Image(lightBlue));
        Button LB = new Button("", imageViewLB);
        addButton(LB, 6, 2);
        LB.setOnAction(event -> {
            addPic(lightBlue);
            currColor = lightBlue;
        });

        ImageView imageViewO = new ImageView(new Image(orange));
        Button O = new Button("", imageViewO);
        addButton(O, 4, 4);
        O.setOnAction(event -> {
            addPic(orange);
            currColor = orange;
        });

        ImageView imageViewY = new ImageView(new Image(yellow));
        Button Y = new Button("", imageViewY);
        addButton(Y, 6, 4);
        Y.setOnAction(event -> {
            addPic(yellow);
            currColor = yellow;
        });

        ImageView imageViewP = new ImageView(new Image(purple));
        Button P = new Button("", imageViewP);
        addButton(P, 4, 6);
        P.setOnAction(event -> {
            addPic(purple);
            currColor = purple;
        });

        ImageView imageViewBL = new ImageView(new Image(black));
        Button BL = new Button("", imageViewBL);
        addButton(BL, 6, 6);
        BL.setOnAction(event -> {
            addPic(black);
            currColor = black;
        });

        startGame = new Button("Start game");
        gridPane.add(startGame, 1, 7);
        startGame.setOnAction(event -> {
            if (nicknameText.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning!");
                alert.setHeaderText(null);
                alert.setContentText("Input nickname");
                alert.showAndWait();
            } else {
                Player player = new Player();
                player.setName(nicknameText.getText());
                player.setPath(currColor);
                if (host.isSelected()) {
                    Server server = new Server(controller);
                    server.start();
                    Client client = new Client("localhost:4124", player);
                    client.createConnection();

//                    new Client(ip.getText());
//                    controller.setPlayer(player);
                } else {
                    Client client = new Client(ip.getText(), player);
                    client.createConnection();
//                    controller.setPlayer(player);
                }
            }
        });

        back = new Button("Back");
        gridPane.add(back, 0, 7);
        GridPane.setHalignment(back, HPos.RIGHT);
        back.setOnAction(event -> {
            new MainMenu(controller);
            stage.close();
        });

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    public void addPic(String color) {
        currImageView = new ImageView(new Image(color));
        gridPane.add(currImageView, 0, 5, 2, 2);
    }

    public void addButton(Button b, int col, int row) {
        gridPane.add(b, col, row, 2, 2);
    }
}
