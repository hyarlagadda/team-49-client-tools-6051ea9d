package com.levelup.forestsandmonsters;

public class GameMap {
    
    public Position[][] positions;
    public Position startingPosition;
    private static final int maxBoundary = 10;

    int numPositions =100;

    public GameMap() {
        createPositions();
    }

    private void createPositions() {
        positions = new Position[10][10];
        for (int x = 0; x < maxBoundary; x++) {
            for (int y = 0; y < maxBoundary; y++) {
                Position pos = new Position(x, y);
                positions[x][y] = pos;
            }
        }
        startingPosition = positions[0][0];
    }


    public boolean isPositionValid(Position pos) {
        if (pos.coordinates.x >= 0 && pos.coordinates.x < maxBoundary && pos.coordinates.y >= 0 && pos.coordinates.y < maxBoundary) {
            return true;
        } else {
            return false;
        }
    }

    

}
