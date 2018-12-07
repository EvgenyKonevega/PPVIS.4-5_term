package controller;

import model.Player;
import view.Map;

public class GameWindowController {
    private Communication communication;
    private final Player p1;
    private final Player p2;

    public GameWindowController(Communication communication, Player p1, Player p2) {

        this.communication = communication;
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
    }
}
