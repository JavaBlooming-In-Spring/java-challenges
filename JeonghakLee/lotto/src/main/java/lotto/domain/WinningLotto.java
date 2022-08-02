package lotto.domain;

import static lotto.domain.Rank.getRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WinningLotto {

  private final Lotto lotto;
  private final int bonusNo;

  public WinningLotto(Lotto lotto, int bonusNo) {
    this.lotto = lotto;
    this.bonusNo = bonusNo;
  }

  public Lotto getLotto() {
    return lotto;
  }

  public Optional<Rank> match(Lotto userLotto) {
    int matchedNumbers = getMatchedNumbers(userLotto);
    boolean hasBonusNo = userLotto.getNumbers().contains(bonusNo);
    return getRank(matchedNumbers, hasBonusNo);
  }

  private int getMatchedNumbers(Lotto userLotto) {
    List<Integer> sameLottoNumbers = new ArrayList<>(userLotto.getNumbers());
    sameLottoNumbers.retainAll(lotto.getNumbers());
    return sameLottoNumbers.size();
  }
}
