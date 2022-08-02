package lotto.service;

import static lotto.domain.Lotto.newInstance;
import static lotto.domain.Rank.RANKLIST;
import static lotto.service.PrintService.printNumberOfPurchasedLotto;
import static lotto.service.PrintService.printWinningStatistics;
import static lotto.service.PrintService.printYield;
import static lotto.util.LottoUtil.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class LottoService {

  private final InputService inputService = new InputService();
  private final List<Lotto> purchasedLotto = new ArrayList<>();
  private final Map<Rank, Integer> winningStatistics = new HashMap<>() {{
    for (Rank rank : RANKLIST) {
      put(rank, 0);
    }
  }};

  public void play() {
    inputService.input();
    long money = inputService.getMoney();
    long numberOfPurchasedLotto = getNumberOfPurchasedLotto(money);
    printNumberOfPurchasedLotto(numberOfPurchasedLotto);
    purchaseLotto(numberOfPurchasedLotto);
    WinningLotto winningLotto = generateWinningLotto();
    setWinningStatistics(winningLotto);
    printWinningStatistics(winningStatistics);
    printYield(calculateYield(money));
    inputService.close();
  }

  private WinningLotto generateWinningLotto() {
    Lotto WinningLotto = new Lotto(inputService.getWinningLottoNumbers());
    return new WinningLotto(WinningLotto, inputService.getBonusBall());
  }

  private void purchaseLotto(long numberOfLotto) {
    for (int i = 0; i < numberOfLotto; i++) {
      purchasedLotto.add(newInstance());
    }
  }

  private long getNumberOfPurchasedLotto(Long price) {
    return price / LOTTO_PRICE;
  }

  private void setWinningStatistics(WinningLotto winningLotto) {
    for (Lotto lotto : purchasedLotto) {
      Rank rank = winningLotto.match(lotto);
      if (rank != null) {
        winningStatistics.put(rank, winningStatistics.get(rank) + 1);
      }
    }
  }

  private double calculateYield(long purchasePrice) {
    long sum = 0;
    for (Rank rank : RANKLIST) {
      int count = winningStatistics.get(rank);
      sum += (long) count * rank.getWinningPrice();
    }
    return Math.round((sum / (double) purchasePrice) * LOTTO_PRICE) / (double)LOTTO_PRICE;
  }
}
