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
    public void testMoveEast() {
        GameMap map = new GameMap();
        character.enterMap(map);
        character.move(DIRECTION.EAST);
        assertEquals(character.getCurrentPosition().coordinates.x, 1);
    }

    @Test
    public void testMoveEN() {
        GameMap map = new GameMap();
        character.enterMap(map);
        character.move(DIRECTION.EAST);
        character.move(DIRECTION.NORTH);
        assertEquals(character.getCurrentPosition().coordinates.x, 1);
        assertEquals(character.getCurrentPosition().coordinates.y, 1);
    }

    @Test
    public void testMoveENWEES() {
        GameMap map = new GameMap();
        character.enterMap(map);
        character.move(DIRECTION.EAST); //(1,0)
        character.move(DIRECTION.NORTH); //(1,1)
        character.move(DIRECTION.WEST); //(0, 1)
        character.move(DIRECTION.EAST); //(1, 1)
        character.move(DIRECTION.EAST); //(2, 1)
        character.move(DIRECTION.SOUTH); //(2, 0)
        assertEquals(character.getCurrentPosition().coordinates.x, 2);
        assertEquals(character.getCurrentPosition().coordinates.y, 0);
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
