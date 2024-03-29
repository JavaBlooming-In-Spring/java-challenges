package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FORTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static lotto.repository.RankRepository.getRank;
import static lotto.repository.RankRepository.getRankRepository;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;
import lotto.repository.RankRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
private final RankRepository rankRepository = getRankRepository();
  @Test
  @DisplayName("1등 반환")
  void rankTest() {
    // given
    int numberOfMatched = 6;
    boolean hasBonus = false;
    // when
    Optional<Rank> rank = getRank(numberOfMatched, hasBonus);
    // then
    assertThat(rank).isEqualTo(Optional.of(FIRST));
  }

  @Test
  @DisplayName("2등 반환")
  void firstTest() {
    // given
    int numberOfMatched = 5;
    boolean hasBonus = true;
    // when
    Optional<Rank> rank = getRank(numberOfMatched, hasBonus);
    // then
    assertThat(rank).isEqualTo(Optional.of(SECOND));
  }

  @Test
  @DisplayName("3등 반환")
  void thirdTest() {
    // given
    int numberOfMatched = 5;
    boolean hasBonus = false;
    // when
    Optional<Rank> rank = getRank(numberOfMatched, hasBonus);
    // then
    assertThat(rank).isEqualTo(Optional.of(THIRD));
  }

  @Test
  @DisplayName("4등 반환")
  void forthTest() {
    // given
    int numberOfMatched = 4;
    boolean hasBonus = false;
    // when
    Optional<Rank> rank = getRank(numberOfMatched, hasBonus);
    // then
    assertThat(rank).isEqualTo(Optional.of(FORTH));
  }

  @Test
  @DisplayName("5등 반환")
  void fifthTest() {
    // given
    int numberOfMatched = 3;
    boolean hasBonus = false;
    // when
    Optional<Rank> rank = getRank(numberOfMatched, hasBonus);
    // then
    assertThat(rank).isEqualTo(Optional.of(FIFTH));
  }

  @Test
  @DisplayName("등수가 없는 경우")
  void noRankTest() {
    // given
    int numberOfMatched = 2;
    boolean hasBonus = false;
    // when
    Optional<Rank> rank = getRank(numberOfMatched, hasBonus);
    // then
    assertThat(rank).isEqualTo(Optional.empty());
  }
}
