package com.levelup.forestsandmonsters;

import com.levelup.forestsandmonsters.GameController.DIRECTION;

public class Character {

    static String DEFAULT_NAME = "ELEPHANT";
    private String name;
    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    private GameMap gameMap;
    private Position currentPosition;

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

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

        Position position = currentPosition;

        switch (direction) {
            case NORTH:
                position = new Position(this.getCurrentPosition().coordinates.x,
                        this.getCurrentPosition().coordinates.y + 1);
                break;
            case SOUTH:
                position = new Position(this.getCurrentPosition().coordinates.x,
                        this.getCurrentPosition().coordinates.y - 1);
                break;
            case EAST:
                position = new Position(this.getCurrentPosition().coordinates.x + 1,
                        this.getCurrentPosition().coordinates.y);
                break;
            case WEST:
                position = new Position(this.getCurrentPosition().coordinates.x - 1,
                        this.getCurrentPosition().coordinates.y);
                break;
            default:
                break;

        }

        if (gameMap.isPositionValid(position)) {
            currentPosition = position;
        }

    }

}
