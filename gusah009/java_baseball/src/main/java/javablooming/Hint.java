package javablooming;

import static javablooming.BaseballUtil.BALL_COUNT;

import java.util.Objects;

public class Hint {

  private static final Hint NOTHING = new Hint(0, 0);
  private static final Hint ALL_STRIKE = new Hint(BALL_COUNT, 0);

  private final int strikeCount;
  private final int ballCount;

  public int getStrikeCount() {
    return strikeCount;
  }

  public int getBallCount() {
    return ballCount;
  }

  private Hint(int strikeCount, int ballCount) {
    this.strikeCount = strikeCount;
    this.ballCount = ballCount;
  }

  public static Hint getAllStrike() {
    return ALL_STRIKE;
  }

  public static Hint getHint(int[] playerInputNumbers, int[] computerNumbers) {
    int strikeCount = getStrikeCount(playerInputNumbers, computerNumbers);
    int ballCount = getBallCount(playerInputNumbers, computerNumbers);

    if (isNothingCorrect(strikeCount, ballCount)) {
      return NOTHING;
    }
    if (isAllStrike(strikeCount)) {
      return ALL_STRIKE;
    }
    return new Hint(strikeCount, ballCount);
  }

  private static boolean isAllStrike(int strikeCount) {
    return strikeCount == BALL_COUNT;
  }

  private static boolean isNothingCorrect(int strikeCount, int ballCount) {
    return strikeCount == 0 && ballCount == 0;
  }

  private static int getStrikeCount(int[] playerInputNumbers, int[] computerNumbers) {
    int strikeCount = 0;
    for (int i = 0; i < BALL_COUNT; i++) {
      if (playerInputNumbers[i] == computerNumbers[i]) {
        strikeCount++;
      }
    }
    return strikeCount;
  }

  private static int getBallCount(int[] playerInputNumbers, int[] computerNumbers) {
    int ballCount = 0;
    for (int i = 0; i < BALL_COUNT; i++) {
      for (int j = 0; j < BALL_COUNT; j++) {
        if (i != j) {
          int playerInputNumber = playerInputNumbers[i];
          int computerNumber = computerNumbers[j];
          if (playerInputNumber == computerNumber) {
            ballCount++;
          }
        }
      }
    }
    return ballCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Hint)) {
      return false;
    }
    Hint hint = (Hint) o;
    return getStrikeCount() == hint.getStrikeCount() && getBallCount() == hint.getBallCount();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getStrikeCount(), getBallCount());
  }

}
