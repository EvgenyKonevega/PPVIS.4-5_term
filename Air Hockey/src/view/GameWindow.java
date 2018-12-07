package view;

import controller.GameWindowController;
import controller.KTimer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Optional;

public class GameWindow {

    private KTimer ktimer;
    private Map map;

    private Stage primaryStage;
    private BorderPane borderPane;
    private GridPane gridPane;

    private Label time;
    private Label timer;
    private Label name1;
    private Label name2;
    private Label score;
    private Label val;
    private int p1Score;
    private int p2Score;

    private GameWindowController windowController;
    private Group group;

    public GameWindow(GameWindowController windowController) {

        this.windowController = windowController;
        buildWindow();
    }

    private void buildWindow() {

        group = new Group();
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(15, 15, 15, 15));

        primaryStage = new Stage();
        p1Score = 0;
        p2Score = 0;
        name1 = new Label();
        name1.setText(windowController.getPlayer1().getName());

        name2 = new Label();
        name2.setText(windowController.getPlayer2().getName());

        time = new Label();
        time.setText("Time");

        score = new Label();
        score.setText("Score");

        val = new Label();
        val.setText(String.valueOf(p1Score) + "   :  " + String.valueOf(p2Score));

        willingness();

    }

    public void drawWindow() {

        map = new Map(group, windowController);
        map.drawMap();
        map.gameProcess();

        gridPane = new GridPane();

        gridPane.add(time, 0, 0);
        GridPane.setHalignment(time, HPos.CENTER);

//        gridPane.add(timer, 1, 0);
//        GridPane.setHalignment(timer, HPos.CENTER);

        gridPane.add(name1, 0, 1);
        GridPane.setHalignment(name1, HPos.CENTER);

        gridPane.add(name2, 1, 1);
        GridPane.setHalignment(name2, HPos.CENTER);

        gridPane.add(score, 0, 2, 2, 1);
        GridPane.setHalignment(score, HPos.CENTER);

        gridPane.add(val, 0, 3, 2, 1);


//        ktimer = new KTimer();
//        timer = new Label(ktimer.getSspTime().get());
//        ktimer.getSspTime().addListener(new InvalidationListener() {
//            @Override
//            public void invalidated(Observable observable) {
//                timer.setText(ktimer.getSspTime().get());
//            }
//        });


//        root.getChildren().addAll(time);
//        root.(time, 0,0);
//        root.addChildren().add(time, 0, 0);


//        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
//        borderPane.setBackground(new Background(new BackgroundImage(field,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundPosition.CENTER,
//                bSize)));

        borderPane = new BorderPane();
        borderPane.setRight(gridPane);
        borderPane.setLeft(group);
        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Air hockey");
        primaryStage.show();
    }

    public void start() {
        ktimer.startTimer(ktimer.getTime());
    }

    public void willingness() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you ready?");

        ButtonType buttonTypeOne = new ButtonType("Confirm");
        ButtonType buttonTypeTwo = new ButtonType("Reject");

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            drawWindow();
        } else if (result.get() == buttonTypeTwo) {
            primaryStage.close();
        }
    }
}