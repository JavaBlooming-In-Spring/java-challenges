package lotto.game;

import static lotto.domain.Lotto.newInstance;
import static lotto.game.GamePrint.printMessage;
import static lotto.game.GamePrint.printPurchaseLottoList;
import static lotto.game.GamePrint.printResult;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.game.GamePrint.Guide;
import lotto.repository.RankRepository;

public class GamePlay {

  public static final Long LOTTO_PRICE = 1000L;
  private static final RankRepository rankRepository = RankRepository.getRankRepository();

  final List<Lotto> purchaseLottoList = new ArrayList<>();
  WinningLotto winningLotto = null;

  public void start() {
    input();
    result();
  }

  private void input() {
    GameInput gameInput = new GameInput();
    purchaseLotto(gameInput);
    inputLastWeekWinningLotto(gameInput);
  }

  private void purchaseLotto(GameInput gameInput) {
    printMessage(Guide.REQUEST_PURCHASE_PRICE);
    setPurchaseLottoList(gameInput);
    printPurchaseLottoList(purchaseLottoList);
  }

  private void setPurchaseLottoList(GameInput gameInput) {
    Long purchaseAmount = gameInput.inputPurchaseAmount();
    long purchaseLottoCount = purchaseAmount / LOTTO_PRICE;
    printMessage(purchaseLottoCount + "개를 구매했습니다.");
    for (int i = 0; i < purchaseLottoCount; i++) {
      purchaseLottoList.add(newInstance());
    }
  }

  private void inputLastWeekWinningLotto(GameInput gameInput) {
    winningLotto = gameInput.inputWinningLotto();
  }

  void result() {
    Result result = new Result(purchaseLottoList, winningLotto);
    printResult(result);
  }
}
