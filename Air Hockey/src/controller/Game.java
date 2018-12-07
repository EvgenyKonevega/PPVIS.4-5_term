package controller;

import model.Player;
import view.Map;
import view.GameWindow;

public class Game {

    private Map map;
    private Player player1;
    private Player player2;
    private Controller controller;

    public Game(Controller controller, Player p1, Player p2){
        this.controller = controller;
        player1 = p1;
        player2 = p2;

    }

}
