package java_racing_car.java_racing_car;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
  private void setSystemInput(String input){
    ByteArrayInputStream systemInput = new ByteArrayInputStream(input.getBytes());
    User.sc = new Scanner(systemInput);
    System.setIn(systemInput);
  }

  @Test
  @DisplayName("자동차 리스트 테스트")
  public void CarListTest(){
    User user = new User();
    GameController gameController = new GameController(user);
    Game game = new Game(user,gameController);

    setSystemInput("pobi,woni,jun");

    user.userInputCarName();
    gameController.generateCarNameList();
    gameController.generateCarList();

    Assertions.assertThat(gameController.list.size()).isEqualTo(3);
    Assertions.assertThat(gameController.list.contains("pobi"));
    Assertions.assertThat(gameController.list.contains("woni"));
    Assertions.assertThat(gameController.list.contains("jun"));
  }
  @Test
  @DisplayName("자동차 점수 테스트")
  public void CarScoreTest(){
    User user = new User();
    GameController gameController = new GameController(user);
    Game game = new Game(user,gameController);

    setSystemInput("pobi,woni,jun");
    user.userInputCarName();
    gameController.generateCarNameList();
    gameController.generateCarList();

    gameController.list.get(0).plusScore();
    gameController.list.get(0).plusScore();
    gameController.list.get(0).plusScore();

    Assertions.assertThat(gameController.list.get(0).getScore()).isEqualTo(3);
    Assertions.assertThat(gameController.list.get(1).getScore()).isEqualTo(0);
    Assertions.assertThat(gameController.list.get(2).getScore()).isEqualTo(0);
  }
}
