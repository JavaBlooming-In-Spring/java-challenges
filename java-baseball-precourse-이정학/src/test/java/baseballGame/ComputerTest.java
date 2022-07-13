package baseballGame;

import static baseballGame.Main.BALL_COUNT;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public
class ComputerTest {

  @Test
  public void generateRandomNumbersTest() {
    //given
    Computer computer = new Computer();

    computer.generateRandomNumbers();
    int[] randomNumbers = computer.getRandomNumbers();

    assertThat(randomNumbers.length).isEqualTo(BALL_COUNT);

    for (int i = 0; i < BALL_COUNT; i++) {
      assertThat(checkValid(randomNumbers[i])).isTrue();
    }
  }

  private boolean checkValid(int randomNumber) {
    return randomNumber > 0 && randomNumber < 10;
  }
}