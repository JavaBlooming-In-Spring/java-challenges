package domain.util;

public enum PurchaseValidationResult {
  SUCCESS("성공"),
  FAIL("실패"),
  STRING("64비트 정수입력 범위를 벗어났습니다."),
  NEGATIVE("돈은 음수가 될 수 없습니다."),
  LARGE("64비트 정수입력 범위를 벗어났습니다."),
  SMALL("구매할 돈이 부족이 부족합니다.");

  private final String errorMessage;

  PurchaseValidationResult(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }
}
