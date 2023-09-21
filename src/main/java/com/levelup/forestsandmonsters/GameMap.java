package com.levelup.forestsandmonsters;

public class GameMap {
    
    public Position[][] positions;
    public Position startingPosition;

    int numPositions =100;

    public GameMap() {
        CreatePositions();
    }

    private void CreatePositions() {
        positions = new Position[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Position pos = new Position(x, y);
                positions[x][y] = pos;
            }
        }
        startingPosition = positions[0][0];
    }


    public boolean IsPositionValid(Position pos) {
        if (pos.coordinates.x >= 0 && pos.coordinates.x < 10 && pos.coordinates.y >= 0 && pos.coordinates.y < 10) {
            return true;
        } else {
            return false;
        }
    }

    

}
