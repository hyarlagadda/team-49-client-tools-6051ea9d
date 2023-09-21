package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

public class PositionTest {
    
    @Test
    public void testOriginPosition() {
        Position position = new Position(5, 5);
        assertTrue(position.coordinates != null);
    }

    @Test
    public void testXCoordinate() {
        Position position = new Position(8, 5);
        assertEquals(position.coordinates.x, 8);
    }

    @Test
    public void testYCoordinate() {
        Position position = new Position(8, 2);
        assertEquals(position.coordinates.y, 2);
    }
}
