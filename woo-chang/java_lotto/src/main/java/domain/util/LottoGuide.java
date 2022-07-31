package domain.util;

public enum LottoGuide {
  COUNT(6),
  LOW_NUM(1),
  HIGH_NUM(45),
  PURCHASE_MINIMUM(1000),
  PURCHASE_RANGE_LIMIT(19);

  private final int value;

  LottoGuide(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
