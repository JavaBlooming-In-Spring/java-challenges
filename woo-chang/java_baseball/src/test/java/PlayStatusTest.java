import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayStatusTest {

  @Test
  @DisplayName("게임 시작 상태")
  public void isStartStatus() {
    // given
    PlayStatus playStatus = PlayStatus.START;

    // when
    boolean start = playStatus.getStatus();

    // then
    assertThat(start).isEqualTo(true);
  }

  @Test
  @DisplayName("게임 중지 상태")
  public void isStopStatus() {
    // given
    PlayStatus playStatus = PlayStatus.STOP;

    // when
    boolean stop = playStatus.getStatus();

    // then
    assertThat(stop).isEqualTo(false);
  }

}
