package baseballGame;

import static baseballGame.GameUtils.SCANNER;

public class Main {

  public static void main(String[] args) {
    do {
      GameManager.printStartGameMessage();
      GameManager.play();
      GameManager.printClearGameMessage();
      GameManager.printRestartGuideMessage();
    } while (GameManager.playerWantRestart());

    GameManager.printEndGameMessage();
    SCANNER.close();
  }
}
