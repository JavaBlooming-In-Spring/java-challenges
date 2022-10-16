package lotto.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GamePlayTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  public void setUpOutputStream() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreOutputStream() {
    System.setOut(originalOut);
  }

  @Test
  void result() {
    //given
    GamePlay gamePlay = new GamePlay();
    gamePlay.winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
    gamePlay.purchaseLottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
    gamePlay.purchaseLottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
    gamePlay.purchaseLottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 10))); // 3등
    gamePlay.purchaseLottoList.add(new Lotto(List.of(1, 2, 3, 4, 10, 20))); // 4등
    gamePlay.purchaseLottoList.add(new Lotto(List.of(1, 2, 3, 10, 20, 30))); // 5등
    gamePlay.purchaseLottoList.add(new Lotto(List.of(1, 2, 40, 10, 20, 30))); // 꽝
    gamePlay.purchaseLottoList.add(new Lotto(List.of(1, 41, 40, 10, 20, 30))); // 꽝
    gamePlay.purchaseLottoList.add(new Lotto(List.of(42, 41, 40, 10, 20, 30))); // 꽝

    //when
    gamePlay.result();

    //then
    String resultOutput = "당첨 통계\n"
        + "---------\n"
        + "3개 일치 (5000원)-1개\n"
        + "4개 일치 (50000원)-1개\n"
        + "5개 일치 (1500000원)-1개\n"
        + "5개 일치 (30000000원)-1개\n"
        + "6개 일치 (2000000000원)-1개\n"
        + "총 수익률은 253944.375입니다.\n";
    assertThat(resultOutput).isEqualTo(outContent.toString());
  }
}