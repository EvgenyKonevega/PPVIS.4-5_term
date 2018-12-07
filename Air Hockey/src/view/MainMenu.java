package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MainMenu {

    private Stage primaryStage;
    private VBox vBox;

    private Button start;
    private Button exit;
    private Button settings;
    private Image background;
    private Controller controller;

    public MainMenu(Controller controller) {
        this.controller = controller;
        primaryStage = new Stage();
        //primaryStage.setMaximized(true);
        //primaryStage.setResizable(false);
        //Add image of title to the top of screen
        //background = new Image("file:");

        vBox = new VBox();

        start = new Button("Start");
        exit = new Button("Exit");
        settings = new Button("Settings");

        drawWinow();

    }

    public void drawWinow() {

        Label nameGame = new Label("Air Hockey");
        nameGame.setFont(Font.font(40));
        start.setMinSize(100, 50);
        settings.setMinSize(100, 50);
        exit.setMinSize(100, 50);

        vBox.getChildren().addAll(nameGame, start, settings, exit);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20, 40, 20, 40));
        Scene scene = new Scene(vBox);

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                new PlayerInfoWindow(controller);
                primaryStage.close();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
        //Scene scene = new Scene(vBox);
        //ImageView iv = new ImageView();
        //iv.setImage(background);

    }
}
