package baseballGame;

import static baseballGame.Main.BALL_COUNT;

public class Hint {

  private int strikeCount;
  private int ballCount;

  public void generateHint(int[] guessNumbers, int[] randomNumbers) {
    for (int i = 0; i < BALL_COUNT; i++) {
      for (int j = 0; j < BALL_COUNT; j++) {
        if (guessNumbers[i] == randomNumbers[j]) {
          if (i == j) {
            strikeCount++;
          } else {
            ballCount++;
          }
        }
      }
    }
  }

  public int getBallCount() {
    return ballCount;
  }

  public int getStrikeCount() {
    return strikeCount;
  }

  public void showHint() {
    if (strikeCount == 0 && ballCount == 0) {
      System.out.println("Nothing");
    } else {
      System.out.println(strikeCount + " 스트라이크, " + ballCount + " 볼");
    }
  }

}
