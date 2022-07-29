package com.jeonghak.racingcar.domain;

public class Car {

  private final String name;
  private int numberOfMovesForward;

  public Car(String name) {
    this.name = name;
  }

  public void moveForward() {
    numberOfMovesForward++;
  }

  public String getName() {
    return name;
  }

  public int getNumberOfMovesForward() {
    return numberOfMovesForward;
  }
}
