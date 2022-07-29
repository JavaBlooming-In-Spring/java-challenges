package com.woochang.racingcar;

import java.util.Random;

public class RandomSystem {

  public static boolean canGoForward() {
    return generateRandomNum() >= 4;
  }

  private static int generateRandomNum() {
    Random random = new Random();
    return random.nextInt(10);
  }

}
