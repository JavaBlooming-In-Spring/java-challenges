package baseballGame;

import static baseballGame.GameUtils.BALL_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

  private int[] randomNumbers;

  public Computer() {
    generateRandomNumbers();
  }

  private void generateRandomNumbers() {
    List<Integer> candidateNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    Collections.shuffle(candidateNumbers);
    List<Integer> randomNumbers = candidateNumbers.subList(0, BALL_COUNT);
    this.randomNumbers = randomNumbers.stream().mapToInt(num -> num).toArray();
  }

  public int[] getRandomNumbers() {
    return randomNumbers;
  }
}
