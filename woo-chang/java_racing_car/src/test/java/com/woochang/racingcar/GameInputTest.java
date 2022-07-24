package com.woochang.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameInputTest {

  @Test
  @DisplayName("쉼표로 구분된 연속된 자동차 입력에 대한 파싱")
  public void parseCars() {
    //given
    String input = "pobi,crong,honux,woowahanpobi";

    //when
    List<String> result = GameInput.parseCars(input);

    //then
    assertThat(result.size()).isEqualTo(4);
    assertThat(result).contains("woowahanpobi", "honux", "crong", "pobi");
    assertThat(result).containsExactly("pobi", "crong", "honux", "woowahanpobi");
  }



}
