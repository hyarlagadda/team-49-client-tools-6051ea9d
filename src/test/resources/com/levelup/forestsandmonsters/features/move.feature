Feature: Move in a direction 
    
    I want to move my character. If they attempt to 
    move past a boundary, the move results in no change in position but does increment move count.

    Scenario Outline: Move in a direction
        Given the character starts at position with XCoordinates <startingPositionX> 
        And starts at YCoordinates <startingPositionY>
        And the player chooses to move in <direction>
        And the current move count is <startingMoveCount>
        When the character moves
        Then the character is now at position with XCoordinates <endingPositionX>
        And YCoordinates <endingPositionY>
        And the new move count is <endingMoveCount>
        Examples:
            | startingPositionX | startingPositionY | direction | startingMoveCount | endingPositionX | endingPositionY | endingMoveCount |
            | 0 | 0 | NORTH | 1 | 0 | 1 | 2 |
            | 0 | 0 | SOUTH | 2 | 0 | 0 | 3 |
            | 0 | 0 | WEST | 3 | 0 | 0 | 4 |
            | 0 | 0 | EAST | 4 | 1 | 0 | 5 |
            | 9 | 9 | NORTH | 5 | 9 | 9 | 6 |
            | 9 | 9 | SOUTH | 6 | 9 | 8 | 7 |
            | 9 | 9 | WEST | 7 | 8 | 9 | 8 |
            | 9 | 9 | EAST | 8 | 9 | 9 | 9 |
            | 5 | 5 | NORTH | 9 | 5 | 6 | 10 |
            | 5 | 5 | SOUTH | 10 | 5 | 4 | 11 |
            | 5 | 5 | WEST | 11 | 4 | 5 | 12 |
            | 5 | 5 | EAST | 12 | 6 | 5 | 13 |