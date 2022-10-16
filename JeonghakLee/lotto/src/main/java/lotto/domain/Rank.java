package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public enum Rank {
  FIFTH(3,5000),
  FORTH(4,50000),
  THIRD(5,1500000),
  SECOND(5,30000000),
  FIRST(6,2000000000);

  private final int matchedNumbers;
  private final int winningPrice;


  private Rank(int matchedNumbers, int winningPrice) {
    this.matchedNumbers = matchedNumbers;
    this.winningPrice = winningPrice;
  }

  public int getMatchedNumbers() {
    return matchedNumbers;
  }

  public int getWinningPrice() {
    return winningPrice;
  }

}
