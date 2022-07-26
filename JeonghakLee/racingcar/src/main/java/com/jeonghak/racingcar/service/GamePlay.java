package com.jeonghak.racingcar.service;

import static com.jeonghak.racingcar.service.GameInput.inputCarNames;
import static com.jeonghak.racingcar.service.GameInput.inputClose;
import static com.jeonghak.racingcar.service.GameInput.inputNumberOfAttempts;
import static com.jeonghak.racingcar.util.GameUtil.isPossibleToMove;
import static com.jeonghak.racingcar.util.GameUtil.printMessage;

import com.jeonghak.racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;

public class GamePlay {

  private List<Car> cars = new ArrayList<>();
  private int numberOfAttempts;

  public void init() {
    printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String[] carNames = inputCarNames();
    generateCars(carNames);
    printMessage("시도할 횟수는 몇회인가요?");
    numberOfAttempts = inputNumberOfAttempts();
    inputClose();
  }

  public void play() {
    for (int i = 0; i < numberOfAttempts; i++) {
      raceEachCar();
      printEachRaceResult();
    }
  }


  private void raceEachCar() {
    for (Car car : cars) {
      if (isPossibleToMove()) {
        car.moveForward();
      }
    }
  }

  private void printEachRaceResult() {
    for (Car car : cars) {
      System.out.println(car.getName() + " : "+ "-".repeat(car.getNumberOfMovesForward()));
    }
    System.out.println();
  }

  public List<String> getNamesOfWinners() {
    List<String> namesOfWinners = new ArrayList<>();
    int maxNumberOfMovesForward = getMaxNumberOfMovesForward();
    for (Car car : cars) {
      if (car.getNumberOfMovesForward() == maxNumberOfMovesForward) {
        namesOfWinners.add(car.getName());
      }
    }
    return namesOfWinners;
  }

  private int getMaxNumberOfMovesForward() {
    int maxNumberOfMovesForward = 0;
    for (Car car : cars) {
      if (maxNumberOfMovesForward < car.getNumberOfMovesForward()) {
        maxNumberOfMovesForward = car.getNumberOfMovesForward();
      }
    }
    return maxNumberOfMovesForward;
  }

  private void generateCars(String[] carNames) {
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
  }

  // 테스트에서 밖에 사용되지 않고 이거 하나 때문에 불변성 깨짐
 public void setCars(List<Car> cars){
   this.cars = cars;
 }
}
