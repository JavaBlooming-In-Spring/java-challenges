import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoInputTest {

  private void setSystemInput(String data) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
    LottoInput.SCAN = new Scanner(inputStream);
    System.setIn(inputStream);
  }

  @Test
  @DisplayName("입력에 대한 올바른 반환")
  public void inputTest() {
    //given
    String input = "lotto";

    //when
    setSystemInput(input);
    String result = LottoInput.getInput();

    //then
    assertThat(input).isEqualTo(result);
  }

  @Test
  @DisplayName("로또 번호에 대한 파싱 결과")
  public void parseInput() {
    //given
    String input = "1,2,3,4,5,6";

    //when
    List<Integer> numbers = LottoInput.parseInput(input);

    //then
    assertThat(numbers.size()).isEqualTo(6);
    assertThat(numbers).contains(1, 2, 3, 4, 5, 6);
  }

}
