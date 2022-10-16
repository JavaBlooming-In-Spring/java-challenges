package domain;

public class ValidateResult {

  private Long purchaseAmount;
  private Lotto lastWeekLotto;
  private int bonus;

  public void successPurchaseAmount(Long purchaseAmount) {
    this.purchaseAmount = purchaseAmount;
  }

  public void successLastWeekLotto(Lotto lastWeekLotto) {
    this.lastWeekLotto = lastWeekLotto;
  }

  public void successBonus(int bonus) {
    this.bonus = bonus;
  }

  public Long getValidPurchaseAmount() {
    return this.purchaseAmount;
  }

  public Lotto getValidLastWeekLotto() {
    return this.lastWeekLotto;
  }

  public int getValidBonus() {
    return this.bonus;
  }

}
