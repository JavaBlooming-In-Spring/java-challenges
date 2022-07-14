package javablooming;

import static javablooming.BaseballUtil.BALL_COUNT;
import static javablooming.BaseballUtil.INVALID_VALUE;
import static javablooming.BaseballUtil.MAX_DIGIT_COUNT;
import static javablooming.Hint.getAllStrike;
import static javablooming.Hint.getHint;
import static javablooming.RestartStatus.END;
import static javablooming.RestartStatus.RESTART;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    int[] playerInputNumbers = new int[BALL_COUNT];
    int[] computerNumbers = new int[BALL_COUNT];

    do {
      initPlayerInputNumbersInvalidValues(playerInputNumbers);
      initComputerNumbers(computerNumbers);
      play(playerInputNumbers, computerNumbers);
      printCongratulationMessage();
      printRestartGuideMessage();
    } while (playerSelectRestart());

    scanner.close();
  }

  private static void play(int[] playerInputNumbers, int[] computerNumbers) {
    Hint result;
    do {
      printInputGuideMessage();
      result = playEachGame(playerInputNumbers, computerNumbers);
      printResultMessage(result);
    } while (isNotAllStrike(result));
  }

  static void initComputerNumbers(int[] computerNumbers) {
    boolean[] isUsedNumber = new boolean[MAX_DIGIT_COUNT];
    for (int i = 0; i < BALL_COUNT; i++) {
      int randomValue;
      do {
        long seed = System.currentTimeMillis();
        randomValue = new Random(seed).nextInt(MAX_DIGIT_COUNT);
      } while (randomValue == 0 || isUsedNumber[randomValue]);
      isUsedNumber[randomValue] = true;
    }
    List<Integer> computerNumberList = new ArrayList<>();
    for (int i = 0; i < MAX_DIGIT_COUNT; i++) {
      if (isUsedNumber[i]) {
        computerNumberList.add(i);
      }
    }
    Collections.shuffle(computerNumberList);
    for (int i = 0; i < computerNumberList.size(); i++) {
      computerNumbers[i] = computerNumberList.get(i);
    }
  }

  private static boolean playerSelectRestart() {
    RestartStatus restartStatus = getRestartOrNotFromPlayer();
    return RESTART.equals(restartStatus);
  }

  private static RestartStatus getRestartOrNotFromPlayer() {
    int playerInputStatusValue = scanner.nextInt();
    if (RESTART.getStatusValue() == playerInputStatusValue) {
      return RESTART;
    }
    return END;
  }

  private static void printRestartGuideMessage() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }

  private static void printCongratulationMessage() {
    System.out.println(BALL_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }

  private static void printResultMessage(Hint result) {
    if (result != null) {
      if (isNothing(result)) {
        System.out.print("낫싱");
      }
      if (ballIsNotZero(result)) {
        System.out.print(result.getBallCount() + "볼 ");
      }
      if (strikeIsNotZero(result)) {
        System.out.print(result.getStrikeCount() + "스트라이크");
      }
      System.out.println();
    }
  }

  private static boolean isNothing(Hint result) {
    return result.getStrikeCount() == 0 && result.getBallCount() == 0;
  }

  private static boolean strikeIsNotZero(Hint result) {
    return result.getStrikeCount() != 0;
  }

  private static boolean ballIsNotZero(Hint result) {
    return result.getBallCount() != 0;
  }

  static boolean isNotAllStrike(Hint result) {
    return !getAllStrike().equals(result);
  }

  private static Hint playEachGame(int[] playerInputNumbers, int[] computerNumbers) {
    Hint hint = null;
    try {
      int playerInputNumber = playerInput();
      checkPlayerInputNumberValid(playerInputNumber);
      setPlayerInputNumbers(playerInputNumbers, playerInputNumber);
      hint = getHint(playerInputNumbers, computerNumbers);
    } catch (InputMismatchException inputMismatchException) {
      System.out.println("잘못 입력하셨습니다.");
      System.out.println("입력 예시: \"528\"");
    }
    return hint;
  }

  private static void checkPlayerInputNumberValid(int playerInputNumber) {
    if (isInvalidInputNumber(playerInputNumber)) {
      throw new InputMismatchException();
    }
  }

  private static void printInputGuideMessage() {
    System.out.println("1~9 사이의 서로 다른 숫자 " + BALL_COUNT + "개를 공백 없이 입력 해 주세요.");
  }

  static void initPlayerInputNumbersInvalidValues(int[] playerInputNumbers) {
    for (int i = 0; i < BALL_COUNT; i++) {
      playerInputNumbers[i] = INVALID_VALUE;
    }
  }

  private static int playerInput() {
    int playerInput = scanner.nextInt();
    return playerInput;
  }

  private static void setPlayerInputNumbers(int[] playerInputNumbers, int playerInputNumber) {
    for (int i = 0; i < BALL_COUNT; i++) {
      playerInputNumbers[i] = playerInputNumber % 10;
      playerInputNumber /= 10;
    }
  }

  private static boolean isInvalidInputNumber(int playerInputNumber) {
    if (isInvalidRange(playerInputNumber)) {
      return true;
    }
    if (isAnyDigitEqualsZero(playerInputNumber)) {
      return true;
    }
    if (hasDuplicateElement(playerInputNumber)) {
      return true;
    }
    return false;
  }

  static boolean isAnyDigitEqualsZero(int playerInputNumber) {
    while (playerInputNumber != 0) {
      int eachDigit = playerInputNumber % 10;
      if (eachDigit == 0) {
        return true;
      }
      playerInputNumber /= 10;
    }
    return false;
  }

  static boolean hasDuplicateElement(int playerInputNumber) {
    int[] eachNumberCountArr = new int[MAX_DIGIT_COUNT];
    while (playerInputNumber != 0) {
      int eachDigit = playerInputNumber % 10;
      eachNumberCountArr[eachDigit]++;
      playerInputNumber /= 10;
    }
    for (int eachNumberCount : eachNumberCountArr) {
      if (eachNumberCount > 1) {
        return true;
      }
    }
    return false;
  }

  static boolean isInvalidRange(int playerInputNumber) {
    return 0 >= playerInputNumber || playerInputNumber >= Math.pow(10.0, BALL_COUNT);
  }
}
