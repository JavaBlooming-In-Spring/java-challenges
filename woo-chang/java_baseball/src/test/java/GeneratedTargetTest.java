import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneratedTargetTest {

  @Test
  @DisplayName("랜덤한 3자리 숫자 생성")
  public void generateRandomNum() {
    // given
    GeneratedTarget generatedTarget = new GeneratedTarget();

    // when
    String target = generatedTarget.getTarget();

    // then
    assertThat(target.length()).isEqualTo(3);
  }

}
