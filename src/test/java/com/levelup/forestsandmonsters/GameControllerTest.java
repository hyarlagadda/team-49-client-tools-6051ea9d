package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import com.levelup.forestsandmonsters.GameController.DIRECTION;

import java.awt.Point;

public class GameControllerTest {

    @Test
    public void initializationCreatesResults() {
        GameController testObj = new GameController();
        assertNotNull(testObj.gameStatus);
    }

    @Test
    public void createCharacter() {
        GameController testObj = new GameController();
        testObj.createCharacter("");
        assertEquals(testObj.gameStatus.characterName, GameController.DEFAULT_CHARACTER_NAME);
    }

    @Test
    public void startGame() {
        GameController testObj = new GameController();
        testObj.startGame();
        assertEquals(testObj.gameStatus.moveCount, 0);
        assertEquals(testObj.character.getPosition().coordinates, 
            new Point(0,0) );
    }

    @Test
    public void move() {
        GameController testObj = new GameController();
        testObj.startGame();
        testObj.move(DIRECTION.EAST);
        testObj.move(DIRECTION.NORTH);
        testObj.move(DIRECTION.NORTH);
        assertEquals(testObj.character.getCurrentPosition().coordinates, 
            new Point(1,2));
        assertEquals(testObj.gameStatus.moveCount, 3);
    }

    @Test
    public void move2() {
        GameController testObj = new GameController();
        testObj.startGame();;
        testObj.move(DIRECTION.EAST); //1, 0
        testObj.move(DIRECTION.NORTH); //1, 1
        testObj.move(DIRECTION.NORTH); //1, 2
        testObj.move(DIRECTION.NORTH); //1, 3
        testObj.move(DIRECTION.SOUTH); //1, 2
        testObj.move(DIRECTION.SOUTH); //1, 1
        testObj.move(DIRECTION.WEST); //0, 1
        testObj.move(DIRECTION.WEST); //0, 1               
        assertEquals(testObj.character.getCurrentPosition().coordinates, 
            new Point(0,1));
    }

    @Test
    public void setCharacterPosition() {
        GameController testObj = new GameController();
        testObj.startGame();
        testObj.setCharacterPosition(null);
        assertEquals(testObj.getGameStatus().currentPosition, new Point(0, 0));
    }

}
