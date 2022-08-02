package lotto.service;

import static lotto.domain.Rank.RANKLIST;

import java.util.Map;
import java.util.Optional;
import lotto.domain.Rank;

public class PrintService {

  public static void printMessage(String message) {
    System.out.println(message);
  }

  public static void printInputMoneyRequest() {
    printMessage("구입금액을 입력해주세요.");
  }

  public static void printWiningStatisticsMessage() {
    printMessage("당첨통계");
    printMessage("---------");
  }

  public static void printWinningStatistics(Map<Optional<Rank>, Integer> winningStatistics) {
    printWiningStatisticsMessage();
    for (Rank rank : RANKLIST) {
      int count = winningStatistics.get(rank);
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

}
