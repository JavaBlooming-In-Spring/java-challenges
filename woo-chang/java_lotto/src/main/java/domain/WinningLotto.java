package domain;

import java.util.List;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
  private final Lotto lotto;
  private final int bonusNo;

  public WinningLotto(Lotto lotto, int bonusNo) {
    this.lotto = lotto;
    this.bonusNo = bonusNo;
  }

  public Rank match(Lotto userLotto) {
    int matchCount = calculateMatchCount(userLotto);
    boolean bonusMatch = userLotto.getNumbers().contains(bonusNo);
    return Rank.of(matchCount, bonusMatch);
  }

  private int calculateMatchCount(Lotto userLotto) {
    List<Integer> lastWeekNumbers = lotto.getNumbers();
    List<Integer> userNumbers = userLotto.getNumbers();
    lastWeekNumbers.retainAll(userNumbers);
    return lastWeekNumbers.size();
  }
}
