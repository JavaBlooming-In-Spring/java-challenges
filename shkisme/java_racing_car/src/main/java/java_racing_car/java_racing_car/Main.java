package java_racing_car.java_racing_car;

import static java_racing_car.java_racing_car.Error.ERROR;

public class Main {

  public static void main(String[] args) {
    User user = new User();
    GameController gameController = new GameController(user);
    Game game = new Game(user, gameController);

    do {
      user.initCarName();
      gameController.askCarNames();
      user.userInputCarName();
    } while (gameController.isCarNameError() == ERROR);
    do {
      user.setTryNumber();
      gameController.askTryNumber();
      user.userInputTryNumber();
    } while (gameController.isTryNumberError() == ERROR);

    user.closeScanner();
    gameController.generateCarNameList();
    gameController.generateCarList();
    game.gamePlay();
    game.gameResult();
  }
}
