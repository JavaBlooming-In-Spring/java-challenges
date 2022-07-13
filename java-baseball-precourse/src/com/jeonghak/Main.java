package com.jeonghak;

import static com.jeonghak.Player.BALL_COUNT;
import java.util.Scanner;

public class Main {

  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Computer computer = new Computer();
    Hint hint = new Hint();
    do {
      computer.generateRandomNumbers();
      play(computer.getRandomNumbers());
    } while (playerWantRestart());
    sc.close();
  }

  public static void play(int[] randomNumbers) {
    Player player = new Player();
    while (true) {
      Hint hint = new Hint();
      player.guessThreeNumbers(sc);
      hint.generateHint(randomNumbers, player.getGuessedThreeNumbers());
      hint.showHint();
      if (isClearGame(hint.getStrikeCount())) {
        System.out.println("Game Clear!!!!");
        break;
      }
    }
  }

  private static boolean isClearGame(int strikeCount) {
    return strikeCount == BALL_COUNT;
  }

  private static boolean playerWantRestart() {
    System.out.println("게임을 다시 하고 싶으시면 yes 아니면 no를 입력해 주세요");
    sc.nextLine();
    String answer = sc.nextLine();
    System.out.println("answer = " + answer);
    if (answer.equals("yes")) {
      return true;
    } else if (answer.equals("no")) {
      return false;
    } else {
      System.out.println("잘못된 입력으로 게임을 종료합니다.");
      return false;
    }
  }
}
