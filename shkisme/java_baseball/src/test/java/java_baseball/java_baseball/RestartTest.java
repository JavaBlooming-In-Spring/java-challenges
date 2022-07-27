package java_baseball.java_baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static java_baseball.java_baseball.RestartStatus.END;
import static java_baseball.java_baseball.RestartStatus.RESTART;

public class ReStartTest {
    @Test
    public void restartTest(){
        Assertions.assertThat(1).isEqualTo(RESTART.getRestartStatus());
        Assertions.assertThat(2).isEqualTo(END.getRestartStatus());
    }
}