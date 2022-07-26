package baseballGame;

import static baseballGame.GameManager.changeInputNumberToArray;
import static baseballGame.GameManager.hasAnyZero;
import static baseballGame.GameManager.hasDuplicate;
import static baseballGame.GameManager.isInvalidLength;
import static baseballGame.GameUtils.BALL_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

  Computer computer = new Computer();

  @Test
  void generateRandomNumbersTest() {
    //given
    int[] randomNumbers;
    //when
    randomNumbers = computer.getRandomNumbers();

    //then
    assertThat(hasDuplicate(randomNumbers)).isFalse();
    assertThat(hasAnyZero(randomNumbers)).isFalse();
    checkElementInRange(randomNumbers);
  }

  @Test
  void changeToArrayTest() {
    int inputNumber = 123;
    int[] guessedNumbers = changeInputNumberToArray(inputNumber);
    assertThat(guessedNumbers[0]).isEqualTo(1);
    assertThat(guessedNumbers[1]).isEqualTo(2);
    assertThat(guessedNumbers[2]).isEqualTo(3);
  }

  @Test
  void invalidLengthTest() {
    int inputNumber = 1234;

    assertThat(isInvalidLength(inputNumber)).isTrue();
  }

  @Test
  void hasAnyZeroTest() {
    int number = 250;
    int[] guessedNumbers = changeInputNumberToArray(number);
    assertThat(hasAnyZero(guessedNumbers)).isTrue();
  }

  @Test
  void hasDuplicateTest() {
    int number = 221;
    int[] guessedNumbers = changeInputNumberToArray(number);
    assertThat(hasDuplicate(guessedNumbers)).isTrue();
  }

  @Test
  void isNotClearTest() {
    Assertions.assertThat(GameManager.isNotClear(BALL_COUNT)).isFalse();
    Assertions.assertThat(GameManager.isNotClear(0)).isTrue();
  }

  private void checkElementInRange(int[] randomNumbers) {
    for (int i = 0; i < BALL_COUNT; i++) {
      assertThat(randomNumbers[i]).isLessThan(10);
      assertThat(randomNumbers[i]).isGreaterThan(0);
    }
  }
}
