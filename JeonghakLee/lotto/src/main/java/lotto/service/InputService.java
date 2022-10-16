package lotto.service;

import static lotto.service.PrintService.Error.INVALID_INT_FORMAT;
import static lotto.service.PrintService.Error.INVALID_LONG_FORMAT;
import static lotto.service.PrintService.Guide.REQUEST_BONUS_NUMBER;
import static lotto.service.PrintService.Guide.REQUEST_PURCHASE_MONEY;
import static lotto.service.PrintService.Guide.REQUEST_WINNING_LOTTO_NUMBERS;
import static lotto.service.ValidateService.Validation.INVALID;
import static lotto.service.ValidateService.Validation.VALID;
import static lotto.service.PrintService.printMessage;
import static lotto.service.ValidateService.checkValidBonusNumber;
import static lotto.service.ValidateService.checkValidLottoNumbers;
import static lotto.service.ValidateService.checkValidMoney;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import lotto.service.ValidateService.Validation;

public class InputService {

  Scanner scanner = new Scanner(System.in);
  private long money;
  private List<Integer> winningLottoNumbers;
  private int bonusBall;

  public void close() {
    scanner.close();
  }

  public long getMoney() {
    return money;
  }

  public List<Integer> getWinningLottoNumbers() {
    return winningLottoNumbers;
  }

  public int getBonusBall() {
    return bonusBall;
  }

  public void input() {
    inputMoney();
    inputWinningLottoNumbers();
    inputBonusBall();
  }

  void inputMoney() {
    printMessage(REQUEST_PURCHASE_MONEY);
    while (trySetValidMoney() == INVALID)
      ;
  }

  void inputWinningLottoNumbers() {
    while (trySetWinningLottoNumbers() == INVALID)
      ;
  }

  void inputBonusBall() {
    while (trySetBonusBall(winningLottoNumbers) == INVALID)
      ;
  }

  Validation trySetValidMoney() {
    try {
      long input = getInputMoney();
      checkValidMoney(input);
      setMoney(input);
      return VALID;
    } catch (NumberFormatException e) {
      printMessage(INVALID_LONG_FORMAT);
    } catch (Exception e) {
      printMessage(e.getMessage());
    }
    return INVALID;
  }

  private Long getInputMoney() {
    return Long.parseLong(scanner.nextLine());
  }

  private void setMoney(long money) {
    this.money = money;
  }

  Validation trySetBonusBall(List<Integer> winningLottoNumbers) {
    try {
      int input = getInputBonusBall();
      checkValidBonusNumber(winningLottoNumbers, input);
      setBonusBall(input);
      return VALID;
    } catch (Exception e) {
      printMessage(e.getMessage());
    }
    return INVALID;
  }

  private int getInputBonusBall() {
    printMessage(REQUEST_BONUS_NUMBER);
    return Integer.parseInt(scanner.nextLine());
  }

  private void setBonusBall(int bonusBall) {
    this.bonusBall = bonusBall;
  }

  Validation trySetWinningLottoNumbers() {
    try {
      String input = inputLottoNumbers();
      List<Integer> lottoNumbers = castToList(input);
      checkValidLottoNumbers(lottoNumbers);
      setWinningLottoNumbers(lottoNumbers);
      return VALID;
    } catch (NumberFormatException e) {
      printMessage(INVALID_INT_FORMAT);
    } catch (Exception e) {
      printMessage(e.getMessage());
    }
    return INVALID;
  }

  static List<Integer> castToList(String input) {
    return Arrays.stream(input.split(","))
        .map(Integer::parseInt)
        .toList();
  }

  private String inputLottoNumbers() {
    printMessage(REQUEST_WINNING_LOTTO_NUMBERS);
    return scanner.nextLine();
  }

  private void setWinningLottoNumbers(List<Integer> winningLottoNumbers) {
    this.winningLottoNumbers = winningLottoNumbers;
  }

}
