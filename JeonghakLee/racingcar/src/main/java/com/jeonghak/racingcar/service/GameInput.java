package com.jeonghak.racingcar.service;

import static com.jeonghak.racingcar.util.GameUtil.MAX_CAR_NAME;
import static com.jeonghak.racingcar.util.GameUtil.printErrorMessage;

import java.util.Scanner;

public class GameInput {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static void inputClose() {
    SCANNER.close();
  }

  public static int inputNumberOfAttempts() {
    String playerInput;
    do {
      playerInput = getPlayerInput();
    } while (!isPositiveInteger(playerInput));
    return Integer.parseInt(playerInput);
  }

  static boolean isPositiveInteger(String playerInput) {
    return playerInput.matches("\\d*");
  }

  public static String[] inputCarNames() {
    String input;
    String[] carNames;
    do {
      input = getPlayerInput();
      carNames = input.split(",");
    } while (isInvalidCarNames(carNames));
    return carNames;
  }

  static boolean isInvalidNumberOfAttempts(int numberOfAttempts) {
    return numberOfAttempts < 0;
  }

  private static String getPlayerInput() {
    return SCANNER.nextLine();
  }

  private static boolean isInvalidCarNames(String[] carNames) {
    for (String carName : carNames) {
      if (isInvalidCarName(carName)) {
        printErrorMessage();
        return true;
      }
    }
    return false;
  }

  static boolean isInvalidCarName(String carName) {
    return carName.length() == 0 || carName.length() > MAX_CAR_NAME;
  }
}
