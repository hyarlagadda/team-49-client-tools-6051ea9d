package com.levelup.forestsandmonsters.cli;

import java.util.ArrayList;
import java.util.List;

import com.levelup.forestsandmonsters.GameController;
import com.levelup.forestsandmonsters.GameController.GameStatus;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.standard.commands.Quit;

@ShellComponent
public class LevelUpGame implements Quit.Command {

  private final GameController gameController;
  private List<GameStatus> gameHistory;
  private boolean isGameStarted = false;

  public LevelUpGame() {
    super();
    this.gameController = new GameController();
    this.gameHistory = new ArrayList<GameStatus>();
  }

  @ShellMethodAvailability("notStartedCheck")
  @ShellMethod(value = "Create a character (characterName)", key = { "create-character", "create" })
  public void createCharacter(@ShellOption(defaultValue = "Character") String characterName) {
    gameController.createCharacter(characterName);
    GameStatus status = gameController.getGameStatus();

    System.out.println("Your character, " + status.characterName + " is created!");
  }

  @ShellMethodAvailability("notStartedCheck")
  @ShellMethod("Start the game")
  public void startGame() {
    isGameStarted = true;
    gameController.startGame();
    // TODO: Update this prompt. Also, do you want to get the game status and tell
    // the character where their character is?
    System.out.println("Welcome to Forests and Monsters! You have entered a mysterious place.");
    System.out.println("Would you like to go North(N), South(S), East(E), West(W) or Exit(X)?");
    System.out.println(printCurrentPosition());
  }

  @ShellMethod(value = "Move North", key = { "N", "n" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveNorth() {
    gameController.move(GameController.DIRECTION.NORTH);
    updateStatus(gameController.getGameStatus());
    System.out.println(printCurrentPosition());
  }

  @ShellMethod(value = "Move South", key = { "S", "s" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveSouth() {
    gameController.move(GameController.DIRECTION.SOUTH);
    updateStatus(gameController.getGameStatus());
    System.out.println(printCurrentPosition());
  }

  @ShellMethod(value = "Move East", key = { "E", "e" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveEast() {
    gameController.move(GameController.DIRECTION.EAST);
    updateStatus(gameController.getGameStatus());
    System.out.println(printCurrentPosition());
  }

  @ShellMethod(value = "Move West", key = { "W", "w" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveWest() {
    gameController.move(GameController.DIRECTION.WEST);
    updateStatus(gameController.getGameStatus());
    System.out.println(printCurrentPosition());
  }

  @ShellMethod(value = "End the game", key = { "X", "x" })
  public void endGame() {
    System.out.println(printCurrentPosition());
    System.out.println("You exit the mysterious world.");
    printSummary();
    System.exit(0);
  }

  private void printSummary() {
    System.out.println("Exiting the mysterious land!");
    int moveCount = 0;
    for (GameStatus status : gameHistory) {
      // TODO: Override toString on game status to print pretty
      moveCount = status.moveCount;
    }
    System.out.println("Total Moves " + moveCount);
    //TODO: Print anything else you committed to in your mockup
  }

  private String printCurrentPosition() {

    StringBuffer buffer = new StringBuffer("Your current position: (").append(Double.valueOf(gameController.getGameStatus().currentPosition.getX()).intValue())
    .append(",").append(Double.valueOf(gameController.getGameStatus().currentPosition.getY()).intValue() + ")");
    
    return buffer.toString();
  }

  private void updateStatus(GameStatus status) {
    this.gameHistory.add(status);
  }

  public Availability startedCheck() {
    return isGameStarted
        ? Availability.available()
        : Availability.unavailable("game not started");
  }

  public Availability notStartedCheck() {
    return !isGameStarted
        ? Availability.available()
        : Availability.unavailable("game already started");
  }

}
