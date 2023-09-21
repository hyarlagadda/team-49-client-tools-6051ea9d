package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.levelup.forestsandmonsters.GameController.DIRECTION;

public class CharacterTest {

    Character character = new Character();

    @Test
    public void testDefaultName() {
        assertEquals(character.getName(), Character.DEFAULT_NAME);
    }
    
    @Test
    public void testGetName() {
        Character character1 = new Character("CLIENT-TOOLS"); 
        assertEquals(character1.getName(), "CLIENT-TOOLS");
    }

    @Test
    public void testMove() {
        character.move(DIRECTION.EAST);
        assertTrue(true);
    }

    @Test
    public void testEnterMap() {
        GameMap map = new GameMap();
        character.enterMap(map);
        assertTrue(character.getCurrentPosition() != null);
    }

    @Test
    public void testEnterMapPosition() {
        GameMap map = new GameMap();
        character.enterMap(map);
        Position position = character.getCurrentPosition();
        assertEquals(position.coordinates.x, 0);
        assertEquals(position.coordinates.y, 0);
    }

}
