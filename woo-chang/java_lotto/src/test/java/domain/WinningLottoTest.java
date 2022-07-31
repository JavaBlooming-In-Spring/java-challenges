package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

  @Test
  @DisplayName("알맞은 랭크 반환하는지 검증")
  public void correctRankReturn() {
    //given
    Lotto userLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    Lotto lastWeekLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
    WinningLotto winningLotto = new WinningLotto(lastWeekLotto, 10);

    //when
    Rank result = winningLotto.match(userLotto);

    //then
    assertThat(result).isEqualTo(Rank.FIFTH);
  }

}
