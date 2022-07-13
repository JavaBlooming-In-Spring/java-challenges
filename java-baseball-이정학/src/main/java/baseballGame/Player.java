package baseballGame;

import static baseballGame.Main.BALL_COUNT;

import java.util.Scanner;

public class Player {

  private int[] guessedThreeNumbers;

  public void guessThreeNumbers(Scanner sc) {
    int count = 0;
    int[] inputNumbers = new int[3];
    int inputNumber;
    while (count != BALL_COUNT) {
      inputNumber = sc.nextInt();
      if (checkValid(inputNumber)) {
        inputNumbers[count++] = inputNumber;
      }
    }
    guessedThreeNumbers = inputNumbers;
  }

  public int[] getGuessedThreeNumbers() {
    return guessedThreeNumbers;
  }

  private boolean checkValid(int inputNumber) {
    if (inputNumber < 0 || inputNumber > 9) {
      System.out.println("잘못된 입력입니다. 0 ~ 9 의 정수를 입력해 주세요.");
      return false;
    }
    return true;
  }

}
