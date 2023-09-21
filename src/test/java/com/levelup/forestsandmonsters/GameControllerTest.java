package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class GameControllerTest {

    @Test
    public void initializationCreatesResults() {
        GameController testObj = new GameController();
        assertNotNull(testObj.status);
    }

    @Test
    public void createCharacter() {
        GameController testObj = new GameController();
        testObj.createCharacter("");
        assertEquals(testObj.status.characterName, GameController.DEFAULT_CHARACTER_NAME);
    }

    @Test
    public void 

}
