import domain.util.LottoGuide;
import domain.util.LottoValidationResult;
import domain.util.PurchaseValidationResult;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidation {

  public static PurchaseValidationResult validatePurchaseAboutString(String purchase) {
    if (purchase.matches("[^-](.*)\\D(.*)")) {
      LottoOutput.print(PurchaseValidationResult.NOT_64BIT_INTEGER.getErrorMessage());
      return PurchaseValidationResult.NOT_64BIT_INTEGER;
    }
    return PurchaseValidationResult.SUCCESS;
  }

  public static PurchaseValidationResult validatePurchaseAboutNegative(String purchase) {
    if (purchase.matches("-\\d*")) {
      LottoOutput.print(PurchaseValidationResult.NEGATIVE.getErrorMessage());
      return PurchaseValidationResult.NEGATIVE;
    }
    return PurchaseValidationResult.SUCCESS;
  }

  public static PurchaseValidationResult validatePurchaseAboutLargeNumber(String purchase) {
    if (new BigInteger(purchase).compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
      LottoOutput.print(PurchaseValidationResult.MUCH.getErrorMessage());
      return PurchaseValidationResult.MUCH;
    }
    return PurchaseValidationResult.SUCCESS;
  }

  public static PurchaseValidationResult validatePurchaseAboutMinimum(String purchase) {
    if (Integer.parseInt(purchase) < LottoGuide.PURCHASE_MINIMUM.getValue()) {
      LottoOutput.print(PurchaseValidationResult.LACK.getErrorMessage());
      return PurchaseValidationResult.LACK;
    }
    return PurchaseValidationResult.SUCCESS;
  }

  public static LottoValidationResult validateLottoCount(String lotto) {
    List<Integer> lottoNumbers = LottoInput.parseInput(lotto);
    if (lottoNumbers.size() != LottoGuide.COUNT.getValue()) {
      LottoOutput.print(LottoValidationResult.NOT_MATCH_COUNT.getErrorMessage());
      return LottoValidationResult.NOT_MATCH_COUNT;
    }
    return LottoValidationResult.SUCCESS;
  }

  public static LottoValidationResult validateLottoNumbersRange(String lotto) {
    List<Integer> lottoNumbers = LottoInput.parseInput(lotto);
    if (lottoNumbers.stream().anyMatch(LottoValidation::validateLottoNumberRange)) {
      LottoOutput.print(LottoValidationResult.OUT_OF_RANGE.getErrorMessage());
      return LottoValidationResult.OUT_OF_RANGE;
    }
    return LottoValidationResult.SUCCESS;
  }

  private static boolean validateLottoNumberRange(Integer lottoNumber) {
    return lottoNumber < LottoGuide.LOW_NUM.getValue()
        || lottoNumber > LottoGuide.HIGH_NUM.getValue();
  }

  public static LottoValidationResult validateLottoDuplication(String lotto) {
    List<Integer> lottoNumbers = LottoInput.parseInput(lotto);
    Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
    if (lottoSet.size() != LottoGuide.COUNT.getValue()) {
      LottoOutput.print(LottoValidationResult.DUPLICATE.getErrorMessage());
      return LottoValidationResult.DUPLICATE;
    }
    return LottoValidationResult.SUCCESS;
  }

  public static LottoValidationResult validateLottoString(String lotto) {
    if (lotto.replaceAll(",", "").matches("(.*)\\D(.*)")) {
      LottoOutput.print(LottoValidationResult.NOT_32BIT_INTEGER.getErrorMessage());
      return LottoValidationResult.NOT_32BIT_INTEGER;
    }
    return LottoValidationResult.SUCCESS;
  }

  public static LottoValidationResult validateBonusRange(String bonus) {
    if (Integer.parseInt(bonus) < LottoGuide.LOW_NUM.getValue()
        || Integer.parseInt(bonus) > LottoGuide.HIGH_NUM.getValue()) {
      LottoOutput.print(LottoValidationResult.BONUS_OUT_OF_RANGE.getErrorMessage());
      return LottoValidationResult.BONUS_OUT_OF_RANGE;
    }
    return LottoValidationResult.SUCCESS;
  }

  public static LottoValidationResult validateBonusDuplication(String bonus, List<Integer> lottoNumbers) {
    Integer bonusNumber = Integer.parseInt(bonus);
    if (lottoNumbers.contains(bonusNumber)) {
      LottoOutput.print(LottoValidationResult.BONUS_DUPLICATE.getErrorMessage());
      return LottoValidationResult.BONUS_DUPLICATE;
    }
    return LottoValidationResult.SUCCESS;
  }

  public static LottoValidationResult validateBonusString(String bonus) {
    if (bonus.matches("(.*)\\D(.*)")) {
      LottoOutput.print(LottoValidationResult.BONUS_NOT_32BIT_INTEGER.getErrorMessage());
      return LottoValidationResult.BONUS_NOT_32BIT_INTEGER;
    }
    return LottoValidationResult.SUCCESS;
  }
}
