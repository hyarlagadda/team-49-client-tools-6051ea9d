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
        assertEquals(testObj.gameStatus.moveCount, 0);
    }

    @Test
    public void move2() {
        GameController testObj = new GameController();
        testObj.startGame();;
        testObj.move(DIRECTION.EAST);
        testObj.move(DIRECTION.NORTH);
        testObj.move(DIRECTION.NORTH);
        testObj.move(DIRECTION.NORTH);
        testObj.move(DIRECTION.SOUTH);
        testObj.move(DIRECTION.WEST);
        testObj.move(DIRECTION.WEST);                
        assertEquals(testObj.character.getCurrentPosition().coordinates, 
            new Point(0,2));
    }

    @Test
    public void setCharacterPosition() {
        
    }

}
