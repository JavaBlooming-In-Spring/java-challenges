package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

  @Test
  @DisplayName("지정한 로또 번호 확인")
  public void correctLottoNumber() {
    //given
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

    //when
    List<Integer> lottoNumbers = lotto.getNumbers();

    //then
    assertThat(lottoNumbers.size()).isEqualTo(6);
    assertThat(lottoNumbers).contains(1, 2, 3, 4, 5, 6);
  }

}
