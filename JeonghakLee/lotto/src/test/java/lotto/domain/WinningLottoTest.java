package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FORTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.Arrays;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

  private final Lotto lotto = new Lotto(Arrays.asList(1, 11, 16, 27, 31, 45));
  private final WinningLotto winningLotto = new WinningLotto(lotto, 35);

  @Test
  @DisplayName("1등일 때")
  void matchTest() {
    // given
    Lotto userLotto = new Lotto(Arrays.asList(1, 11, 16, 27, 31, 45));
    // when
    Optional<Rank> rank = winningLotto.match(userLotto);
    // then
    Assertions.assertThat(rank).isEqualTo(Optional.of(FIRST));
  }

  @Test
  @DisplayName("2등일 때")
  void matchFirstTest() {
    // given
    Lotto userLotto = new Lotto(Arrays.asList(1, 11, 16, 27, 31, 35));
    // when
    Optional<Rank> rank = winningLotto.match(userLotto);
    // then
    Assertions.assertThat(rank).isEqualTo(Optional.of(SECOND));
  }

  @Test
  @DisplayName("3등일 때")
  void matchThirdTest() {
    // given
    Lotto userLotto = new Lotto(Arrays.asList(1, 11, 16, 27, 31, 40));
    // when
    Optional<Rank> rank = winningLotto.match(userLotto);
    // then
    Assertions.assertThat(rank).isEqualTo(Optional.of(THIRD));
  }

  @Test
  @DisplayName("4등일 때")
  void matchForthTest() {
    // given
    Lotto userLotto = new Lotto(Arrays.asList(1, 11, 16, 27, 30, 40));
    // when
    Optional<Rank> rank = winningLotto.match(userLotto);
    // then
    Assertions.assertThat(rank).isEqualTo(Optional.of(FORTH));
  }

  @Test
  @DisplayName("5등일 때")
  void matchFifthTest() {
    // given
    Lotto userLotto = new Lotto(Arrays.asList(1, 11, 16, 28, 29, 30));
    // when
    Optional<Rank> rank = winningLotto.match(userLotto);
    // then
    Assertions.assertThat(rank).isEqualTo(Optional.of(FIFTH));
  }

  @Test
  @DisplayName("등수가 없을 때")
  void matchNoRankTest() {
    // given
    Lotto userLotto = new Lotto(Arrays.asList(1, 11, 15, 28, 29, 30));
    // when
    Optional<Rank> rank = winningLotto.match(userLotto);
    // then
    Assertions.assertThat(rank).isEqualTo(Optional.empty());
  }
}
