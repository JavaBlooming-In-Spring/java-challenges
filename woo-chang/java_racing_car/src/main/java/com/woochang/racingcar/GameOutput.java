package com.woochang.racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameOutput {

  public static void printForCarsName() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }

  public static void printForCount() {
    System.out.println("시도할 회수는 몇회인가요?");
  }

  public static void printForInvalidInput() {
    System.out.println("유효하지 않은 입력입니다. 재입력 입력하세요.");
  }

  public static void printForExecuteTitle() {
    System.out.println();
    System.out.println("실행결과");
  }

  public static void printForExecuteResult(Car car) {
    System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
  }

  public static void printForResult(List<Car> cars) {
    List<String> carNames = cars.stream().map(Car::getName).collect(Collectors.toList());
    System.out.println(String.join(", ", carNames) + "가 최종 우승했습니다.");
  }

}
