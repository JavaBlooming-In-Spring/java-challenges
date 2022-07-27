package com.woochang.racingcar.domain;

import java.util.List;

public class User {

  private List<Car> cars;
  private int count;

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
