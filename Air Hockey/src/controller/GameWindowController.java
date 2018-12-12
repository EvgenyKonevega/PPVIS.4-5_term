package controller;

import model.Player;
import view.GameWindow;
import view.Map;

public class GameWindowController {
    private final Player p1;
    private final Player p2;
    private GameWindow gamewindow;
    private Communication communication;

    public GameWindowController(Player p1, Player p2) {

        this.p1 = p1;
        this.p2 = p2;
    }

    public Player getPlayer1() {
        return p1;
    }

    public Player getPlayer2() {
        return p2;
    }

    public void sendNewСoordinates(double x, double y) {
        communication.formingMessage("paddle", x, y);
    }

    public void drawPaddleByCoordinates(double x, double y){
        gamewindow.drawEnemyOnMap(x,y);
    }

    public void setCommunication(Communication communication){
        this.communication = communication;
    }

    public void redrawPuck(double x, double y) {
        gamewindow.redrawPuckOnMap(x,y);
    }
}
