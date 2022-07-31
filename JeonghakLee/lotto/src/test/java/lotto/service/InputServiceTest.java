package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputServiceTest {

  public static Scanner scanner = new Scanner(System.in);
  private final InputService inputService = new InputService();

  @Test
  @DisplayName("정상 구매금액 입력 테스트")
  void InputMoneyTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("120000".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
    // when
    inputService.trySetValidMoney();
    // then
    assertThat(inputService.getMoney()).isEqualTo(120000);
  }

  @Test
  @DisplayName("구매금액 음수 입력 테스트")
  void InputNegativeMoneyTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("-200".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
    // when
    boolean result = inputService.trySetValidMoney();
    // then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("부족한 구매금액 입력 테스트")
  void InputNotEnoughMoneyTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("999".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
    // when
    boolean result = inputService.trySetValidMoney();
    // then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("정상 당첨번호 입력 테스트")
  void InputWinningLottoTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("1,7,11,21,34,45".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
    // when
    inputService.trySetWinningLottoNumbers();
    // then
    assertThat(inputService.getWinningLottoNumbers()).contains(1, 7, 11, 21, 34, 45);
  }
  @Test
  @DisplayName("정상로또 개수보다 많은 당첨번호 입력 테스트")
  void InputMoreLengthWinningLottoTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("1,7,11,16,21,34,45".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
    // when
    boolean result = inputService.trySetWinningLottoNumbers();
    // then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("정상로또 개수보다 적은 당첨번호 입력 테스트")
  void InputLessLengthWinningLottoTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("1,7,11,16".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
    // when
    boolean result = inputService.trySetWinningLottoNumbers();
    // then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("정상로또 개수보다 적은 당첨번호 입력 테스트")
  void InputDuplicateWinningLottoTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("1,7,7,11,16,45".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
    // when
    boolean result = inputService.trySetWinningLottoNumbers();
    // then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("로또 숫자 범위가 아닌 당첨번호 입력 테스트")
  void InputInvalidNumberRangeWinningLottoTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("66,7,11,16,45,22".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
    // when
    boolean result = inputService.trySetWinningLottoNumbers();
    // then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("보너스 볼 정상 입력 테스트")
  void InputBonusBallTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("35".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
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
    boolean result = inputService.trySetBonusBall(winningLottoNumbers);
    // then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("당첨 번호에 포함되는 보너스 볼 입력 테스트")
  void InputWinningLottoNumbersContainBonusBallTest() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("6".getBytes());
    inputService.scanner = new Scanner(inputStream);
    System.setIn(inputStream);
    List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    // when
    boolean result = inputService.trySetBonusBall(winningLottoNumbers);
    // then
    assertThat(result).isFalse();
  }
}