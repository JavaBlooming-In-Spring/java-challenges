package lotto.repository;

import static lotto.domain.Rank.FIFTH_PLACE;
import static lotto.domain.Rank.FIRST_PLACE;
import static lotto.domain.Rank.FOURTH_PLACE;
import static lotto.domain.Rank.SECOND_PLACE;
import static lotto.domain.Rank.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.Set;
import lotto.domain.Match;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

class RankRepositoryTest {

  RankRepository rankRepository = RankRepository.getRankRepository();

  @Test
  void getRankRepository() {
    RankRepository result = RankRepository.getRankRepository();
    assertThat(result).isNotNull();
  }

  @Test
  void findByMatchCountFirstPlace() {
    testfindRank(6, FIRST_PLACE);
  }

  @Test
  void findByMatchCountSecondPlace() {
    testfindRank(5, true, SECOND_PLACE);
  }

  @Test
  void findByMatchCountThirdPlace() {
    testfindRank(5, false, THIRD_PLACE);
  }

  @Test
  void findByMatchCountFourthPlace() {
    testfindRank(4, FOURTH_PLACE);
  }

  @Test
  void findByMatchCountFifthPlace() {
    testfindRank(3, FIFTH_PLACE);
  }

  @Test
  void findByMatchCountNoRankByMatchCount0() {
    testfindNoRank(0);
  }

  @Test
  void findByMatchCountNoRankByMatchCount1() {
    testfindNoRank(1);
  }

  @Test
  void findByMatchCountNoRankByMatchCount2() {
    testfindNoRank(2);
  }

  private void testfindRank(int matchCount, Rank resultRank) {
    testfindRank(matchCount, true, resultRank);
    testfindRank(matchCount, false, resultRank);
  }

  private void testfindRank(int matchCount, boolean isBonusMatch, Rank resultRank) {
    Optional<Rank> rank = rankRepository.findByMatchCount(matchCount, isBonusMatch);
    assertThat(rank).isPresent();
    assertThat(rank.get()).isEqualTo(resultRank);
  }

  private void testfindNoRank(int matchCount) {
    testfindNoRank(matchCount, true);
    testfindNoRank(matchCount, false);
  }

  private void testfindNoRank(int matchCount, boolean isBonusMatch) {
    Optional<Rank> rank = rankRepository.findByMatchCount(matchCount, isBonusMatch);
    assertThat(rank.isPresent()).isFalse();
  }

  @Test
  void findAllRank() {
    //given
    //when
    Set<Rank> allRank = rankRepository.findAllRank();

    //then
    for (Rank rank : Rank.values()) {
      assertThat(allRank).contains(rank);
    }
  }

  @Test
  void findByRankFirstPlace() {
    testFindByRank(FIRST_PLACE, 6);
  }

  @Test
  void findByRankSecondPlace() {
    testFindByRank(SECOND_PLACE, 5, true);
  }

  @Test
  void findByRankThirdPlace() {
    testFindByRank(THIRD_PLACE, 5, false);
  }

  @Test
  void findByRankFourthPlace() {
    testFindByRank(FOURTH_PLACE, 4);
  }

  @Test
  void findByRankFifthPlace() {
    testFindByRank(FIFTH_PLACE, 3);
  }

  private void testFindByRank(Rank findRank, int matchCount) {
    Optional<Match> match = rankRepository.findByRank(findRank);
    assertThat(match).isPresent();
    assertThat(match.get().getMatchCount()).isEqualTo(matchCount);
  }

  private void testFindByRank(Rank findRank, int matchCount, boolean isBonusMatch) {
    Optional<Match> match = rankRepository.findByRank(findRank);
    assertThat(match).isPresent();
    assertThat(match.get().getMatchCount()).isEqualTo(matchCount);
    assertThat(match.get().isBonusMatch()).isEqualTo(isBonusMatch);
  }
}