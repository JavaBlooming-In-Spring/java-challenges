package lotto.game;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.repository.RankRepository;

public class GamePrint {

  private static final RankRepository rankRepository = RankRepository.getRankRepository();

  public static void printMessage(String msg) {
    System.out.println(msg);
  }

  public static void printMessage(Guide guide) {
    printMessage(guide.getMsg());
  }

  public static void printMessage(Error error) {
    printMessage(error.getMsg());
  }

  public static void printPurchaseLottoList(List<Lotto> purchaseLottoList) {
    purchaseLottoList.forEach(lotto -> printMessage(lotto.getNumbers().toString()));
  }

  public static void printResult(Result result) {
    printMessage("당첨 통계");
    printMessage("---------");
    for (Rank rank : rankRepository.findAllRank()) {
      printEachResultByRank(result, rank);
    }
    printMessage(String.format("총 수익률은 %.3f입니다.", result.getRateOfReturn()));
  }

  private static void printEachResultByRank(Result result, Rank rank) {
    Match match = rankRepository.findByRank(rank)
        .orElseThrow(() -> new RuntimeException("저장소에 문제가 생겼습니다"));
    String rankResult = String.format("%d개 일치 (%d원)-%d개",
        match.getMatchCount(), rank.getPrice(), result.getCount(rank));
    printMessage(rankResult);
  }

  enum Guide {
    REQUEST_PURCHASE_PRICE("구매금액을 입력해주세요"),
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
    NEGATIVE_PRICE("돈은 음수가 될 수 없습니다."),
    NO_MONEY("돈이 부족합니다"),
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
