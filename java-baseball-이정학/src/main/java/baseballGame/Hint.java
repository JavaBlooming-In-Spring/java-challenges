package baseballGame;

import static baseballGame.GameUtils.BALL_COUNT;

import java.util.Objects;

public class Hint {

  private static final Hint NOTHING = new Hint(0, 0);
  private static final Hint ALLSTRIKE = new Hint(BALL_COUNT, 0);
  private final int strikeCount;
  private final int ballCount;

  public int getStrikeCount() {
    return strikeCount;
  }

  public int getBallCount() {
    return ballCount;
  }

  public void showHint() {
    if (strikeCount == 0 && ballCount == 0) {
      System.out.print("낫싱");
    }
    if (ballCount != 0) {
      System.out.print(ballCount + "볼 ");
    }
    if (strikeCount != 0) {
      System.out.print(strikeCount + "스트라이크");
    }
    System.out.println();
  }

  public static Hint getHint(int[] playerInputNumbers, int[] computerNumbers) {
    int strikeCount = getStrikeCount(playerInputNumbers, computerNumbers);
    int ballCount = getBallCount(playerInputNumbers, computerNumbers);

    if (strikeCount == 0 && ballCount == 0) {
      return NOTHING;
    }
    if (strikeCount == BALL_COUNT) {
      return ALLSTRIKE;
    }
    return new Hint(strikeCount, ballCount);
  }

  private Hint(int strikeCount, int ballCount) {
    this.strikeCount = strikeCount;
    this.ballCount = ballCount;
  }

  private static int getStrikeCount(int[] guessNumbers, int[] randomNumbers) {
    int strikeCount = 0;
    for (int i = 0; i < BALL_COUNT; i++) {
      for (int j = 0; j < BALL_COUNT; j++) {
        if (i == j && guessNumbers[i] == randomNumbers[j]) {
          strikeCount++;
        }
      }
    }
    return strikeCount;
  }

  private static int getBallCount(int[] guessNumbers, int[] randomNumbers) {
    int ballCount = 0;
    for (int i = 0; i < BALL_COUNT; i++) {
      for (int j = 0; j < BALL_COUNT; j++) {
        if (i != j && guessNumbers[i] == randomNumbers[j]) {
          ballCount++;
        }
      }
    }
    return ballCount;
  }

}
