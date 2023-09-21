package com.levelup;

import javax.swing.text.Position;

public class GampMap {
    
    public Position positions;
    int numPositions =100;

        public GameMap()
        {
            //CreatePositions();
        }

        private void CreatePositions()
        {
           positions = new Position[10,10];
            for (int x = 0; x < 10; x++)
            {
                for (int y = 0; y < 10; y++)
                {
                    Position pos = new Position(x, y);
                    positions[x,y] = pos;
                }
            }
            startingPosition = positions[0,0];
        }


        public boolean IsPositionValid(Position pos)
        {
            if (pos.x >= 0 && pos.x < 10 && pos.y >=0 && pos.y < 10)
            {
                return true;
            }
            else {
                return false;
            }
        }


}
