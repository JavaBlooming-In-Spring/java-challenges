package java_baseball.java_baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class GameStateTest {
    @Test
    @DisplayName("게임 시작 전 게임 상태")
    public void gaming_set(){
        Game game = new Game();
        boolean gamestate = game.computer.getGameState();
        boolean restartstate = game.computer.getRestartState();

        Assertions.assertThat(gamestate).isEqualTo(true);
        Assertions.assertThat(restartstate).isEqualTo(false);
    }
}
