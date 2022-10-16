import static org.assertj.core.api.Assertions.*;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

  @Test
  @DisplayName("지난 주 로또 번호 생성 검증")
  public void generateLastWeekLotto() {
    //given
    String input = "2,5,6,8,10,21";

    //when
    Lotto result = LottoGenerator.loadingLastWeekLotto(input);

    //then
    assertThat(result.getNumbers().size()).isEqualTo(6);
    assertThat(result.getNumbers()).contains(2, 5, 6, 8, 10, 21);
  }
}
