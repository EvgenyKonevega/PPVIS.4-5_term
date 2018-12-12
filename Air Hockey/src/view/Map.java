package view;

import controller.Game;
import controller.GameWindowController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.Player;
import model.gameObjects.Paddle;
import model.gameObjects.Puck;

public class Map {

    private Group group;
    private Paddle pad;
    private Puck ball;
    private final double startGateLine = 132;
    private final double endGateLine = 352;
    private Circle puck;
    private Circle paddle1;
    private Circle paddle2;

    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;

    private final int mapHeight = 722;
    private final int mapWidth = 480;
    private GameWindowController windowController;
    private Player p1;
    private Player p2;

    public Map(Group group, GameWindowController windowController){

        this.windowController = windowController;
        this.group = group;
        p1 = windowController.getPlayer1();
        p2 = windowController.getPlayer2();
        pad = new Paddle(240, 650, 45);
        ball = new Puck(240,361,30);
    }

    public void drawMap(){

        paddle1 = new Circle(pad.getX(), pad.getY(), pad.getRadius());
        Image im = new Image(p1.getPath(),false);
        paddle1.setFill(new ImagePattern(im));
        paddle1.setCursor(Cursor.HAND);
        paddle1.setOnMousePressed(circleOnMousePressedEventHandler);
//        paddle1.setOnMouseDragged(circleOnMouseDraggedEventHandler);

        paddle2 = new Circle(mapWidth-pad.getX(), mapHeight-pad.getY(), pad.getRadius());
        Image img = new Image(p2.getPath(),false);
        paddle2.setFill(new ImagePattern(img));

        puck = new Circle(ball.getX(), ball.getY(), ball.getRadius());
        Image ball = new Image("file:images/ball.png",false);
        puck.setFill(new ImagePattern(ball));

        Image field = new Image("file:images/field.png");
        ImageView imageView = new ImageView(field);

        Canvas canvas = new Canvas(mapWidth, mapHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawGates(gc);

        group.getChildren().addAll(imageView, paddle1, paddle2, puck, canvas);

    }

    public void drawEnemy(double x, double y){
        paddle2.relocate(mapWidth - x,mapHeight - y);
    }

    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    System.out.println("Mouse pressed");
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    System.out.println("mouse dragged");
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Circle)(t.getSource())).setTranslateX(newTranslateX);
                    ((Circle)(t.getSource())).setTranslateY(newTranslateY);
                    //windowController.sendNewСoordinates(newTranslateX,newTranslateY);
                }

            };





//    public void gameProcess(){
//
//        paddle1.setOnMouseDragged(event ->{
//            paddle1.relocate(event.getSceneX() - paddle1.getRadius(), event.getSceneY() - paddle1.getRadius());
//            windowController.sendNewСoordinates(event.getSceneX() - paddle1.getRadius(), event.getSceneY() - paddle1.getRadius());
//        });





//        paddle1.setOnMousePressed(event ->{
//            x = paddle1.getTranslateX()-event.getSceneX();
//            y = paddle1.getTranslateY()-event.getSceneY();
//        });
//
//        paddle1.setOnMouseDragged(event -> {
//            paddle1.setTranslateX(x+event.getSceneX());
//            paddle1.setTranslateX(y+event.getSceneX());
//            //send new coordinates to server
//            //redraw on 2 client
//        });
//
//        paddle2.setOnMousePressed(event ->{
//            x = paddle1.getTranslateX()-event.getSceneX();
//            y = paddle1.getTranslateY()-event.getSceneY();
//        });
//
//        paddle2.setOnMouseDragged(event -> {
//            paddle1.setTranslateX(x+event.getSceneX());
//            paddle1.setTranslateX(y+event.getSceneX());
//            //send new coordinates to server
//            //redraw on 2 client
//        });




    public boolean borderCheck(Puck puck, double x, double y){
        if(puck.getX() - puck.getRadius() < 0 && puck.getY() - puck.getRadius() < 0
                && puck.getX() + puck.getRadius() > mapWidth && puck.getY() + puck.getRadius() > mapHeight){
            return true;
        }else{
            return false;
        }
    }

    public boolean borderCheck(double x, double y){
        if(x - pad.getRadius() < 0 && y - pad.getRadius() < 0 && x + pad.getRadius() > mapWidth && y + pad.getRadius() > mapHeight){
            return true;
        }else{
            return false;
        }
    }

    public boolean goalP1Check(Puck puck, double x, double y){
        if(puck.getX() >= startGateLine && puck.getX() <= endGateLine && puck.getY()+puck.getRadius() == 5){
            return true;
        }else{
            return false;
        }
    }

    public boolean goalP2Check(Puck puck, double x, double y){
        if(puck.getX() >= startGateLine && puck.getX() <= endGateLine && puck.getY()+puck.getRadius() == mapHeight-5){
            return true;
        }else{
            return false;
        }
    }

    public boolean halfCheck(double y){
        if(y - pad.getRadius() <= mapHeight/2){
            return true;
        }else{
            return false;
        }
    }

//
//    public boolean halfCheckP1(double x, double y){
//         if(paddle1.getY()+paddle1.getRadius() >= mapHeight/2){
//             return true;
//         }else{
//        return false;
//         }
//    }
//
//    public boolean halfCheckP2(double x, double y){
//        if(paddle2.getY()+paddle2.getRadius() <= mapHeight/2){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    public boolean toughtCheck(GameObject gameObject, double X, double Y){
//        double x;
//        double xB;
//        double y;
//        double yB;
//        for(int i = 0; i <= 360; i++){
//            x = cos(i)*gameObject.getRadius();
//            y = sin(i)*gameObject.getRadius();
//            for(int j =0; j <= 360; j++){
//                xB = cos(i)*puck.getRadius();
//                yB = sin(j)*puck.getRadius();
//                if(puck.getX()+xB == gameObject.getX()+x || puck.getY()+yB == gameObject.getY()+y){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//
//    public void move(GameObject gameObject, double x, double y){
//        if(gameObject == puck){
//            if(bordedCheck(gameObject,x,y)){
//                gameObject.setX(gameObject.getX()+x);
//                gameObject.setY(gameObject.getY()+y);
//            }
//
//        }else if(gameObject == paddle1){
//            if(halfCheckP1(x,y)){
//                gameObject.setX(gameObject.getX()+x);
//                gameObject.setY(gameObject.getY()+y);
//            }
//        }else{
//            if(halfCheckP2(x,y)){
//                gameObject.setX(gameObject.getX()+x);
//                gameObject.setY(gameObject.getY()+y);
//            }
//        }
//        updateMap();
//        //draw(gameObject);
//    }

//    public void draw(GameObject gameObject){
//        System.out.println("(" + gameObject.getX() + "; " + gameObject.getY() + ")");
//    }
//
//    public void updateMap(){
//        draw(puck);
//        draw(paddle1);
//        draw(paddle2);
//    }

    private void drawGates(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.strokeLine(startGateLine, 13, endGateLine, 13);

        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.strokeLine(startGateLine, 709, endGateLine, 709);
    }

    public void drawPuck(double x, double y) {
        puck.relocate(x,y);
    }
}
