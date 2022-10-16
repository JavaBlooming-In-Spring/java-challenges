package lotto.domain;

import java.util.List;
import java.util.Optional;
import lotto.repository.RankRepository;

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

  public Optional<Rank> match(Lotto userLotto) {
    // TODO 로직 구현
    int matchCount = getMatchCount(this.lotto, userLotto);
    boolean isMatchBonusNo = userLotto.getNumbers().contains(bonusNo);
    return RankRepository.getRankRepository()
        .findByMatchCount(matchCount, isMatchBonusNo);
  }

  private int getMatchCount(Lotto lotto1, Lotto lotto2) {
    List<Integer> numbers1 = lotto1.getNumbers();
    List<Integer> numbers2 = lotto2.getNumbers();
    numbers1.retainAll(numbers2);
    return numbers1.size();
  }
}
