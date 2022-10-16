package domain.util;

public enum LottoMessage {
  PURCHASE_INPUT("구입금액을 입력해주세요."),
  LAST_WEEK_WINNING_NUMBER("지난 주 당첨번호를 입력해 주세요."),
  BONUS_BALL("보너스 볼을 입력해 주세요."),
  WINNING_STATUS("당첨 통계"),
  LINE("---------");

  private final String message;

  LottoMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
