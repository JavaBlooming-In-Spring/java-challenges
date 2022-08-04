import static org.assertj.core.api.Assertions.*;

import domain.util.LottoValidationResult;
import domain.util.PurchaseValidationResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoValidationTest {

  @Test
  @DisplayName("구입금액 문자가 입력된 경우")
  public void inputPurchaseString() {
    //given
    String input = "woowa";

    //when
    PurchaseValidationResult result = LottoValidation.validatePurchaseAboutString(input);

    //then
    assertThat(result).isEqualTo(PurchaseValidationResult.NOT_64BIT_INTEGER);
  }

  @Test
  @DisplayName("구입금액 음수가 입력된 경우")
  public void inputPurchaseNegative() {
    //given
    String input = "-10";

    //when
    PurchaseValidationResult result = LottoValidation.validatePurchaseAboutNegative(input);

    //then
    assertThat(result).isEqualTo(PurchaseValidationResult.NEGATIVE);
  }

  @Test
  @DisplayName("구입금액이 매우 큰 수가 입력된 경우")
  public void inputPurchaseLargeNumber() {
    //given
    String input = "9223372036854775808";

    //when
    PurchaseValidationResult result = LottoValidation.validatePurchaseAboutLargeNumber(input);

    //then
    assertThat(result).isEqualTo(PurchaseValidationResult.MUCH);
  }

  @Test
  @DisplayName("구입금액이 부족한 경우")
  public void inputPurchaseMinimum() {
    //given
    String input = "10";

    //when
    PurchaseValidationResult result = LottoValidation.validatePurchaseAboutMinimum(input);

    //then
    assertThat(result).isEqualTo(PurchaseValidationResult.LACK);
  }

  @Test
  @DisplayName("6개 숫자가 아닌 입력")
  public void inputLottoCount() {
    //given
    String input = "1,2,3,4,5";

    //when
    LottoValidationResult result = LottoValidation.validateLottoCount(input);

    //then
    assertThat(result).isEqualTo(LottoValidationResult.NOT_MATCH_COUNT);
  }

  @Test
  @DisplayName("로또 숫자 범위 벗어난 입력")
  public void inputLottoOutOfRange() {
    //given
    String input = "1,2,3,4,5,46";

    //when
    LottoValidationResult result = LottoValidation.validateLottoNumbersRange(input);

    //then
    assertThat(result).isEqualTo(LottoValidationResult.OUT_OF_RANGE);
  }

  @Test
  @DisplayName("중복된 로또 번호 입력")
  public void inputLottoDuplicate() {
    //given
    String input = "1,1,2,3,4,5";

    //when
    LottoValidationResult result = LottoValidation.validateLottoDuplication(input);

    //then
    assertThat(result).isEqualTo(LottoValidationResult.DUPLICATE);
  }

  @Test
  @DisplayName("로또 번호 문자 입력")
  public void inputLottoString() {
    //given
    String input = "가,나,다,라,마,바";

    //when
    LottoValidationResult result = LottoValidation.validateLottoString(input);

    //then
    assertThat(result).isEqualTo(LottoValidationResult.NOT_32BIT_INTEGER);
  }

  @Test
  @DisplayName("범위 벗어난 보너스 볼 입력")
  public void inputBonusOutOfRange() {
    //given
    String input = "100";

    //when
    LottoValidationResult result = LottoValidation.validateBonusRange(input);

    //then
    assertThat(result).isEqualTo(LottoValidationResult.BONUS_OUT_OF_RANGE);
  }

  @Test
  @DisplayName("로또 번호와 중복된 입력")
  public void inputBonusDuplication() {
    //given
    String lotto = "1,2,3,4,5,6";
    String bonus = "1";
    List<Integer> lottoNumbers = LottoInput.parseInput(lotto);

    //when
    LottoValidationResult result = LottoValidation.validateBonusDuplication(bonus, lottoNumbers);

    //then
    assertThat(result).isEqualTo(LottoValidationResult.BONUS_DUPLICATE);
  }

  @Test
  @DisplayName("보너스 볼 문자 입력")
  public void inputBonusString() {
    //given
    String input = "hi";

    //when
    LottoValidationResult result = LottoValidation.validateBonusString(input);

    //then
    assertThat(result).isEqualTo(LottoValidationResult.BONUS_NOT_32BIT_INTEGER);
  }

}
