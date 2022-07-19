package javablooming;

import static javablooming.BaseballUtil.BALL_COUNT;
import static javablooming.BaseballUtil.INVALID_VALUE;
import static javablooming.BaseballUtil.MAX_DIGIT_COUNT;
import static javablooming.Hint.getAllStrike;
import static javablooming.Hint.getHint;
import static javablooming.Main.SCANNER;
import static javablooming.RestartStatus.END;
import static javablooming.RestartStatus.RESTART;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PlayBall {

  final int[] playerInputNumbers = new int[BALL_COUNT];
  final int[] computerNumbers;

  private PlayBall(int[] computerNumbers) {
    this.computerNumbers = computerNumbers;
  }

  public static PlayBall startGame() {
    return new PlayBall(getRandomNumbers());
  }

  static int[] getRandomNumbers() {
    List<Integer> numberSet = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    Collections.shuffle(numberSet);
    return numberSet.subList(0, BALL_COUNT).stream().mapToInt(i -> i).toArray();
  }

  public void play() {
    Hint result;
    do {
      printInputGuideMessage();
      result = playEachGame();
      printResultMessage(result);
    } while (isNotAllStrike(result));
  }

  public void printRestartGuideMessage() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }

  public void printCongratulationMessage() {
    System.out.println(BALL_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }

  private void printResultMessage(Hint result) {
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

  private boolean isNothing(Hint result) {
    return result.getStrikeCount() == 0 && result.getBallCount() == 0;
  }

  private boolean strikeIsNotZero(Hint result) {
    return result.getStrikeCount() != 0;
  }

  private boolean ballIsNotZero(Hint result) {
    return result.getBallCount() != 0;
  }

  boolean isNotAllStrike(Hint result) {
    return !getAllStrike().equals(result);
  }

  private Hint playEachGame() {
    Hint hint = null;
    try {
      int playerInputNumber = playerInput();
      checkPlayerInputNumberValid(playerInputNumber);
      setPlayerInputNumbers(playerInputNumber);
      hint = getHint(playerInputNumbers, computerNumbers);
    } catch (InputMismatchException inputMismatchException) {
      System.out.println("잘못 입력하셨습니다.");
      System.out.println("입력 예시: \"528\"");
    }
    return hint;
  }

  private int playerInput() {
    return SCANNER.nextInt();
  }

  private void checkPlayerInputNumberValid(int playerInputNumber) {
    if (isInvalidInputNumber(playerInputNumber)) {
      throw new InputMismatchException();
    }
  }

  private void setPlayerInputNumbers(int playerInputNumber) {
    for (int i = 0; i < BALL_COUNT; i++) {
      playerInputNumbers[i] = playerInputNumber % 10;
      playerInputNumber /= 10;
    }
  }

  private void printInputGuideMessage() {
    System.out.println("1~9 사이의 서로 다른 숫자 " + BALL_COUNT + "개를 공백 없이 입력 해 주세요.");
  }

  public void initPlayerInputNumbersInvalidValues() {
    for (int i = 0; i < BALL_COUNT; i++) {
      playerInputNumbers[i] = INVALID_VALUE;
    }
  }

  private boolean isInvalidInputNumber(int playerInputNumber) {
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

  boolean isAnyDigitEqualsZero(int playerInputNumber) {
    while (playerInputNumber != 0) {
      int eachDigit = playerInputNumber % 10;
      if (eachDigit == 0) {
        return true;
      }
      playerInputNumber /= 10;
    }
    return false;
  }

  boolean hasDuplicateElement(int playerInputNumber) {
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

  boolean isInvalidRange(int playerInputNumber) {
    return 0 >= playerInputNumber || playerInputNumber >= Math.pow(10.0, BALL_COUNT);
  }

  public static boolean playerSelectRestart() {
    RestartStatus restartStatus = getRestartOrNotFromPlayer();
    return RESTART.equals(restartStatus);
  }

  private static RestartStatus getRestartOrNotFromPlayer() {
    int playerInputStatusValue = SCANNER.nextInt();
    if (RESTART.getStatusValue() == playerInputStatusValue) {
      return RESTART;
    }
    return END;
  }
}
