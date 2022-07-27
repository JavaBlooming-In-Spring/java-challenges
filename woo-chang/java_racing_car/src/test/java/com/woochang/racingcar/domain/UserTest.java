package com.woochang.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

  @Test
  @DisplayName("경주를 진행하는 자동차 리스트 검증")
  public void getCars() {
    // given
    User user = new User();
    Car car1 = new Car("람보르기니");
    Car car2 = new Car("마세라티");
    Car car3 = new Car("포르쉐");

    // when
    user.setCars(new ArrayList<>(Arrays.asList(car1, car2, car3)));

    // then
    assertThat(user.getCars().size()).isEqualTo(3);
    assertThat(user.getCars()).contains(car1, car2, car3);
  }

  @Test
  @DisplayName("경주를 진행하는 횟수 검증")
  public void getCount() {
    // given
    User user = new User();
    int count = 5;

    // when
    user.setCount(count);

    // then
    assertThat(user.getCount()).isEqualTo(count);
  }

}
