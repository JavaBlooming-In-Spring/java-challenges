package lotto.service;

import static lotto.repository.RankRepository.RANKLIST;

import java.util.Map;
import java.util.Optional;
import lotto.domain.Rank;

public class PrintService {

  public static void printMessage(String message) {
    System.out.println(message);
  }

  public static void printMessage(Guide guide) {
    printMessage(guide.getMsg());
  }

  public static void printMessage(Error error) {
    printMessage(error.getMsg());
  }

  public static void printWinningStatistics(Map<Optional<Rank>, Integer> winningStatistics) {
    printMessage("당첨통계");
    printMessage("---------");
    for (Rank rank : RANKLIST) {
      int count = winningStatistics.get(Optional.of(rank));
      printEachWiningStatistics(rank.getMatchedNumbers(), rank.getWinningPrice(), count);
    }
  }

  public static void printEachWiningStatistics(int matchedNumbers, int winningPrice, int count) {
    printMessage(matchedNumbers + "개 일치 (" + winningPrice + "원)-" + count + "개");
  }

  public static void printNumberOfPurchasedLotto(long numberOfPurchasedLotto) {
    printMessage(numberOfPurchasedLotto + "개를 구매했습니다.");
  }

  public static void printYield(double yield) {
    printMessage("총 수익률은 " + yield + "입니다.");
  }

  enum Guide {
    REQUEST_PURCHASE_MONEY("구매 금액을 입력해주세요"),
    REQUEST_WINNING_LOTTO_NUMBERS("지난 주 당첨번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 볼을 입력해 주세요.");

    private final String msg;

    Guide(String msg) {
      this.msg = msg;
    }

    public String getMsg() {
      return msg;
    }
  }

  public enum Error {
    INVALID_LONG_FORMAT("64비트 정수입력 범위를 벗어났습니다."),
    NEGATIVE_MONEY("돈은 음수가 될 수 없습니다."),
    NOT_ENOUGH_MONEY("구매할 돈이 부족이 부족합니다."),
    INVALID_LOTTO_LENGTH("로또는 6개의 숫자가 필요합니다."),
    INVALID_LOTTO_RANGE("로또 숫자 범위는 1~45 입니다."),
    DUPLICATE_LOTTO_NUMBER("로또 숫자는 서로 중복될 수 없습니다."),
    INVALID_INT_FORMAT("32비트 정수입력 범위를 벗어났습니다."),
    INVALID_BONUS_RANGE("로또 숫자 범위가 아닙니다."),
    DUPLICATE_BONUS_NUMBER("보너스볼은 당첨 로또 번호 6개 숫자와 중복될 수 없습니다.");

    private final String msg;

    Error(String msg) {
      this.msg = msg;
    }

    public String getMsg() {
      return msg;
    }
  }

}
