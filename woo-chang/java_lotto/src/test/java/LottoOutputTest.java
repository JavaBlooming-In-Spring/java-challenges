import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoOutputTest {

  private static ByteArrayOutputStream outputMessage;

  @BeforeEach
  public void setUpStreams() {
    outputMessage = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputMessage));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(System.out);
  }

  @Test
  @DisplayName("입력에 대한 올바른 출력")
  public void print() {
    //given
    String message = "Lotto Test";

    //when
    LottoOutput.print(message);

    //then
    assertThat(message + "\n").isEqualTo(outputMessage.toString());
  }

}
