package javablooming;

import javablooming.service.GamePlay;

public class Main {

  public static void main(String[] args) {
    GamePlay game = new GamePlay();
    game.input();
    game.play();
    game.printResult();
  }
}
