package lotto.game;

import static lotto.game.GamePrint.printMessage;
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

public class GameInput {

  public Scanner scanner = new Scanner(System.in);
  Long purchaseAmount = null;
  Lotto winningLotto = null;
  Integer winningBonus = null;

  public Long inputPurchaseAmount() {
    while (!tryInputValidPurchaseAmount())
      ;
    return purchaseAmount;
  }

  private boolean tryInputValidPurchaseAmount() {
    try {
      setValidPurchaseAmount();
      return true;
    } catch (NumberFormatException e) {
      printMessage(Error.INVALID_LONG_FORMAT);
    } catch (Exception e) {
      printMessage(e.getMessage());
    }
    return false;
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
    while (!tryInputValidLottoAndSet())
      ;
    printMessage(Guide.REQUEST_BONUS_NUMBER);
    while (!tryInputBonusNumberAndSet())
      ;
    return new WinningLotto(winningLotto, winningBonus);
  }


  private boolean tryInputValidLottoAndSet() {
    try {
      setValidLotto();
      return true;
    } catch (NumberFormatException e) {
      printMessage(Error.INVALID_INT_FORMAT);
      return false;
    } catch (Exception e) {
      printMessage(e.getMessage());
      return false;
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

  private boolean tryInputBonusNumberAndSet() {
    try {
      setValidBonusNumber();
      return true;
    } catch (NumberFormatException e) {
      printMessage(Error.INVALID_INT_FORMAT);
      return false;
    } catch (Exception e) {
      printMessage(e.getMessage());
      return false;
    }
  }

  private void setValidBonusNumber() {
    Integer bonusNumber = getPlayerInputNumber();
    checkBonusDuplicate(winningLotto, bonusNumber);
    checkBonusOutOfRange(bonusNumber);
    winningBonus = bonusNumber;
  }

  private Integer getPlayerInputNumber() {
    return scanner.nextInt();
  }

}
