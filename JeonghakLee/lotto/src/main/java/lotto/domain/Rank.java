package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Rank {

  private final int matchedNumbers;
  private final int winningPrice;
  public static final Rank FIRST = new Rank(6, 2000000000);
  public static final Rank SECOND = new Rank(5, 30000000);
  public static final Rank THIRD = new Rank(5, 1500000);
  public static final Rank FORTH = new Rank(4, 50000);
  public static final Rank FIFTH = new Rank(3, 5000);

  public static final List<Rank> RANKLIST = new ArrayList<>(
      Arrays.asList(FIFTH, FORTH, THIRD, SECOND, FIRST));

  private Rank(int matchedNumbers, int winningPrice) {
    this.matchedNumbers = matchedNumbers;
    this.winningPrice = winningPrice;
  }

  public static Optional<Rank> getRank(int matchedNumbers, boolean hasBonus) {
    if (matchedNumbers == 6) {
      return Optional.ofNullable(FIRST);
    } else if (matchedNumbers == 5 && hasBonus) {
      return Optional.ofNullable(SECOND);
    } else if (matchedNumbers == 5 && !hasBonus) {
      return Optional.ofNullable(THIRD);
    } else if (matchedNumbers == 4) {
      return Optional.ofNullable(FORTH);
    } else if (matchedNumbers == 3) {
      return Optional.ofNullable(FIFTH);
    }
    return Optional.empty();
  }

  public int getMatchedNumbers() {
    return matchedNumbers;
  }

  public int getWinningPrice() {
    return winningPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rank rank = (Rank) o;
    return getMatchedNumbers() == rank.getMatchedNumbers()
        && getWinningPrice() == rank.getWinningPrice();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMatchedNumbers(), getWinningPrice());
  }
}
