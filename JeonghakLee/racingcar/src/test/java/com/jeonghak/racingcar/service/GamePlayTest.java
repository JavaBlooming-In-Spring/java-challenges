package com.jeonghak.racingcar.service;

import static org.assertj.core.api.Assertions.*;

import com.jeonghak.racingcar.domain.Car;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GamePlayTest {

  @Test
  @DisplayName("우승자가 한명일 때 성공")
  void getWinnerTest() {
    // given
    GamePlay game = new GamePlay();
    Car car1 = generateCar("아반떼", 3);
    Car car2 = generateCar("소나타", 5);
    Car car3 = generateCar("그랜져", 7);
    Car car4 = generateCar("제네시스", 7);
    List<Car> cars = List.of(car1, car2, car3, car4);
    game.setCars(cars);
    // when
    List<String> namesOfWinners = game.getNamesOfWinners();
    // then
    assertThat(namesOfWinners).contains("그랜져", "제네시스");
  }

  @Test
  @DisplayName("우승자가 여러명일 때 성공")
  void getWinnersTest() {
    // given
    GamePlay game = new GamePlay();
    Car car1 = generateCar("아반떼", 3);
    Car car2 = generateCar("소나타", 5);
    Car car3 = generateCar("그랜져", 7);
    Car car4 = generateCar("제네시스", 9);
    List<Car> cars = List.of(car1, car2, car3, car4);
    game.setCars(cars);
    // when
    List<String> namesOfWinners = game.getNamesOfWinners();
    // then
    assertThat(namesOfWinners).contains("제네시스");
  }

  private Car generateCar(String carName, int numberOfMoveForward) {
    Car car = new Car(carName);
    for (int i = 0; i < numberOfMoveForward; i++) {
      car.moveForward();
    }
    return car;
  }
}
