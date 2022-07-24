package com.woochang.racingcar;

public class Main {

  public static void main(String[] args) {
    User user = new User();
    GameHelper.initGame(user);
    GameHelper.racingStart(user);
    GameHelper.gameEnd(user.getCars());
  }

}
