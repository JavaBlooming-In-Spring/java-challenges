package javablooming.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void carNameLengthIs0() {
    //given
    String carName = "";

    //when
    boolean carNameValid = isCarNameValid(carName);

    //then
    assertThat(carNameValid).isEqualTo(false);
  }

  @Test
  void carNameLengthIs1() {
    //given
    String carName = "1";

    //when
    boolean carNameValid = isCarNameValid(carName);

    //then
    assertThat(carNameValid).isEqualTo(true);
  }

  @Test
  void carNameLengthIs2() {
    //given
    String carName = "12";

    //when
    boolean carNameValid = isCarNameValid(carName);

    //then
    assertThat(carNameValid).isEqualTo(true);
  }

  @Test
  void carNameLengthIs3() {
    //given
    String carName = "123";

    //when
    boolean carNameValid = isCarNameValid(carName);

    //then
    assertThat(carNameValid).isEqualTo(true);
  }

  @Test
  void carNameLengthIs4() {
    //given
    String carName = "1234";

    //when
    boolean carNameValid = isCarNameValid(carName);

    //then
    assertThat(carNameValid).isEqualTo(true);
  }

  @Test
  void carNameLengthIs5() {
    //given
    String carName = "12345";

    //when
    boolean carNameValid = isCarNameValid(carName);

    //then
    assertThat(carNameValid).isEqualTo(true);
  }

  @Test
  void carNameLengthIs6() {
    //given
    String carName = "123456";

    //when
    boolean carNameValid = isCarNameValid(carName);

    //then
    assertThat(carNameValid).isEqualTo(false);
  }

  @Test
  void carNameLengthIs7() {
    //given
    String carName = "1234567";

    //when
    boolean carNameValid = isCarNameValid(carName);

    //then
    assertThat(carNameValid).isEqualTo(false);
  }

  @Test
  void carNameLengthIs8() {
    //given
    String carName = "12345678";

    //when
    boolean carNameValid = isCarNameValid(carName);

    //then
    assertThat(carNameValid).isEqualTo(false);
  }

  @Test
  void carNameLengthIs9() {
    //given
    String carName = "123456789";

    //when
    boolean carNameValid = isCarNameValid(carName);

    //then
    assertThat(carNameValid).isEqualTo(false);
  }

  private boolean isCarNameValid(String carName) {
    Throwable thrown = catchThrowable(() -> new Car(carName));
    if (thrown == null) {
      return true;
    }
    if (thrown.getClass() == IllegalArgumentException.class) {
      return false;
    }
    return false;
  }
}