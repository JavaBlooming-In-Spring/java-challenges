package lotto.game;

import static lotto.game.GamePrint.printMessage;
import static lotto.game.GameValidate.Valid.INVALID;
import static lotto.game.GameValidate.Valid.VALID;
import static lotto.game.GameValidate.checkBonusDuplicate;
import static lotto.game.GameValidate.checkBonusOutOfRange;
import static lotto.game.GameValidate.checkLottoDuplicate;
import static lotto.game.GameValidate.checkLottoLength;
import static lotto.game.GameValidate.checkLottoOutOfRange;
import static lotto.game.GameValidate.checkNegativePrice;
import static lotto.game.GameValidate.checkNoMoney;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.game.GamePrint.Error;
import lotto.game.GamePrint.Guide;
import lotto.game.GameValidate.Valid;

public class GameInput {

  public Scanner scanner = new Scanner(System.in);
  Long purchaseAmount = null;
  Lotto winningLotto = null;
  Integer winningBonus = null;

  public Long inputPurchaseAmount() {
    while (tryInputValidPurchaseAmount() == INVALID)
      ;
    return purchaseAmount;
  }

  private Valid tryInputValidPurchaseAmount() {
    try {
      setValidPurchaseAmount();
      return VALID;
    } catch (NumberFormatException e) {
      printMessage(Error.INVALID_LONG_FORMAT);
    } catch (Exception e) {
      printMessage(e.getMessage());
    }
    return INVALID;
  }

  private void setValidPurchaseAmount() {
    setPurchaseAmount();
    checkNegativePrice(purchaseAmount);
    checkNoMoney(purchaseAmount);
  }

  private void setPurchaseAmount() {
    purchaseAmount = Long.parseLong(scanner.nextLine());
  }

  public WinningLotto inputWinningLotto() {
    printMessage(Guide.REQUEST_WINNING_LOTTO_NUMBERS);
    while (tryInputValidLottoAndSet() == INVALID)
      ;
    printMessage(Guide.REQUEST_BONUS_NUMBER);
    while (tryInputBonusNumberAndSet() == INVALID)
      ;
    return new WinningLotto(winningLotto, winningBonus);
  }


  private Valid tryInputValidLottoAndSet() {
    try {
      setValidLotto();
      return VALID;
    } catch (NumberFormatException e) {
      printMessage(Error.INVALID_INT_FORMAT);
      return INVALID;
    } catch (Exception e) {
      printMessage(e.getMessage());
      return INVALID;
    }
  }

  private void setValidLotto() {
    Integer[] playerInputNumbers = getPlayerInputNumbers();
    checkLottoLength(playerInputNumbers);
    checkLottoDuplicate(playerInputNumbers);
    checkLottoOutOfRange(playerInputNumbers);
    winningLotto = new Lotto(List.of(playerInputNumbers));
  }

  Integer[] getPlayerInputNumbers() {
    String playerInput = getLottoNumbers();
    return Arrays.stream(playerInput.split(","))
        .map(Integer::parseInt)
        .toArray(Integer[]::new);
  }

  private String getLottoNumbers() {
    return scanner.nextLine();
  }

  private Valid tryInputBonusNumberAndSet() {
    try {
      setValidBonusNumber();
      return VALID;
    } catch (NumberFormatException e) {
      printMessage(Error.INVALID_INT_FORMAT);
      return INVALID;
    } catch (Exception e) {
      printMessage(e.getMessage());
      return INVALID;
    }
  }

  private void setValidBonusNumber() {
    Integer bonusNumber = getPlayerInputNumber();
    checkBonusDuplicate(winningLotto, bonusNumber);
    checkBonusOutOfRange(bonusNumber);
    winningBonus = bonusNumber;
  }

  private Integer getPlayerInputNumber() {
    return Integer.parseInt(scanner.nextLine());
  }
}
