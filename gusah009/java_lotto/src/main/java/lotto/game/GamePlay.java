package lotto.game;

import static lotto.game.GamePrint.printMessage;
import static lotto.game.GamePrint.printPurchaseLottoList;
import static lotto.game.GamePrint.printResult;
import static lotto.game.GameValidate.MAX_LOTTO_NUM;
import static lotto.game.GameValidate.MIN_LOTTO_NUM;
import static lotto.game.GameValidate.VALID_LOTTO_LENGTH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Rank;
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
      purchaseLottoList.add(generateRandomLotto());
    }
  }

  private Lotto generateRandomLotto() {
    List<Integer> availableLottoRange = IntStream.range(MIN_LOTTO_NUM, MAX_LOTTO_NUM)
        .boxed()
        .collect(Collectors.toList());
    Collections.shuffle(availableLottoRange);
    return new Lotto(availableLottoRange.subList(0, VALID_LOTTO_LENGTH));
  }

  private void inputLastWeekWinningLotto(GameInput gameInput) {
    winningLotto = gameInput.inputWinningLotto();
  }

  void result() {
    Result result = getResult();
    printResult(result);
  }

  private Result getResult() {
    Result result = new Result();
    calculateMatchResultAndSet(result);
    calculateRateOfReturnAndSet(result);
    return result;
  }

  private void calculateMatchResultAndSet(Result result) {
    for (Lotto lotto : purchaseLottoList) {
      Optional<Rank> rank = winningLotto.match(lotto);
      rank.ifPresent(result::increaseCount);
    }
  }

  private void calculateRateOfReturnAndSet(Result result) {
    long purchaseAmount = purchaseLottoList.size() * LOTTO_PRICE;
    long totalRevenue = 0;
    for (Rank rank : rankRepository.findAllRank()) {
      totalRevenue += rank.getPrice() * result.getCount(rank);
    }
    double rateOfReturn = ((double) totalRevenue) / purchaseAmount;
    result.setRateOfReturn(rateOfReturn);
  }
}
