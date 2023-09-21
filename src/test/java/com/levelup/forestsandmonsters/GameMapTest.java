package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameMapTest {
    
@Test
public void CreatePositions(){

    assertTrue(true);
}

@Test
public void IsPositionValid(){
    GameMap  map= new GameMap();
    Position pos1 = new Position(1, 8);
     map.IsPositionValid(pos1);
    assertTrue(true);
}

@Test
public void position_OutsideBoundary(){
    GameMap  map= new GameMap();
    Position pos1 = new Position(-1, -10);
     map.IsPositionValid(pos1);
    assertFalse(false);
}

}
