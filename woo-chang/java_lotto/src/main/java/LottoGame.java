import domain.Lotto;
import domain.WinningLotto;
import domain.util.LottoGuide;
import domain.util.LottoMessage;
import domain.util.LottoValidationResult;
import domain.util.PurchaseValidationResult;
import domain.Rank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoGame {

  private Long purchaseAmount;
  private List<Lotto> lottos;
  private Lotto lastWeekLotto;
  private int bonus;
  private WinningLotto winningLotto;
  private final Map<Rank, Long> result = new HashMap<>();

  public void start() {
    purchaseLottos();
    loadingLastWeekLotto();
    loadingBonus();
    winningLotto = new WinningLotto(lastWeekLotto, bonus);
  }

  private void purchaseLottos() {
    while (validatePurchase() == PurchaseValidationResult.FAIL)
      ;
    long purchaseNumber = purchaseAmount / LottoGuide.PURCHASE_MINIMUM.getValue();
    lottos = LottoGenerator.generateLottos(purchaseNumber);
    LottoOutput.print(purchaseNumber + "개를 구매했습니다.");
    for (int i = 0; i < purchaseNumber; i++) {
      LottoOutput.print(lottos.get(i).toString());
    }
  }

  private PurchaseValidationResult validatePurchase() {
    LottoOutput.print(LottoMessage.PURCHASE_INPUT.getMessage());
    String input = LottoInput.getInput();
    if (LottoValidation.validatePurchaseAboutString(input) != PurchaseValidationResult.SUCCESS
        || LottoValidation.validatePurchaseAboutNegative(input) != PurchaseValidationResult.SUCCESS
        || LottoValidation.validatePurchaseAboutLargeNumber(input) != PurchaseValidationResult.SUCCESS
        || LottoValidation.validatePurchaseAboutMinimum(input) != PurchaseValidationResult.SUCCESS) {
      return PurchaseValidationResult.FAIL;
    }
    purchaseAmount = Long.parseLong(input);
    return PurchaseValidationResult.SUCCESS;
  }

  private void loadingLastWeekLotto() {
    while (validateLastWeekLotto() == LottoValidationResult.FAIL)
      ;
  }

  private LottoValidationResult validateLastWeekLotto() {
    LottoOutput.print(LottoMessage.LAST_WEEK_WINNING_NUMBER.getMessage());
    String input = LottoInput.getInput();
    if (LottoValidation.validateLottoString(input) != LottoValidationResult.SUCCESS
        || LottoValidation.validateLottoCount(input) != LottoValidationResult.SUCCESS
        || LottoValidation.validateLottoNumbersRange(input) != LottoValidationResult.SUCCESS
        || LottoValidation.validateLottoDuplication(input) != LottoValidationResult.SUCCESS) {
      return LottoValidationResult.FAIL;
    }
    lastWeekLotto = LottoGenerator.loadingLastWeekLotto(input);
    return LottoValidationResult.SUCCESS;
  }

  private void loadingBonus() {
    while (validateBonus() == LottoValidationResult.FAIL)
      ;
  }

  private LottoValidationResult validateBonus() {
    LottoOutput.print(LottoMessage.BONUS_BALL.getMessage());
    String input = LottoInput.getInput();
    if (LottoValidation.validateBonusString(input) != LottoValidationResult.SUCCESS
        || LottoValidation.validateBonusRange(input) != LottoValidationResult.SUCCESS
        || LottoValidation.validateBonusDuplication(input, lastWeekLotto.getNumbers()) != LottoValidationResult.SUCCESS) {
      return LottoValidationResult.FAIL;
    }
    bonus = Integer.parseInt(input);
    return LottoValidationResult.SUCCESS;
  }

  public void end() {
    LottoOutput.print(LottoMessage.WINNING_STATUS.getMessage());
    LottoOutput.print(LottoMessage.LINE.getMessage());
    checkResultsOfWinnings();
    LottoOutput.finalResultPrint(result);
    LottoOutput.print("총 수익률은 " + calculateFinalRate() + "입니다.");
  }

  private void checkResultsOfWinnings() {
    for (Rank rank : Rank.values()) {
      result.put(rank, 0L);
    }
    for (Lotto lotto : lottos) {
      Rank rank = winningLotto.match(lotto);
      result.put(rank, result.get(rank) + 1);
    }
  }

  private String calculateFinalRate() {
    long total = 0L;
    for (Entry<Rank, Long> entry : result.entrySet()) {
      total += entry.getKey().getPrice() * entry.getValue();
    }
    return String.format("%.3f", (double) total / purchaseAmount);
  }

}
