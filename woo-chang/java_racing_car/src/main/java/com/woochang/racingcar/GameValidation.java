package com.woochang.racingcar;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameValidation {

  public static boolean verifyCars(List<String> cars) {
    for(String car : cars) {
      if(!(isValidCar(car))) return false;
    }
    return true;
  }

  private static boolean isValidCar(String car) {
    if(car.length() <= 0 || car.length() > 5) {
      GameOutput.printForInvalidInput();
      return false;
    }
    return true;
  }

  public static boolean verifyCount(String count) {
    Pattern pattern = Pattern.compile("\\d{0,}");
    Matcher matcher = pattern.matcher(count);
    if(!(matcher.matches())) {
      GameOutput.printForInvalidInput();
      return false;
    }
    return true;
  }
}
