package lotto.service;

import static lotto.service.ValidateService.Validation.INVALID;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import lotto.service.ValidateService.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputServiceTest {

  private final InputService inputService = new InputService();

  @Test
  @DisplayName("정상 구매금액 입력 테스트")
  void InputMoneyTest() {
    // given
    setUserInput("120000");
    // when
    inputService.trySetValidMoney();
    // then
    assertThat(inputService.getMoney()).isEqualTo(120000);
  }

  @Test
  @DisplayName("구매금액 음수 입력 테스트")
  void InputNegativeMoneyTest() {
    // given
    setUserInput("-200");
    // when
    Validation result = inputService.trySetValidMoney();
    // then
    assertThat(result).isEqualTo(INVALID);
  }

  @Test
  @DisplayName("부족한 구매금액 입력 테스트")
  void InputNotEnoughMoneyTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("999".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
    // when
    Validation result = inputService.trySetValidMoney();
    // then
    assertThat(result).isEqualTo(INVALID);
  }

  @Test
  @DisplayName("정상 당첨번호 입력 테스트")
  void InputWinningLottoTest() {
    // given
    setUserInput("1,7,11,21,34,45");
    // when
    inputService.trySetWinningLottoNumbers();
    // then
    assertThat(inputService.getWinningLottoNumbers()).contains(1, 7, 11, 21, 34, 45);
  }

  @Test
  @DisplayName("정상로또 개수보다 많은 당첨번호 입력 테스트")
  void InputMoreLengthWinningLottoTest() {
    // given
    setUserInput("1,7,11,16,21,34,45");
    // when
    Validation result = inputService.trySetWinningLottoNumbers();
    // then
    assertThat(result).isEqualTo(INVALID);
  }

  @Test
  @DisplayName("정상로또 개수보다 적은 당첨번호 입력 테스트")
  void InputLessLengthWinningLottoTest() {
    // given
    setUserInput("1,7,11,16");
    // when
    Validation result = inputService.trySetWinningLottoNumbers();
    // then
    assertThat(result).isEqualTo(INVALID);
  }

  @Test
  @DisplayName("정상로또 개수보다 적은 당첨번호 입력 테스트")
  void InputDuplicateWinningLottoTest() {
    // given
    setUserInput("1,7,7,11,16,45");
    // when
    Validation result = inputService.trySetWinningLottoNumbers();
    // then
    assertThat(result).isEqualTo(INVALID);
  }

  @Test
  @DisplayName("로또 숫자 범위가 아닌 당첨번호 입력 테스트")
  void InputInvalidNumberRangeWinningLottoTest() {
    // given
    setUserInput("66,7,11,16,45,22");
    // when
    Validation result = inputService.trySetWinningLottoNumbers();
    // then
    assertThat(result).isEqualTo(INVALID);
  }

  @Test
  @DisplayName("보너스 볼 정상 입력 테스트")
  void InputBonusBallTest() {
    // given
    setUserInput("35");
    List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    // when
    inputService.trySetBonusBall(winningLottoNumbers);
    // then
    assertThat(inputService.getBonusBall()).isEqualTo(35);
  }

  @Test
  @DisplayName("로또 숫자 범위가 아닌 보너스볼 입력 테스트")
  void InputInvalidInputBonusBallTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("46".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
    List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    // when
    Validation result = inputService.trySetBonusBall(winningLottoNumbers);
    // then
    assertThat(result).isEqualTo(INVALID);
  }

  @Test
  @DisplayName("당첨 번호에 포함되는 보너스 볼 입력 테스트")
  void InputWinningLottoNumbersContainBonusBallTest() {
    // given
    setUserInput("6");
    List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    // when
    Validation result = inputService.trySetBonusBall(winningLottoNumbers);
    // then
    assertThat(result).isEqualTo(INVALID);
  }

  private void setUserInput(String input) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
  }
}