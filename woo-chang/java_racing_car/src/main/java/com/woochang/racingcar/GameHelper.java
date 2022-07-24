package com.woochang.racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameHelper {

  public static void initGame(User user) {
    List<Car> cars = generateCars();
    int count = generateCount();
    user.setCars(cars);
    user.setCount(count);
  }

  private static List<Car> generateCars() {
    GameOutput.printForCarsName();
    List<String> carsNames = getCarsName();
    return carsNames.stream().map(Car::new).collect(Collectors.toList());
  }

  private static List<String> getCarsName() {
    String input;
    List<String> carNames;
    do {
      input = GameInput.nextLine();
      carNames = GameInput.parseCars(input);
    } while(!(GameValidation.verifyCars(carNames)));
    return carNames;
  }


  private static int generateCount() {
    GameOutput.printForCount();
    return getCount();
  }

  private static int getCount() {
    String input;
    do {
      input = GameInput.nextLine();
    } while(!(GameValidation.verifyCount(input)));
    return Integer.parseInt(input);
  }

  public static void racingStart(User user) {
    GameOutput.printForExecuteTitle();
    for(int i = 0; i < user.getCount(); i++) {
      executeRacing(user.getCars());
      System.out.println();
    }
  }

  private static void executeRacing(List<Car> cars) {
    for(Car car : cars) {
      driveCar(car);
    }
  }

  private static void driveCar(Car car) {
    if(RandomSystem.canGoForward()) {
      car.goForward();
    }
    GameOutput.printForExecuteResult(car);
  }

  public static void gameEnd(List<Car> cars) {
    int maxPosition = getMaxPosition(cars);
    List<Car> result = cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    GameOutput.printForResult(result);
    GameInput.close();
  }

  private static int getMaxPosition(List<Car> cars) {
    int max = 0;
    for(Car car : cars) {
      if(car.getPosition() > max) max = car.getPosition();
    }
    return max;
  }

}
