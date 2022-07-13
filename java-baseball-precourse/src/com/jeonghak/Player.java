package com.jeonghak;

import java.util.Scanner;

public class Player {

  public static final int BALL_COUNT = 3;
  private int[] guessedThreeNumbers;

  public void guessThreeNumbers(Scanner sc) {
    int[] inputNumbers = new int[3];
    int inputNumber;
    for (int i = 0; i < BALL_COUNT; i++) {
      inputNumber = sc.nextInt();
      checkValid(inputNumber);
      inputNumbers[i] = inputNumber;
    }
    guessedThreeNumbers = inputNumbers;
  }

  public int[] getGuessedThreeNumbers() {
    return guessedThreeNumbers;
  }

  private void checkValid(int inputNumber) {
    if (inputNumber < 0 || inputNumber > 9) {
      System.out.println("잘못된 입력");
    }
  }

}
