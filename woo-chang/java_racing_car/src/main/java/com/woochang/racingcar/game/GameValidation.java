package com.woochang.racingcar.game;

import java.util.List;

public class GameValidation {

  public static boolean verifyCarNames(List<String> carNames) {
    for(String carName : carNames) {
      if(!(isValidCarName(carName))) return false;
    }
    return true;
  }

  private static boolean isValidCarName(String carName) {
    if(carName.length() == 0 || carName.length() > 5) {
      GameOutput.printForInvalidInput();
      return false;
    }
    return true;
  }

  public static boolean verifyCount(String count) {
    if(!(count.matches("\\d*"))) {
      GameOutput.printForInvalidInput();
      return false;
    }
    return true;
  }
}
