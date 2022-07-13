package javablooming;

import static javablooming.BaseballUtil.INVALID_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void initComputerNumbers() {
    //given
    int[] computerNumbers = {-1, -1, -1};

    //when
    Main.initComputerNumbers(computerNumbers);

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

    //when
    boolean notAllStrike = Main.isNotAllStrike(allStrikeHint);

    //then
    assertThat(notAllStrike).isFalse();
  }

  @Test
  void isNotAllStrike() {
    //given
    Hint notAllStrikeHint = Hint.getHint(new int[]{1, 2, 3}, new int[]{1, 2, 4});

    //when
    boolean notAllStrike = Main.isNotAllStrike(notAllStrikeHint);

    //then
    assertThat(notAllStrike).isTrue();
  }

  @Test
  void initPlayerInputNumbersInvalidValues() {
    //given
    int[] playerInputNumbers = {4, 5, 7};

    //when
    Main.initPlayerInputNumbersInvalidValues(playerInputNumbers);

    //then
    assertThat(playerInputNumbers[0]).isEqualTo(INVALID_VALUE);
    assertThat(playerInputNumbers[1]).isEqualTo(INVALID_VALUE);
    assertThat(playerInputNumbers[2]).isEqualTo(INVALID_VALUE);
  }

  @Test
  void isAnyDigitEqualsZero() {
    //given
    int playerInputNumber = 250;

    //when
    boolean anyDigitEqualsZero = Main.isAnyDigitEqualsZero(playerInputNumber);

    //then
    assertThat(anyDigitEqualsZero).isTrue();
  }

  @Test
  void hasDuplicateElement() {
    //given
    int playerInputNumber = 224;

    //when
    boolean hasDuplicateElement = Main.hasDuplicateElement(playerInputNumber);

    //then
    assertThat(hasDuplicateElement).isTrue();
  }

  @Test
  void isInvalidRange() {
    //given
    int playerInputNumber = 1234;

    //when
    boolean invalidRange = Main.isInvalidRange(playerInputNumber);

    //then
    assertThat(invalidRange).isTrue();
  }
}