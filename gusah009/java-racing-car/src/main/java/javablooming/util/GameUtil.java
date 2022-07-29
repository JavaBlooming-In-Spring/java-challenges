package javablooming.util;

import java.util.Scanner;

public class GameUtil {

  public static Scanner SCANNER = new Scanner(System.in);

  public enum InputStatus {
    SUCCEED(true), FAIL(false);

    InputStatus(boolean b) {
    }
  }

  public enum RacingResult {
    FORWARD(true), STAY(false);

    RacingResult(boolean b) {
    }
  }
}
