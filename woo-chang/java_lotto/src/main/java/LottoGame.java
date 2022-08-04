import domain.Lotto;
import domain.ValidateResult;
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

  private final ValidateResult validateResult = new ValidateResult();
  private List<Lotto> lottos;
  private WinningLotto winningLotto;
  private final Map<Rank, Long> result = new HashMap<>();

  public void start() {
    purchaseLottos();
    loadingLastWeekLotto();
    loadingBonus();
    winningLotto = new WinningLotto(validateResult.getValidLastWeekLotto(),
        validateResult.getValidBonus());
  }

  private void purchaseLottos() {
    while (LottoValidation.validatePurchase(validateResult) == PurchaseValidationResult.FAIL)
      ;
    long purchaseNumber =
        validateResult.getValidPurchaseAmount() / LottoGuide.PURCHASE_MINIMUM.getValue();
    lottos = LottoGenerator.generateLottos(purchaseNumber);
    LottoOutput.print(purchaseNumber + "개를 구매했습니다.");
    for (int i = 0; i < purchaseNumber; i++) {
      LottoOutput.print(lottos.get(i).toString());
    }
  }

  private void loadingLastWeekLotto() {
    while (LottoValidation.validateLastWeekLotto(validateResult) == LottoValidationResult.FAIL)
      ;
  }

  private void loadingBonus() {
    while (LottoValidation.validateBonus(validateResult) == LottoValidationResult.FAIL)
      ;
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
    return String.format("%.3f", (double) total / validateResult.getValidPurchaseAmount());
  }

}
