package lotto.game;

import static lotto.game.GamePlay.LOTTO_PRICE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.game.GamePrint.Error;

public class GameValidate {

  public static final Integer VALID_LOTTO_LENGTH = 6;
  public static final Integer MIN_LOTTO_NUM = 1;
  public static final Integer MAX_LOTTO_NUM = 45;

  public static void checkNegativePrice(Long purchaseAmount) {
    if (purchaseAmount < 0) {
      throw new IllegalArgumentException(Error.NEGATIVE_PRICE.getMsg());
    }
  }

  public static void checkNoMoney(Long purchaseAmount) {
    if (purchaseAmount < LOTTO_PRICE) {
      throw new IllegalArgumentException(Error.NO_MONEY.getMsg());
    }
  }

  public static void checkLottoLength(Integer[] playerInputNumbers) {
    if (playerInputNumbers.length != VALID_LOTTO_LENGTH) {
      throw new IllegalArgumentException(Error.INVALID_LOTTO_LENGTH.getMsg());
    }
  }

  public static void checkLottoDuplicate(Integer[] playerInputNumbers) {
    Set<Integer> duplicateCheckSet = new HashSet<>(List.of(playerInputNumbers));
    if (duplicateCheckSet.size() != VALID_LOTTO_LENGTH) {
      throw new IllegalArgumentException(Error.DUPLICATE_LOTTO_NUMBER.getMsg());
    }
  }

  public static void checkLottoOutOfRange(Integer[] playerInputNumbers) {
    if (isAnyOutOfRange(playerInputNumbers)) {
      throw new IllegalArgumentException(Error.INVALID_LOTTO_RANGE.getMsg());
    }
  }

  private static boolean isAnyOutOfRange(Integer[] playerInputNumbers) {
    return Arrays.stream(playerInputNumbers)
        .anyMatch(GameValidate::isOutOfRange);
  }

  private static boolean isOutOfRange(Integer playerInputNumber) {
    return MIN_LOTTO_NUM > playerInputNumber || playerInputNumber > MAX_LOTTO_NUM;
  }

  public static void checkBonusDuplicate(Lotto winningLotto, Integer bonusNumber) {
    Set<Integer> duplicateCheckSet = new HashSet<>(winningLotto.getNumbers());
    duplicateCheckSet.add(bonusNumber);
    if (duplicateCheckSet.size() != VALID_LOTTO_LENGTH + 1) {
      throw new IllegalArgumentException(Error.DUPLICATE_BONUS_NUMBER.getMsg());
    }
  }

  public static void checkBonusOutOfRange(Integer bonusNumber) {
    if (isOutOfRange(bonusNumber)) {
      throw new IllegalArgumentException(Error.INVALID_BONUS_RANGE.getMsg());
    }
  }

  public enum Valid {
    VALID,
    INVALID
  }
}
