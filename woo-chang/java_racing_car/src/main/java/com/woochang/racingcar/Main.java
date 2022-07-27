package com.woochang.racingcar;

import com.woochang.racingcar.domain.User;
import com.woochang.racingcar.game.GameHelper;

public class Main {

  public static void main(String[] args) {
    User user = new User();
    GameHelper.initGame(user);
    GameHelper.racingStart(user);
    GameHelper.gameEnd(user.getCars());
  }

}
