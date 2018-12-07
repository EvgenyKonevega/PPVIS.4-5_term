package model;

import model.gameObjects.Paddle;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Player {

    private String name;
    private String path;
    private int score = 0;

    public Player(JSONObject enemyInfo){
            name = (String) enemyInfo.get("name");
            path = (String) enemyInfo.get("path");
    }

    public Player() {

    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
