package model.gameObjects;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Puck{

    private double x;
    private double y;
    private double radius;
    private double speed;
    private Circle circle;


    public Puck(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void speedUp(){
        speed+=1;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getSpeed(){
        return speed;
    }

}
