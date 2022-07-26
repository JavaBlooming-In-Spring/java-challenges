package baseballGame;

import static baseballGame.GameUtils.BALL_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

  private final int[] numbers;

  public Computer() {
    List<Integer> numberList = generateRandomNumberList();
    this.numbers = convertListToArray(numberList);
  }

  private List<Integer> generateRandomNumberList() {
    List<Integer> candidateNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    Collections.shuffle(candidateNumbers);
    return candidateNumbers.subList(0, BALL_COUNT);
  }

  private int[] convertListToArray(List<Integer> numbers) {
    return numbers.stream().mapToInt(num -> num).toArray();
  }

  public int[] getNumbers() {
    return numbers;
  }
}
