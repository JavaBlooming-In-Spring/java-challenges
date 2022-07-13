package baseballGame;

import java.util.Random;

public class Computer {

  private int[] randomNumbers;

  public void generateRandomNumbers() {
    Random random = new Random();
    random.setSeed(System.currentTimeMillis());
    randomNumbers = new int[3];
    for (int i = 0; i < 3; i++) {
      int randomNumber = random.nextInt(8) + 1;
      this.randomNumbers[i] = randomNumber;
    }
  }

  public int[] getRandomNumbers() {
    return randomNumbers;
  }
}
