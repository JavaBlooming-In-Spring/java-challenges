package lotto.service;

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
      throw new IllegalArgumentException("돈은 음수가 될 수 없습니다.");
    }
  }

  static void checkEnoughMoney(long input) {
    if (input < LOTTO_PRICE) {
      throw new IllegalArgumentException("구매할 돈이 부족이 부족합니다.");
    }
  }

  static void checkValidLottoNumbers(List<Integer> lottoNumbers) {
    checkValidLottoNumbersLength(lottoNumbers);
    checkValidLottoNumbersRange(lottoNumbers);
    checkHasDuplicateNumbers(lottoNumbers);
  }

  static void checkValidLottoNumbersLength(List<Integer> lottoNumbers) {
    if (lottoNumbers.size() != LENGTH_OF_LOTTO_NUMBERS) {
      throw new IllegalArgumentException("로또는 6개의 숫자가 필요합니다.");
    }
  }

  static void checkHasDuplicateNumbers(List<Integer> lottoNumbers) {
    Set<Integer> numberSet = new HashSet<>(lottoNumbers);
    if (lottoNumbers.size() != numberSet.size()) {
      throw new IllegalArgumentException("로또 숫자는 서로 중복될 수 없습니다.");
    }
  }

  static void checkValidLottoNumbersRange(List<Integer> lottoNumbers) {
    for (Integer number : lottoNumbers) {
      checkValidEachNumberRange(number);
    }
  }

  static void checkValidEachNumberRange(int number) {
    if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException("로또 숫자 범위는 1~45입니다.");
    }
  }

  static void checkValidBonusNumber(List<Integer> winningLottoNumbers, int bonusNumber) {
    checkWinningLottoNumbersContainBonusNumber(winningLottoNumbers, bonusNumber);
    checkValidBonusNumberRange(bonusNumber);
  }

  static void checkWinningLottoNumbersContainBonusNumber(List<Integer> winningLottoNumbers,
      int bonusNumber) {
    if (winningLottoNumbers.contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스볼은 당첨 로또 번호 6개 숫자와 중복될 수 없습니다.");
    }
  }

  static void checkValidBonusNumberRange(int bonusNumber) {
    if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException("로또 숫자 범위가 아닙니다.");
    }
  }
}
