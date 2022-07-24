package com.woochang.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  @Test
  @DisplayName("자동차 생성")
  public void generateCar() {
    //given
    String name = "람보르기니";

    //when
    Car car = new Car(name);

    //then
    assertThat(car.getName()).isEqualTo(name);
  }

  @Test
  @DisplayName("자동차 전진")
  public void goForward() {
    //given
    Car car = new Car("페라리");

    //when
    car.goForward();

    //then
    assertThat(car.getPosition()).isEqualTo(1);
  }

}
