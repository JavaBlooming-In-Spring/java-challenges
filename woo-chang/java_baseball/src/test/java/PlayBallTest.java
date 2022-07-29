import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayBallTest {

  @Test
  @DisplayName("게임상태 테스트")
  public void getPlayStatus() {
    // given
    PlayBall playBall = new PlayBall();

    // when
    boolean playBallStatus = playBall.isNotStop();

    // then
    Assertions.assertThat(playBallStatus).isEqualTo(true);
  }
}
