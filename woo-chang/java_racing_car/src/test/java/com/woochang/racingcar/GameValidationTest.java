package com.woochang.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameValidationTest {

  @Test
  @DisplayName("올바르지 않은 형식의 자동차 이름 입력(길이 0)")
  public void inputInvalidLessCarName() {
    //given
    String input = "pobi,crong,,honux";
    List<String> cars = GameInput.parseCars(input);

    //when
    boolean result = GameValidation.verifyCars(cars);

    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  @DisplayName("올바르지 않은 형식의 자동차 이름 입력(길이 5 초과)")
  public void inputInvalidOverCarName() {
    //given
    String input = "pobi,crong,honux,woowahanpobi";
    List<String> cars = GameInput.parseCars(input);

    //when
    boolean result = GameValidation.verifyCars(cars);

    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  @DisplayName("올바른 형식의 자동차 이름 입력")
  public void inputValidCarName() {
    //given
    String input = "pobi,crong,honux";
    List<String> cars = GameInput.parseCars(input);

    //when
    boolean result = GameValidation.verifyCars(cars);

    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  @DisplayName("올바르지 않은 형식의 횟수 입력")
  public void inputInvalidCount() {
    //given
    String input = "a1";

    //when
    boolean result = GameValidation.verifyCount(input);

    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  @DisplayName("올바른 형식의 횟수 입력")
  public void inputValidCount() {
    //given
    String input = "1230";

    //when
    boolean result = GameValidation.verifyCount(input);

    //then
    assertThat(result).isEqualTo(true);
  }

}
