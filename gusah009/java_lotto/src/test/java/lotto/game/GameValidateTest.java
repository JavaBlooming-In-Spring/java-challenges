package lotto.game;

import static lotto.game.GameValidate.checkNegativePrice;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.Lotto;
import lotto.game.GamePrint.Error;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class GameValidateTest {

  @Test
  void checkNegativePriceFail() {
    //given
    Long purchaseAmount = -1L;

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      checkNegativePrice(purchaseAmount);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.NEGATIVE_PRICE.getMsg());
  }

  @Test
  void checkNoMoney_MoneyIs0() {
    //given
    Long purchaseAmount = 0L;

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkNoMoney(purchaseAmount);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.NO_MONEY.getMsg());
  }

  @Test
  void checkNoMoney_MoneyIs500() {
    //given
    Long purchaseAmount = 500L;

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkNoMoney(purchaseAmount);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.NO_MONEY.getMsg());
  }

  @Test
  void checkNoMoney_MoneyIs999() {
    //given
    Long purchaseAmount = 999L;

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkNoMoney(purchaseAmount);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.NO_MONEY.getMsg());
  }

  @Test
  void checkLottoLengthSuccess() {
    //given
    Integer[] playerInputNumbers = List.of(1, 2, 3, 4, 5, 6)
        .toArray(new Integer[6]);

    //when
    Executable result = () -> GameValidate.checkLottoLength(playerInputNumbers);

    //then
    Assertions.assertDoesNotThrow(result);
  }

  @Test
  void checkLottoLengthFailByLength0() {
    //given
    Integer[] playerInputNumbers = List.of()
        .toArray(new Integer[0]);

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkLottoLength(playerInputNumbers);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.INVALID_LOTTO_LENGTH.getMsg());
  }

  @Test
  void checkLottoLengthFailByLength5() {
    //given
    Integer[] playerInputNumbers = List.of(1, 2, 3, 4, 5)
        .toArray(new Integer[5]);

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkLottoLength(playerInputNumbers);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.INVALID_LOTTO_LENGTH.getMsg());
  }

  @Test
  void checkLottoLengthFailByLength7() {
    //given
    Integer[] playerInputNumbers = List.of(1, 2, 3, 4, 5, 6, 7)
        .toArray(new Integer[7]);

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkLottoLength(playerInputNumbers);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.INVALID_LOTTO_LENGTH.getMsg());
  }

  @Test
  void checkLottoDuplicateSuccess() {
    //given
    Integer[] playerInputNumbers = List.of(1, 2, 3, 4, 5, 6)
        .toArray(new Integer[6]);

    //when
    Executable result = () -> GameValidate.checkLottoDuplicate(playerInputNumbers);

    //then
    Assertions.assertDoesNotThrow(result);
  }

  @Test
  void checkLottoDuplicateFail() {
    //given
    Integer[] playerInputNumbers = List.of(1, 2, 3, 4, 5, 5)
        .toArray(new Integer[6]);

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkLottoDuplicate(playerInputNumbers);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.DUPLICATE_LOTTO_NUMBER.getMsg());
  }

  @Test
  void checkLottoOutOfRangeSuccess() {
    //given
    Integer[] playerInputNumbers = List.of(1, 45, 17, 33, 20, 42)
        .toArray(new Integer[6]);

    //when
    Executable result = () -> GameValidate.checkLottoOutOfRange(playerInputNumbers);

    //then
    Assertions.assertDoesNotThrow(result);
  }

  @Test
  void checkLottoOutOfRangeFailWithLessThan1() {
    //given
    Integer[] playerInputNumbers = List.of(0, 40, 41, 42, 43, 44)
        .toArray(new Integer[6]);

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkLottoOutOfRange(playerInputNumbers);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.INVALID_LOTTO_RANGE.getMsg());
  }

  @Test
  void checkLottoOutOfRangeFailWithMoreThan45() {
    //given
    Integer[] playerInputNumbers = List.of(0, 1, 2, 3, 4, 46)
        .toArray(new Integer[6]);

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkLottoOutOfRange(playerInputNumbers);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.INVALID_LOTTO_RANGE.getMsg());
  }

  @Test
  void checkBonusDuplicateSuccess() {
    //given
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    int bonusNumber = 7;

    //when
    Executable result = () -> GameValidate.checkBonusDuplicate(lotto, bonusNumber);

    //then
    Assertions.assertDoesNotThrow(result);
  }

  @Test
  void checkBonusDuplicateFail() {
    //given
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    int bonusNumber = 5;

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkBonusDuplicate(lotto, bonusNumber);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.DUPLICATE_BONUS_NUMBER.getMsg());
  }

  @Test
  void checkBonusOutOfRangeSuccessBy45() {
    //given
    int bonusNumber = 45;

    //when
    Executable result = () -> GameValidate.checkBonusOutOfRange(bonusNumber);

    //then
    Assertions.assertDoesNotThrow(result);
  }

  @Test
  void checkBonusOutOfRangeSuccessBy1() {
    //given
    int bonusNumber = 1;

    //when
    Executable result = () -> GameValidate.checkBonusOutOfRange(bonusNumber);

    //then
    Assertions.assertDoesNotThrow(result);
  }

  @Test
  void checkBonusOutOfRangeSuccessBy27() {
    //given
    int bonusNumber = 27;

    //when
    Executable result = () -> GameValidate.checkBonusOutOfRange(bonusNumber);

    //then
    Assertions.assertDoesNotThrow(result);
  }

  @Test
  void checkBonusOutOfRangeFailBy0() {
    //given
    int bonusNumber = 0;

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkBonusOutOfRange(bonusNumber);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.INVALID_BONUS_RANGE.getMsg());
  }

  @Test
  void checkBonusOutOfRangeFailBy46() {
    //given
    int bonusNumber = 46;

    //when
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      GameValidate.checkBonusOutOfRange(bonusNumber);
    });

    //then
    assertThat(exception.getMessage()).isEqualTo(Error.INVALID_BONUS_RANGE.getMsg());
  }
}