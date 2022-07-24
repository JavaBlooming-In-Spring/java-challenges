package javablooming.service;

import static javablooming.util.GameUtil.InputStatus.FAIL;
import static javablooming.util.GameUtil.InputStatus.SUCCEED;
import static javablooming.util.GameUtil.RacingResult.FORWARD;
import static javablooming.util.GameUtil.RacingResult.STAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import javablooming.domain.Car;
import javablooming.util.GameUtil.InputStatus;
import javablooming.util.GameUtil.RacingResult;
import org.junit.jupiter.api.Test;

class GamePlayTest {

  @Test
  void tryInputMoveCountValid() {
    // given
    GamePlay game = new GamePlay();
    setSystemInput("5");

    // when
    InputStatus result = game.tryInputMoveCount();

    // then
    assertThat(result).isEqualTo(SUCCEED);
    assertThat(game.getMoveCount()).isEqualTo(5);
  }

  @Test
  void tryInputMoveCountInValid() {
    // given
    GamePlay game = new GamePlay();
    setSystemInput("abc");

    // when
    InputStatus result = game.tryInputMoveCount();

    // then
    assertThat(result).isEqualTo(FAIL);
  }

  @Test
  void castCarNameListValid() {
    // given
    GamePlay game = new GamePlay();
    List<Car> cars = List.of(
        new Car("a"),
        new Car("bc"),
        new Car("def"));

    // when
    List<String> result = game.castCarNameList(cars);

    // then
    assertThat(result).contains("a");
    assertThat(result).contains("bc");
    assertThat(result).contains("def");
  }

  @Test
  void getFirstCarListSingleResult() {
    // given
    GamePlay game = new GamePlay();
    Car a = addCar(game, "a", 3);
    Car b = addCar(game, "b", 5);
    Car c = addCar(game, "c", 8);
    Car d = addCar(game, "d", 1);
    Car e = addCar(game, "e", 5);

    // when
    List<Car> firstCarList = game.getFirstCarList();

    // then
    assertThat(firstCarList).contains(c);
  }

  @Test
  void getFirstCarListMultiResult() {
    // given
    GamePlay game = new GamePlay();
    Car a = addCar(game, "a", 3);
    Car b = addCar(game, "b", 5);
    Car c = addCar(game, "c", 8);
    Car d = addCar(game, "d", 1);
    Car e = addCar(game, "e", 8);

    // when
    List<Car> firstCarList = game.getFirstCarList();

    // then
    assertThat(firstCarList).contains(c);
    assertThat(firstCarList).contains(e);
  }

  private Car addCar(GamePlay game, String carName, int moveForwardCount) {
    Car car = new Car(carName);
    for (int i = 0; i < moveForwardCount; i++) {
      car.moveForward();
    }
    game.playerCars.add(car);
    return car;
  }

  @Test
  void castCarsNameValid() {
    // given
    GamePlay game = new GamePlay();
    List<String> carNameList = List.of("carA", "carB", "carC", "carD");

    // when
    String result = game.castCarsName(carNameList);

    // then
    assertThat(result).isEqualTo("carA, carB, carC, carD");
  }

  @Test
  void getRacingResultWhen1() {
    // given
    GamePlay game = new GamePlay();

    // when
    RacingResult result = game.getRacingResult(1);

    // then
    assertThat(result).isEqualTo(STAY);
  }

  @Test
  void getRacingResultWhen2() {
    // given
    GamePlay game = new GamePlay();

    // when
    RacingResult result = game.getRacingResult(2);

    // then
    assertThat(result).isEqualTo(STAY);
  }

  @Test
  void getRacingResultWhen3() {
    // given
    GamePlay game = new GamePlay();

    // when
    RacingResult result = game.getRacingResult(3);

    // then
    assertThat(result).isEqualTo(STAY);
  }

  @Test
  void getRacingResultWhen4() {
    // given
    GamePlay game = new GamePlay();

    // when
    RacingResult result = game.getRacingResult(4);

    // then
    assertThat(result).isEqualTo(FORWARD);
  }

  @Test
  void getRacingResultWhen5() {
    // given
    GamePlay game = new GamePlay();

    // when
    RacingResult result = game.getRacingResult(5);

    // then
    assertThat(result).isEqualTo(FORWARD);
  }

  @Test
  void getRacingResultWhen9() {
    // given
    GamePlay game = new GamePlay();

    // when
    RacingResult result = game.getRacingResult(9);

    // then
    assertThat(result).isEqualTo(FORWARD);
  }

  private void setSystemInput(String data) {
    System.setIn(new ByteArrayInputStream(data.getBytes()));
  }
}