package lotto.repository;

import static lotto.domain.Rank.FIFTH_PLACE;
import static lotto.domain.Rank.FIRST_PLACE;
import static lotto.domain.Rank.FOURTH_PLACE;
import static lotto.domain.Rank.SECOND_PLACE;
import static lotto.domain.Rank.THIRD_PLACE;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import lotto.domain.Match;
import lotto.domain.Rank;

public class RankRepository {

  private static final RankRepository rankRepository = new RankRepository();
  private static final Map<Match, Rank> rankMap = Map.ofEntries(
      new AbstractMap.SimpleEntry<>(new Match(6, false), FIRST_PLACE),
      new AbstractMap.SimpleEntry<>(new Match(6, true), FIRST_PLACE),
      new AbstractMap.SimpleEntry<>(new Match(5, true), SECOND_PLACE),
      new AbstractMap.SimpleEntry<>(new Match(5, false), THIRD_PLACE),
      new AbstractMap.SimpleEntry<>(new Match(4, false), FOURTH_PLACE),
      new AbstractMap.SimpleEntry<>(new Match(4, true), FOURTH_PLACE),
      new AbstractMap.SimpleEntry<>(new Match(3, false), FIFTH_PLACE),
      new AbstractMap.SimpleEntry<>(new Match(3, true), FIFTH_PLACE)
  );

  private RankRepository() {
  }

  public static RankRepository getRankRepository() {
    return rankRepository;
  }

  public Optional<Rank> findByMatchCount(int matchCount, boolean isBonusMatch) {
    return Optional.ofNullable(rankMap.get(new Match(matchCount, isBonusMatch)));
  }

  public Set<Rank> findAllRank() {
    return new TreeSet<>(rankMap.values());
  }

  public Optional<Match> findByRank(Rank rank) {
    for (Entry<Match, Rank> entry : rankMap.entrySet()) {
      if (rank.equals(entry.getValue())) {
        return Optional.ofNullable(entry.getKey());
      }
    }
    return Optional.empty();
  }
}
