package lotto.domain;

import java.util.Objects;

public class Match {

  private final int matchCount;
  private final boolean isBonusMatch;

  public Match(int matchCount, boolean isBonusMatch) {
    this.matchCount = matchCount;
    this.isBonusMatch = isBonusMatch;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public boolean isBonusMatch() {
    return isBonusMatch;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Match)) {
      return false;
    }
    Match match = (Match) o;
    return matchCount == match.matchCount && isBonusMatch == match.isBonusMatch;
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchCount, isBonusMatch);
  }
}
