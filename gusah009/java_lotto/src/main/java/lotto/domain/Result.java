package lotto.domain;

import static lotto.game.GamePlay.LOTTO_PRICE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.repository.RankRepository;

public class Result {

  private static final RankRepository rankRepository = RankRepository.getRankRepository();
  private final Map<Rank, Integer> result = new HashMap<>();
  private double rateOfReturn;

  public Result(List<Lotto> purchaseLottoList, WinningLotto winningLotto) {
    for (Rank rank : rankRepository.findAllRank()) {
      result.put(rank, 0);
    }
    calculateMatchResultAndSet(purchaseLottoList, winningLotto);
    calculateRateOfReturnAndSet(purchaseLottoList);
  }

  private void calculateMatchResultAndSet(List<Lotto> purchaseLottoList,
      WinningLotto winningLotto) {
    for (Lotto lotto : purchaseLottoList) {
      Optional<Rank> rank = winningLotto.match(lotto);
      rank.ifPresent(this::increaseCount);
    }
  }

  private void increaseCount(Rank rank) {
    result.put(rank, getCount(rank) + 1);
  }

  private void calculateRateOfReturnAndSet(List<Lotto> purchaseLottoList) {
    long purchaseAmount = purchaseLottoList.size() * LOTTO_PRICE;
    long totalRevenue = 0;
    for (Rank rank : rankRepository.findAllRank()) {
      totalRevenue += rank.getPrice() * getCount(rank);
    }
    rateOfReturn = ((double) totalRevenue) / purchaseAmount;
  }

  public double getRateOfReturn() {
    return rateOfReturn;
  }

  public Integer getCount(Rank rank) {
    return result.get(rank);
  }
}
