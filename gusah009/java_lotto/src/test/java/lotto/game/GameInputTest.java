package lotto.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class GameInputTest {

  @Test
  void inputPurchaseAmountOnce() {
    //given
    GameInput gameInput = new GameInput();
    String playerInput = "8000";
    setSystemInput(playerInput, gameInput);

    //when
    gameInput.inputPurchaseAmount();

    //then
    assertThat(gameInput.purchaseAmount).isEqualTo(8000);
  }

  @Test
  void inputPurchaseAmountTwice() {
    //given
    GameInput gameInput = new GameInput();
    String playerInput = "-100\r\n8000";
    setSystemInput(playerInput, gameInput);

    //when
    gameInput.inputPurchaseAmount();

    //then
    assertThat(gameInput.purchaseAmount).isEqualTo(8000);
  }

  @Test
  void inputPurchaseAmountThreeTimes() {
    //given
    GameInput gameInput = new GameInput();
    String playerInput = "-100\r\n500\r\n8000";
    setSystemInput(playerInput, gameInput);

    //when
    gameInput.inputPurchaseAmount();

    //then
    assertThat(gameInput.purchaseAmount).isEqualTo(8000);
  }

  @Test
  void inputWinningLottoOnce() {
    //given
    GameInput gameInput = new GameInput();
    String playerInput = "1,2,3,4,5,6\r\n38";
    setSystemInput(playerInput, gameInput);

    //when
    gameInput.inputWinningLotto();

    //then
    assertThat(gameInput.winningLotto.getNumbers()).containsAll(List.of(1, 2, 3, 4, 5, 6));
    assertThat(gameInput.winningBonus).isEqualTo(38);
  }

  @Test
  void inputWinningLottoTwice() {
    //given
    GameInput gameInput = new GameInput();
    String playerInput = "-1,2,3,4,5,6\r\n1,2,3,4,5,6\r\n38";
    setSystemInput(playerInput, gameInput);

    //when
    gameInput.inputWinningLotto();

    //then
    assertThat(gameInput.winningLotto.getNumbers()).containsAll(List.of(1, 2, 3, 4, 5, 6));
    assertThat(gameInput.winningBonus).isEqualTo(38);
  }

  @Test
  void inputWinningLottoThreeTimes() {
    //given
    GameInput gameInput = new GameInput();
    String playerInput = "1,2,3\r\na,b,c,d,e,f\r\n1,2,3,4,5,6\r\n38";
    setSystemInput(playerInput, gameInput);

    //when
    gameInput.inputWinningLotto();

    //then
    assertThat(gameInput.winningLotto.getNumbers()).containsAll(List.of(1, 2, 3, 4, 5, 6));
    assertThat(gameInput.winningBonus).isEqualTo(38);
  }

  @Test
  void getPlayerInputNumbers() {
    //given
    GameInput gameInput = new GameInput();
    String playerInput = "1,2,3,4,5,6";
    setSystemInput(playerInput, gameInput);

    //when
    Integer[] result = gameInput.getPlayerInputNumbers();

    //then
    assertThat(result).containsAll(List.of(1, 2, 3, 4, 5, 6));
  }

  private void setSystemInput(String data, GameInput gameInput) {
    ByteArrayInputStream userInputStream = new ByteArrayInputStream(data.getBytes());
    gameInput.scanner = new Scanner(userInputStream);
    System.setIn(userInputStream);
  }
}