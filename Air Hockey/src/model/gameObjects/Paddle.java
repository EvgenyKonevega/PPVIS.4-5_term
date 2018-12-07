package model.gameObjects;

import javafx.scene.shape.Circle;

public class Paddle {

    private double x;
    private double y;
    private double radius;
    private Circle paddle;

    public Paddle(double x, double y, double rad){
        this.x = x;
        this.y = y;
        radius = rad;
    }

    public double getRadius() {
        return radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

}