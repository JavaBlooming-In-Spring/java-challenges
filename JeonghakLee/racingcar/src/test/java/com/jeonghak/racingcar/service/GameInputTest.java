package com.jeonghak.racingcar.service;

import static com.jeonghak.racingcar.service.GameInput.isInvalidCarName;
import static com.jeonghak.racingcar.service.GameInput.isPositiveInteger;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameInputTest {

  @Test
  void validCarNameTest() {
    // given
    String[] validCarNames = {"a", "ab", "abc", "abcd", "abcde"};

    for (String validCarName : validCarNames) {
      // when
      boolean isInvalidCarName = isInvalidCarName(validCarName);
      // then
      assertThat(isInvalidCarName).isFalse();
    }
  }

  @Test
  @DisplayName("이름이 공백일 때")
  void invalidCarNameEmptyTest() {
    // given
    String emptyString = "";
    // when
    boolean isInvalid = isInvalidCarName(emptyString);
    // then
    assertThat(isInvalid).isTrue();
  }

  @Test
  @DisplayName("이름의 길이가 초과 되었을 때")
  void invalidCarNameLengthTest() {
    // given
    String[] inValidCarNames = {"abcdef", "abcdefg", "abcdefgh"};
    for (String invalidCarName : inValidCarNames) {
      // when
      boolean isInvalid = isInvalidCarName(invalidCarName);
      // then
      assertThat(isInvalid).isTrue();
    }
  }

  @Test
  @DisplayName("입력이 음의 정수인 경우")
  void inputNegativeIntegerTest() {
    // given
    String invalidInput = "-1";
    // when
    boolean isValid = isPositiveInteger(invalidInput);
    // then
    assertThat(isValid).isFalse();
  }

  @Test
  @DisplayName("입력이 정수가 아닌 경우")
  void InputNotIntegerTest() {
    // given
    String[] invalidInputs = {"woowa", "0.0037"};
    for (String invalidInput : invalidInputs) {
      // when
      boolean isValid = isPositiveInteger(invalidInput);
      // then
      assertThat(isValid).isFalse();
    }
  }
}



