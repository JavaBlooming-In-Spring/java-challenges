package lotto.domain;

import static lotto.domain.Lotto.generateLotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

  @Test
  @DisplayName("match Test")
  void matchTest() {
    // given
    WinningLotto winningLotto = new WinningLotto(generateLotto(), 35);
    Lotto userLotto = generateLotto();

    // when
    Rank rank = winningLotto.match(userLotto);

    // then
    System.out.println("winningLotto = " + winningLotto.getLotto().getNumbers());
    System.out.println("userLotto = " + userLotto.getNumbers());
    System.out.println("sameLottoNumbers = " + rank.getMatchedNumbers());
  }
}
