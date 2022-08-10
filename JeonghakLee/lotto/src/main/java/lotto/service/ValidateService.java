package lotto.service;

import static lotto.service.PrintService.Error.DUPLICATE_BONUS_NUMBER;
import static lotto.service.PrintService.Error.DUPLICATE_LOTTO_NUMBER;
import static lotto.service.PrintService.Error.INVALID_BONUS_RANGE;
import static lotto.service.PrintService.Error.INVALID_LOTTO_LENGTH;
import static lotto.service.PrintService.Error.INVALID_LOTTO_RANGE;
import static lotto.service.PrintService.Error.NEGATIVE_MONEY;
import static lotto.service.PrintService.Error.NOT_ENOUGH_MONEY;
import static lotto.util.LottoUtil.LENGTH_OF_LOTTO_NUMBERS;
import static lotto.util.LottoUtil.LOTTO_PRICE;
import static lotto.util.LottoUtil.MAX_LOTTO_NUMBER;
import static lotto.util.LottoUtil.MIN_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateService {
  public enum Validation {
    VALID,
    INVALID
  }
  static void checkValidMoney(Long input) {
    checkNegative(input);
    checkEnoughMoney(input);
  }

  static void checkNegative(Long input) {
    if (input < 0) {
      throw new IllegalArgumentException(NEGATIVE_MONEY.getMsg());
    }
  }

  static void checkEnoughMoney(long input) {
    if (input < LOTTO_PRICE) {
      throw new IllegalArgumentException(NOT_ENOUGH_MONEY.getMsg());
    }
  }

  static void checkValidLottoNumbers(List<Integer> lottoNumbers) {
    checkValidLottoNumbersLength(lottoNumbers);
    checkValidLottoNumbersRange(lottoNumbers);
    checkHasDuplicateNumbers(lottoNumbers);
  }

  static void checkValidLottoNumbersLength(List<Integer> lottoNumbers) {
    if (lottoNumbers.size() != LENGTH_OF_LOTTO_NUMBERS) {
      throw new IllegalArgumentException(INVALID_LOTTO_LENGTH.getMsg());
    }
  }

  static void checkHasDuplicateNumbers(List<Integer> lottoNumbers) {
    Set<Integer> numberSet = new HashSet<>(lottoNumbers);
    if (lottoNumbers.size() != numberSet.size()) {
      throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMsg());
    }
  }

  static void checkValidLottoNumbersRange(List<Integer> lottoNumbers) {
    for (Integer number : lottoNumbers) {
      checkValidEachNumberRange(number);
    }
  }

  static void checkValidEachNumberRange(int number) {
    if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException(INVALID_LOTTO_RANGE.getMsg());
    }
  }

  static void checkValidBonusNumber(List<Integer> winningLottoNumbers, int bonusNumber) {
    checkWinningLottoNumbersContainBonusNumber(winningLottoNumbers, bonusNumber);
    checkValidBonusNumberRange(bonusNumber);
  }

  static void checkWinningLottoNumbersContainBonusNumber(List<Integer> winningLottoNumbers,
      int bonusNumber) {
    if (winningLottoNumbers.contains(bonusNumber)) {
      throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMsg());
    }
  }

  static void checkValidBonusNumberRange(int bonusNumber) {
    if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException(INVALID_BONUS_RANGE.getMsg());
    }
  }
}
