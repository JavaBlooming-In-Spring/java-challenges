package baseballGame;

import static baseballGame.GameStatus.RESTART;
import static baseballGame.GameStatus.END;
import static baseballGame.GameUtils.BALL_COUNT;
import static baseballGame.GameUtils.SCANNER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class GameManager {


  public static void play() {
    Computer computer = new Computer();
    int strikeCount = 0;
    int[] randomNumbers = computer.getRandomNumbers();
    do {
      printInputRequestMessage();
      int[] guessedNumbers = guessNumbers();
      Hint hint = Hint.getHint(guessedNumbers, randomNumbers);
      hint.showHint();
      strikeCount = hint.getStrikeCount();
    } while (isNotClear(strikeCount));
  }

  public static boolean playerWantRestart() {
    GameStatus playerStatus = getPlayerStatus();
    return RESTART.equals(playerStatus);
  }

  public static int[] guessNumbers() {
    int inputNumber = playerInput();
    int[] numbers = changeInputNumberToArray(inputNumber);
    checkValidInput(inputNumber, numbers);
    return numbers;
  }

  private static void checkValidInput(int inputNumber, int[] numbers) {
    if (isInvalidLength(inputNumber) || isNotValidInputNumber(numbers)) {
      throw new IllegalArgumentException();
    }
  }

  static int[] changeInputNumberToArray(int inputNumber) {
    int[] numbers = new int[BALL_COUNT];
    for (int i = BALL_COUNT - 1; i >= 0; i--) {
      numbers[i] = inputNumber % 10;
      inputNumber /= 10;
    }
    return numbers;
  }

  private static int playerInput() {
    return SCANNER.nextInt();
  }

  private static boolean isNotValidInputNumber(int[] inputNumbers) {
    if (hasAnyZero(inputNumbers)) {
      return true;
    }
    return hasDuplicate(inputNumbers);
  }

  static boolean isInvalidLength(int inputNumber) {
    return inputNumber > Math.pow(10, BALL_COUNT) || inputNumber < 0;
  }

  static boolean hasDuplicate(int[] inputNumbers) {
    List<Integer> numberList = Arrays.stream(inputNumbers).boxed().collect(Collectors.toList());
    Set<Integer> numSet = new HashSet<>(numberList);
    return numberList.size() != numSet.size();
  }

  static boolean hasAnyZero(int[] inputNumbers) {
    for (int i = 0; i < BALL_COUNT; i++) {
      if (inputNumbers[i] == 0) {
        return true;
      }
    }
    return false;
  }
  private static GameStatus getPlayerStatus() {
    int playerStatus = SCANNER.nextInt();
    if (RESTART.getStatus() == playerStatus) {
      return RESTART;
    }
    return END;
  }

  public static void printRestartGuideMessage() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }

  public static void printStartGameMessage() {
    System.out.println("Game start!!!!");
  }

  public static void printClearGameMessage() {
    System.out.println("Game clear!!!!");
  }

  public static void printEndGameMessage() {
    System.out.println("Game End!!!!");
  }

  public static void printInputRequestMessage() {
    System.out.print("숫자를 입력해 주세요: ");
  }

  public static boolean isNotClear(int strikeCount) {
    return (strikeCount != BALL_COUNT);
  }
}
