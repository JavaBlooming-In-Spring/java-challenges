package baseballGame;

import static baseballGame.GameUtils.SCANNER;

public class Main {

  public static void main(String[] args) {
    do {
      GameManager.printStartGameMessage();
      GameManager.play();
      GameManager.printClearGameMessage();
      GameManager.printRestartGuideMessage();
    } while (GameManager.doesPlayerWantRestart());

    GameManager.printEndGameMessage();
    SCANNER.close();
  }
}
