package com.jeonghak.racingcar;

import static com.jeonghak.racingcar.util.GameUtil.printCongratulationForWinners;
import static com.jeonghak.racingcar.util.GameUtil.printExecuteResultMessage;

import com.jeonghak.racingcar.service.GamePlay;

public class Main {

  public static void main(String[] args) {
    GamePlay game = new GamePlay();
    game.init();
    printExecuteResultMessage();
    game.play();
    printCongratulationForWinners(game.getNamesOfWinners());
  }

}
