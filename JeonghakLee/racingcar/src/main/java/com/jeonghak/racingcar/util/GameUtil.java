package com.jeonghak.racingcar.util;

import java.util.List;
import java.util.Random;

public class GameUtil {

  public static final int MAX_CAR_NAME = 5;

  public static void printCongratulationForWinners(List<String> namesOfWinners) {
    System.out.println(String.join(",", namesOfWinners) + "가 최종 우승했습니다.");
  }

  public static void printExecuteResultMessage() {
    System.out.println();
    printMessage("실행결과");
  }

  public static void printErrorMessage() {
    printMessage("유효하지 않은 입력입니다. 재입력 입력하세요.");
  }

  public static void printMessage(String message) {
    System.out.println(message);
  }

  public static boolean isPossibleToMove() {
    return getRandomNumber() > 3;
  }

  public static int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(10);
  }

}
