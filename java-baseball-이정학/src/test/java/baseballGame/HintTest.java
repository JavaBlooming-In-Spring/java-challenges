package baseballGame;

import static baseballGame.GameUtils.BALL_COUNT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;

class HintTest {
  @Test
  public void allStrike() {
    int[] guessedNumbers = {1, 4, 9};
    int[] randomNumbers = {1, 4, 9};
    Hint hint = Hint.getHint(guessedNumbers,randomNumbers);

    int ballCount = hint.getBallCount();
    int strikeCount = hint.getStrikeCount();

    assertThat(strikeCount).isEqualTo(BALL_COUNT);
    assertThat(ballCount).isEqualTo(0);
  }
  @Test
  public void nothing() {
    int[] guessedNumbers = {1, 4, 9};
    int[] randomNumbers = {2, 3, 8};
    Hint hint = Hint.getHint(guessedNumbers,randomNumbers);

    int ballCount = hint.getBallCount();
    int strikeCount = hint.getStrikeCount();

    assertThat(strikeCount).isEqualTo(0);
    assertThat(ballCount).isEqualTo(0);
  }

  @Test
  public void strike1ball0() {
    int[] guessedNumbers = {1, 4, 9};
    int[] randomNumbers = {1, 3, 8};
    Hint hint = Hint.getHint(guessedNumbers,randomNumbers);

    int ballCount = hint.getBallCount();
    int strikeCount = hint.getStrikeCount();

    assertThat(strikeCount).isEqualTo(1);
    assertThat(ballCount).isEqualTo(0);
  }
  @Test
  public void strike2ball0() {
    int[] guessedNumbers = {1, 4, 9};
    int[] randomNumbers = {1, 4, 8};
    Hint hint = Hint.getHint(guessedNumbers,randomNumbers);

    int ballCount = hint.getBallCount();
    int strikeCount = hint.getStrikeCount();

    assertThat(strikeCount).isEqualTo(2);
    assertThat(ballCount).isEqualTo(0);
  }
  @Test
  public void strike0ball1() {
    int[] guessedNumbers = {1, 4, 9};
    int[] randomNumbers = {2, 5, 1};
    Hint hint = Hint.getHint(guessedNumbers,randomNumbers);

    int ballCount = hint.getBallCount();
    int strikeCount = hint.getStrikeCount();

    assertThat(strikeCount).isEqualTo(0);
    assertThat(ballCount).isEqualTo(1);
  }
  @Test
  public void strike0ball3() {
    int[] guessedNumbers = {1, 4, 9};
    int[] randomNumbers = {4, 9, 1};
    Hint hint = Hint.getHint(guessedNumbers,randomNumbers);

    int ballCount = hint.getBallCount();
    int strikeCount = hint.getStrikeCount();

    assertThat(strikeCount).isEqualTo(0);
    assertThat(ballCount).isEqualTo(3);
  }
  @Test
  public void strike1ball1() {
    int[] guessedNumbers = {1, 4, 9};
    int[] randomNumbers = {4, 3, 9};
    Hint hint = Hint.getHint(guessedNumbers,randomNumbers);

    int ballCount = hint.getBallCount();
    int strikeCount = hint.getStrikeCount();

    assertThat(ballCount).isEqualTo(1);
    assertThat(strikeCount).isEqualTo(1);
  }

}