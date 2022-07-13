package baseballGame;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HintTest {
  @Test
  public void strike1ball1() {
    int[] guessNumbers = {1, 4, 9};
    int[] randomNumbers = {4, 3, 9};
    Hint hint = new Hint();

    hint.generateHint(guessNumbers, randomNumbers);
    int ballCount = hint.getBallCount();
    int strikeCount = hint.getStrikeCount();

    assertThat(ballCount).isEqualTo(1);
    assertThat(strikeCount).isEqualTo(1);
  }

  @Test
  public void strike3() {
    int[] guessNumbers = {1, 4, 9};
    int[] randomNumbers = {1, 4, 9};
    Hint hint = new Hint();

    hint.generateHint(guessNumbers, randomNumbers);
    int ballCount = hint.getBallCount();
    int strikeCount = hint.getStrikeCount();

    assertThat(ballCount).isEqualTo(0);
    assertThat(strikeCount).isEqualTo(3);
  }

  @Test
  public void nothing() {
    int[] guessNumbers = {2, 2, 2};
    int[] randomNumbers = {1, 4, 9};
    Hint hint = new Hint();

    hint.generateHint(guessNumbers, randomNumbers);
    int ballCount = hint.getBallCount();
    int strikeCount = hint.getStrikeCount();

    assertThat(ballCount).isEqualTo(0);
    assertThat(strikeCount).isEqualTo(0);
  }
}