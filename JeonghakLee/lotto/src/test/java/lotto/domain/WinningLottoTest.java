package lotto.domain;

import static lotto.domain.Lotto.generateLotto;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

public class LottoTest {

  @Test
  public void generateLottoNumbers() {
    // given
    Lotto lotto = generateLotto();
    // when
    System.out.println("lotto = " + lotto.getNumbers());
    // then
  }
}
