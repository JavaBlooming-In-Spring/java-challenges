package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  NONE(0, 0);

  private final int match;
  private final int price;

  Rank(int match, int price) {
    this.match = match;
    this.price = price;
  }

  public int getMatch() {
    return this.match;
  }

  public int getPrice() {
    return this.price;
  }

  public static Rank of(int matchCount, boolean bonusMatch) {
    List<Rank> result = Arrays.stream(Rank.values())
        .filter(rank -> rank.getMatch() == matchCount)
        .collect(Collectors.toList());
    if (result.size() == 1) return result.get(0);
    if (result.size() == 2) return distinctBonus(bonusMatch);
    return Rank.NONE;
  }

  private static Rank distinctBonus(boolean bonusMatch) {
    if (bonusMatch) return Rank.SECOND;
    return Rank.THIRD;
  }
}
