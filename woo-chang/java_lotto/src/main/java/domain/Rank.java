package domain;

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
    if (matchCount == Rank.FIRST.getMatch())
      return Rank.FIRST;
    if (matchCount == Rank.THIRD.getMatch())
      return distinctBonus(bonusMatch);
    if (matchCount == Rank.FOURTH.getMatch())
      return Rank.FOURTH;
    if (matchCount == Rank.FIFTH.getMatch())
      return Rank.FIFTH;
    return Rank.NONE;
  }

  private static Rank distinctBonus(boolean bonusMatch) {
    if (bonusMatch) return Rank.SECOND;
    return Rank.THIRD;
  }
}
