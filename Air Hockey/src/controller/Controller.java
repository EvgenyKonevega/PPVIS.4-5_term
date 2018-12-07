package controller;

import model.Player;
import model.Players;
import view.MainMenu;
import view.GameWindow;
import view.PlayerInfoWindow;

public class Controller {

    private Game game;
    private MainMenu mainMenu;
    private GameWindow gameWindow;
    private PlayerInfoWindow playerInfoWindow;
    private Players playersList = new Players();

    public void setPlayer(Player player) {
        playersList.addPlayer(player);
    }

    public void run(){
        mainMenu = new MainMenu(this);
        //Player player1 = playersList.getDefinitePlayer(1);
        //Player player2 = playersList.getDefinitePlayer(2);
        //gameWindow = new GameWindow(this, player1, player2);
//        gameWindow = new GameWindow();
//        gameWindow.drawWindow();
//        gameWindow.willingness();
    }


    public void startGame(Player p1, Player p2){

        game = new Game(this, p1, p2);
        //send message to start game
        //**
        //
    }


    public void moves(){

    }

    public int goal(int score){
        return score++;
    }

}
