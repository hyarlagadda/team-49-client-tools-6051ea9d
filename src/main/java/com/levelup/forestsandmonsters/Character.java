package com.levelup.forestsandmonsters;

import java.awt.Point;

import com.levelup.forestsandmonsters.GameController.DIRECTION;
public class Character {
    
    static String DEFAULT_NAME = "ELEPHANT";
    private String name;
    private GameMap gameMap;
    private Position currentPosition;

    public Position getCurrentPosition() {
        return currentPosition;
    }

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
        this.gameMap = map;
        this.currentPosition = new Position(0, 0);
    }

    public Position getPosition() {

        return currentPosition;
    }

    public void move(DIRECTION direction) {
        
        switch (direction) {
            case NORTH:
                Position position = new Position(this.getCurrentPosition().coordinates.x, 
                    this.getCurrentPosition().coordinates.y + 1);
                currentPosition = position;
                break;
            case SOUTH:
                Position position1 = new Position(this.getCurrentPosition().coordinates.x, 
                this.getCurrentPosition().coordinates.y - 1);
                currentPosition = position1;
                break;
            case EAST:
                Position position2 = new Position(this.getCurrentPosition().coordinates.x + 1, 
                this.getCurrentPosition().coordinates.y);
                currentPosition = position2;
                break;
            case WEST:
                Position position3 = new Position(this.getCurrentPosition().coordinates.x - 1, 
                this.getCurrentPosition().coordinates.y);
                currentPosition = position3;
                break;
        }

    }

    
}
