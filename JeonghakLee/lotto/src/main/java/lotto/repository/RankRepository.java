package lotto.repository;


import static java.util.stream.Collectors.groupingBy;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.domain.Rank;

public class RankRepository {

  private static final RankRepository rankRepository = new RankRepository();
  private static final Map<Integer, List<Rank>> rankMap = Arrays.stream(Rank.values())
      .collect(groupingBy(Rank::getMatchedNumbers));
  public static final List<Rank> RANKLIST = new ArrayList<>(
      Arrays.asList(Rank.values()));

  private void rankRepository() {

  }

  public static RankRepository getRankRepository() {
    return rankRepository;
  }

  public static Optional<Rank> getRank(int matchedNumbers, boolean hasBonus) {
    if (!rankMap.containsKey(matchedNumbers)) {
      return Optional.empty();
    }
    List<Rank> rank = rankMap.get(matchedNumbers);
    if (rank.size() == 1) {
      return Optional.of(rank.get(0));
    }
    return Optional.of(getRankByBonusNumber(hasBonus));
  }

  private static Rank getRankByBonusNumber(boolean hasBonus) {
    if (hasBonus) {
      return SECOND;
    }
    return THIRD;
  }
}
