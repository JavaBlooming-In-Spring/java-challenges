package lotto.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class GameInputTest {

  @Test
  void inputPurchaseAmountOnce() {
    //given
    GameInput gameInput = getGameInput("8000");

    //when
    gameInput.inputPurchaseAmount();

    //then
    assertThat(gameInput.purchaseAmount).isEqualTo(8000);
  }

  @Test
  void inputPurchaseAmountTwice() {
    //given
    GameInput gameInput = getGameInput("-100\r\n8000");

    //when
    gameInput.inputPurchaseAmount();

    //then
    assertThat(gameInput.purchaseAmount).isEqualTo(8000);
  }

  @Test
  void inputPurchaseAmountThreeTimes() {
    //given
    GameInput gameInput = getGameInput("-100\r\n500\r\n8000");

    //when
    gameInput.inputPurchaseAmount();

    //then
    assertThat(gameInput.purchaseAmount).isEqualTo(8000);
  }

  @Test
  void inputWinningLottoOnce() {
    //given
    GameInput gameInput = getGameInput("1,2,3,4,5,6\r\n38");

    //when
    gameInput.inputWinningLotto();

    //then
    assertThat(gameInput.winningLotto.getNumbers()).containsAll(List.of(1, 2, 3, 4, 5, 6));
    assertThat(gameInput.winningBonus).isEqualTo(38);
  }

  private GameInput getGameInput(String playerInput) {
    GameInput gameInput = new GameInput();
    setSystemInput(playerInput, gameInput);
    return gameInput;
  }

  @Test
  void inputWinningLottoTwice() {
    //given
    GameInput gameInput = getGameInput("-1,2,3,4,5,6\r\n1,2,3,4,5,6\r\n38");

    //when
    gameInput.inputWinningLotto();

    //then
    assertThat(gameInput.winningLotto.getNumbers()).containsAll(List.of(1, 2, 3, 4, 5, 6));
    assertThat(gameInput.winningBonus).isEqualTo(38);
  }

  @Test
  void inputWinningLottoThreeTimes() {
    //given
    GameInput gameInput = getGameInput("1,2,3\r\na,b,c,d,e,f\r\n1,2,3,4,5,6\r\n38");

    //when
    gameInput.inputWinningLotto();

    //then
    assertThat(gameInput.winningLotto.getNumbers()).containsAll(List.of(1, 2, 3, 4, 5, 6));
    assertThat(gameInput.winningBonus).isEqualTo(38);
  }

  @Test
  void getPlayerInputNumbers() {
    //given
    GameInput gameInput = getGameInput("1,2,3,4,5,6");

    //when
    Integer[] result = gameInput.getPlayerInputNumbers();

    //then
    assertThat(result).containsAll(List.of(1, 2, 3, 4, 5, 6));
  }

  @Test
  void getPlayerInputNumbersFailedByNotNumeric() {
    GameInput gameInput = getGameInput("1,2,a,4,b,6");

    assertThrows(NumberFormatException.class, gameInput::getPlayerInputNumbers);
  }

  private void setSystemInput(String data, GameInput gameInput) {
    ByteArrayInputStream userInputStream = new ByteArrayInputStream(data.getBytes());
    gameInput.scanner = new Scanner(userInputStream);
    System.setIn(userInputStream);
  }
}