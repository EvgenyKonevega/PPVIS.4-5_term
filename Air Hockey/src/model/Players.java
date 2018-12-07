package model;

import java.util.*;

public class Players {

    private List<Player> playerList;

    public void addPlayer(Player player) {
        playerList.add(player);
    }
/*
Check getDefinitePlayer method
*/
    public Player getDefinitePlayer(int index){
        Player player = new Player();
        player = playerList.get(index);
        return player;
    }

}
