package javablooming;

import static javablooming.BaseballUtil.INVALID_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PlayBallTest {

  @Test
  void initComputerNumbers() {
    //given
    int[] computerNumbers;

    //when
    computerNumbers = PlayBall.getRandomNumbers();

    //then
    checkElementInRange(computerNumbers);
    checkUniqueElement(computerNumbers);

  }

  private void checkElementInRange(int[] computerNumbers) {
    assertThat(computerNumbers[0]).isLessThan(10);
    assertThat(computerNumbers[0]).isGreaterThan(0);
    assertThat(computerNumbers[1]).isLessThan(10);
    assertThat(computerNumbers[1]).isGreaterThan(0);
    assertThat(computerNumbers[2]).isLessThan(10);
    assertThat(computerNumbers[2]).isGreaterThan(0);
  }

  private void checkUniqueElement(int[] computerNumbers) {
    assertThat(computerNumbers[0]).isNotEqualTo(computerNumbers[1]);
    assertThat(computerNumbers[1]).isNotEqualTo(computerNumbers[2]);
    assertThat(computerNumbers[2]).isNotEqualTo(computerNumbers[0]);
  }

  @Test
  void isAllStrike() {
    //given
    Hint allStrikeHint = Hint.getAllStrike();
    PlayBall playBall = PlayBall.startGame();

    //when
    boolean notAllStrike = playBall.isNotAllStrike(allStrikeHint);

    //then
    assertThat(notAllStrike).isFalse();
  }

  @Test
  void isNotAllStrike() {
    //given
    Hint notAllStrikeHint = Hint.getHint(new int[]{1, 2, 3}, new int[]{1, 2, 4});
    PlayBall playBall = PlayBall.startGame();

    //when
    boolean notAllStrike = playBall.isNotAllStrike(notAllStrikeHint);

    //then
    assertThat(notAllStrike).isTrue();
  }

  @Test
  void initPlayerInputNumbersInvalidValues() {
    //given
    PlayBall playBall = PlayBall.startGame();

    //when
    playBall.initPlayerInputNumbersInvalidValues();

    //then
    assertThat(playBall.playerInputNumbers[0]).isEqualTo(INVALID_VALUE);
    assertThat(playBall.playerInputNumbers[1]).isEqualTo(INVALID_VALUE);
    assertThat(playBall.playerInputNumbers[2]).isEqualTo(INVALID_VALUE);
  }

  @Test
  void isAnyDigitEqualsZero() {
    //given
    int playerInputNumber = 250;
    PlayBall playBall = PlayBall.startGame();

    //when
    boolean anyDigitEqualsZero = playBall.isAnyDigitEqualsZero(playerInputNumber);

    //then
    assertThat(anyDigitEqualsZero).isTrue();
  }

  @Test
  void hasDuplicateElement() {
    //given
    int playerInputNumber = 224;
    PlayBall playBall = PlayBall.startGame();

    //when
    boolean hasDuplicateElement = playBall.hasDuplicateElement(playerInputNumber);

    //then
    assertThat(hasDuplicateElement).isTrue();
  }

  @Test
  void isInvalidRange() {
    //given
    int playerInputNumber = 1234;
    PlayBall playBall = PlayBall.startGame();

    //when
    boolean invalidRange = playBall.isInvalidRange(playerInputNumber);

    //then
    assertThat(invalidRange).isTrue();
  }
}