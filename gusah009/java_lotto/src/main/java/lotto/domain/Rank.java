package lotto.domain;

public enum Rank {
  FIFTH_PLACE(5_000),
  FOURTH_PLACE(50_000),
  THIRD_PLACE(1_500_000),
  SECOND_PLACE(30_000_000),
  FIRST_PLACE(2_000_000_000);

  private final long price;

  Rank(long price) {
    this.price = price;
  }

  public long getPrice() {
    return price;
  }
}
