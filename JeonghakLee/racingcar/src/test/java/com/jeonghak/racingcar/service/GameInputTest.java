package com.jeonghak.racingcar.service;

import static com.jeonghak.racingcar.service.GameInput.isInvalidCarName;
import static com.jeonghak.racingcar.service.GameInput.isPositiveInteger;
import static org.assertj.core.api.Assertions.*;
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
  void invalidCarNameTest() {
    // given
    String[] inValidCarNames = {"", "abcdef"};
    for (String invalidCarName : inValidCarNames) {
      // when
      boolean isInvalid = isInvalidCarName(invalidCarName);
      // then
      assertThat(isInvalid).isTrue();
    }
  }

  @Test
  void invalidNumberOfAttempts()
  {
    // given
    String[] invalidInputs = {"-1", "woowa", "0.0037"};
    for(String invalidInput:invalidInputs) {
      // when
      boolean isValid = isPositiveInteger(invalidInput);
      // then
      assertThat(isValid).isFalse();
    }
  }
}



