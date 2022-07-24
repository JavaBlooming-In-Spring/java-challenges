import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneratedTargetTest {

  @Test
  @DisplayName("랜덤 수 생성")
  public void generatedTarget() {
    // given
    GeneratedTarget generatedTarget = new GeneratedTarget();

    // when
    List<Integer> target = generatedTarget.getTarget();

    // then
    assertThat(target.size()).isEqualTo(GameUtils.TARGET_LENGTH);
  }

  @Test
  @DisplayName("새로운 랜덤 수 생성")
  public void generateNewTarget() {
    // given
    GeneratedTarget generatedTarget = new GeneratedTarget();

    // when
    generatedTarget.generatedNewTarget();
    List<Integer> target = generatedTarget.getTarget();

    // then
    assertThat(target.size()).isEqualTo(GameUtils.TARGET_LENGTH);
  }


}
