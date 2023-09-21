package com.levelup.forestsandmonsters;

import java.awt.Point;

import com.levelup.forestsandmonsters.GameController.DIRECTION;
public class Character {
    
    static String DEFAULT_NAME = "ELEPHANT";
    private String name;

    public Character() {
        this.name = DEFAULT_NAME;
    }

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void enterMap(GameMap map) {
        GameMap gameMap = map;
        
    }

    public Position getPosition() {

        return null;
    }

    public void move(DIRECTION direction) {
        
    }
}
