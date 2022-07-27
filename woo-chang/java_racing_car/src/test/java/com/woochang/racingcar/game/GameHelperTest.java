package com.woochang.racingcar.game;

import static org.assertj.core.api.Assertions.*;

import com.woochang.racingcar.domain.Car;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameHelperTest {

  private void setSystemInput(String data) {
    ByteArrayInputStream userInputStream = new ByteArrayInputStream(data.getBytes());
    GameInput.scanner = new Scanner(userInputStream);
    System.setIn(userInputStream);
  }

  @Test
  @DisplayName("생성된 자동차 리스트 검증")
  public void generateCars() {
    // given
    String carName1 = "carA";
    String carName2 = "carB";
    String carName3 = "carC";
    String input = carName1 + "," + carName2 + "," + carName3;
    setSystemInput(input);

    // when
    List<Car> cars = GameHelper.generateCars();

    // then
    assertThat(cars.size()).isEqualTo(3);
    assertThat(cars.stream().map(Car::getName).collect(Collectors.toList())).contains(carName1, carName2, carName3);
  }

  @Test
  @DisplayName("생성된 횟수 검증")
  public void generateCount() {
    // given
    String input = "5";
    setSystemInput(input);

    // when
    int result = GameHelper.generateCount();

    // then
    assertThat(result).isEqualTo(Integer.parseInt(input));
  }

  @Test
  @DisplayName("우승자가 1명인 경우 검증")
  public void getWinner() {
    // given
    Car car1 = new Car("carA");
    Car car2 = new Car("carB");
    Car car3 = new Car("carC");

    // when
    car1.goForward();
    car2.goForward();
    car3.goForward();
    car1.goForward();
    List<Car> cars = new ArrayList<>(Arrays.asList(car1, car2, car3));
    List<Car> winner = GameHelper.getWinners(cars, 2);

    // then
    assertThat(winner.size()).isEqualTo(1);
    assertThat(winner).contains(car1);
  }

  @Test
  @DisplayName("우승자가 여러명인 경우 검증")
  public void getWinners() {
    // given
    Car car1 = new Car("carA");
    Car car2 = new Car("carB");
    Car car3 = new Car("carC");

    // when
    car1.goForward();
    car2.goForward();
    car3.goForward();
    car1.goForward();
    car2.goForward();
    List<Car> cars = new ArrayList<>(Arrays.asList(car1, car2, car3));
    List<Car> winner = GameHelper.getWinners(cars, 2);

    // then
    assertThat(winner.size()).isEqualTo(2);
    assertThat(winner).contains(car1, car2);
  }

}
