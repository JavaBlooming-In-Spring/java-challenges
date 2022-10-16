package domain.util;

public enum LottoValidationResult {
  SUCCESS("성공"),
  FAIL("실패"),
  NOT_MATCH_COUNT("로또는 6개의 숫자가 필요합니다."),
  OUT_OF_RANGE("로또 숫자 범위는 1~45 입니다."),
  DUPLICATE("로또 숫자는 서로 중복될 수 없습니다."),
  NOT_32BIT_INTEGER("32비트 정수입력을 벗어났습니다."),
  BONUS_OUT_OF_RANGE("로또 숫자 범위가 아닙니다."),
  BONUS_DUPLICATE("보너스볼은 당첨 로또 번호 6개 숫자와 중복될 수 없습니다."),
  BONUS_NOT_32BIT_INTEGER("32비트 정수입력 범위를 벗어났습니다.");

  private final String errorMessage;

  LottoValidationResult(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }
}
