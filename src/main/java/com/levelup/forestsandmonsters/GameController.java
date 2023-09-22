package com.levelup.forestsandmonsters;

import java.awt.Point;

public class GameController {

    static final String DEFAULT_CHARACTER_NAME = "Character";

    public class GameStatus {
        // TODO: Add other status data
        public String characterName = DEFAULT_CHARACTER_NAME;
        public Point currentPosition = null;
        // TODO: Write a failing unit test that will force you to set this to the right number
        public int moveCount = -100;
    }

    GameStatus gameStatus;
    Character character;

    public GameController() {
        gameStatus = new GameStatus();
        character = new Character(DEFAULT_CHARACTER_NAME);
    }

    // TODO: Ensure this AND CLI commands match domain model
    public static enum DIRECTION {
        NORTH, SOUTH, EAST, WEST
    }

    // Pre-implemented to demonstrate ATDD
    // TODO: Update this if it does not match your design
    public void createCharacter(String name) {
        if (name != null && !name.equals("")) {
            gameStatus.characterName = name;
        } else {
            gameStatus.characterName = DEFAULT_CHARACTER_NAME;
        }
    }

    public void startGame() {
        // TODO: Implement startGame - Should probably create tiles and put the character
        // on them?
        GameMap map = new GameMap();
        this.character.enterMap(map);
        gameStatus.currentPosition = character.getCurrentPosition().coordinates;
        gameStatus.moveCount = 0; 
        // TODO: Should also update the game results?
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public void move(DIRECTION directionToMove) {
        // TODO: Implement move - should call something on another class
        character.move(directionToMove);
        gameStatus.moveCount = gameStatus.moveCount + 1;
        gameStatus.currentPosition = character.getCurrentPosition().coordinates;
        // TODO: Should probably also update the game results
    }

    public void setCharacterPosition(Point coordinates) {
        // TODO: IMPLEMENT THIS TO SET CHARACTERS CURRENT POSITION -- exists to be testable
        this.character.setCurrentPosition(new Position(coordinates.x, coordinates.y));
    }

    public void setCurrentMoveCount(int moveCount) {
        // TODO: IMPLEMENT THIS TO SET CURRENT MOVE COUNT -- exists to be testable
    }

    public int getTotalPositions() {
        // TODO: IMPLEMENT THIS TO GET THE TOTAL POSITIONS FROM THE MAP -- exists to be
        // testable
        return -10;
    }

}
