package javablooming;

import static javablooming.BaseballUtil.BALL_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HintTest {

  @Test
  public void getAllStrike() {
    assertThat(BALL_COUNT).isEqualTo(Hint.getAllStrike().getStrikeCount());
  }

  @Test
  public void getHint1B() {
    // given
    int[] playerInputNumbers = {5, 2, 4};
    int[] computerNumbers = {1, 3, 5};

    // when
    Hint hint = Hint.getHint(playerInputNumbers, computerNumbers);

    // then
    assertThat(hint.getBallCount()).isEqualTo(1);
    assertThat(hint.getStrikeCount()).isEqualTo(0);
  }

  @Test
  public void getHint2B() {
    // given
    int[] playerInputNumbers = {5, 2, 4};
    int[] computerNumbers = {2, 3, 5};

    // when
    Hint hint = Hint.getHint(playerInputNumbers, computerNumbers);

    // then
    assertThat(hint.getBallCount()).isEqualTo(2);
    assertThat(hint.getStrikeCount()).isEqualTo(0);
  }

  @Test
  public void getHint3B() {
    // given
    int[] playerInputNumbers = {5, 2, 4};
    int[] computerNumbers = {2, 4, 5};

    // when
    Hint hint = Hint.getHint(playerInputNumbers, computerNumbers);

    // then
    assertThat(hint.getBallCount()).isEqualTo(3);
    assertThat(hint.getStrikeCount()).isEqualTo(0);
  }

  @Test
  public void getHint1S() {
    // given
    int[] playerInputNumbers = {5, 2, 4};
    int[] computerNumbers = {5, 3, 9};

    // when
    Hint hint = Hint.getHint(playerInputNumbers, computerNumbers);

    // then
    assertThat(hint.getBallCount()).isEqualTo(0);
    assertThat(hint.getStrikeCount()).isEqualTo(1);
  }

  @Test
  public void getHint1S1B() {
    // given
    int[] playerInputNumbers = {5, 2, 4};
    int[] computerNumbers = {5, 3, 2};

    // when
    Hint hint = Hint.getHint(playerInputNumbers, computerNumbers);

    // then
    assertThat(hint.getBallCount()).isEqualTo(1);
    assertThat(hint.getStrikeCount()).isEqualTo(1);
  }

  @Test
  public void getHint2S() {
    // given
    int[] playerInputNumbers = {5, 2, 4};
    int[] computerNumbers = {5, 2, 8};

    // when
    Hint hint = Hint.getHint(playerInputNumbers, computerNumbers);

    // then
    assertThat(hint.getBallCount()).isEqualTo(0);
    assertThat(hint.getStrikeCount()).isEqualTo(2);
  }

  @Test
  public void getHint3S() {
    // given
    int[] playerInputNumbers = {5, 2, 4};
    int[] computerNumbers = {5, 2, 4};

    // when
    Hint hint = Hint.getHint(playerInputNumbers, computerNumbers);

    // then
    assertThat(hint.getBallCount()).isEqualTo(0);
    assertThat(hint.getStrikeCount()).isEqualTo(3);
  }
}