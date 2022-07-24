package javablooming;

import java.util.Scanner;

public class Main {

  public static Scanner SCANNER = new Scanner(System.in);

  public static void main(String[] args) {
    do {
      PlayBall playBall = PlayBall.startGame();
      playBall.initPlayerInputNumbersInvalidValues();
      playBall.play();
      playBall.printCongratulationMessage();
      playBall.printRestartGuideMessage();
    } while (PlayBall.playerSelectRestart());

    SCANNER.close();
  }
}
