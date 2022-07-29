package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.repository.RankRepository;

public class Result {

  private static final RankRepository rankRepository = RankRepository.getRankRepository();
  private final Map<Rank, Integer> result = new HashMap<>();
  private double rateOfReturn;

  public Result() {
    for (Rank rank : rankRepository.findAllRank()) {
      result.put(rank, 0);
    }
  }

  public void setRateOfReturn(double rateOfReturn) {
    this.rateOfReturn = rateOfReturn;
  }

  public double getRateOfReturn() {
    return rateOfReturn;
  }

  public void increaseCount(Rank rank) {
    result.put(rank, result.get(rank) + 1);
  }

  public Integer getCount(Rank rank) {
    return result.get(rank);
  }
}
