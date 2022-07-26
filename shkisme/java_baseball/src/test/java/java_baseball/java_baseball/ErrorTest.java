package java_baseball.java_baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorTest {
    @Test
    @DisplayName("숫자를 3개보다 많이 입력한 경우")
    public void lengthError(){
        Error error = new Error();
        String[] inputArr = {"4","5","2","1","7"};
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> error.validateLengthError(inputArr));//예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo("숫자 3개를 입력해 주세요.");
    }
    @Test
    @DisplayName("숫자가 1보다 작거나, 9보다 큰 경우")
    public void valueError(){
        Error error = new Error();
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(5);
        numList.add(10);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> error.validateNumValueError(numList));//예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo("1부터 9 사이의 숫자를 입력해 주세요.");
    }
    @Test
    @DisplayName("숫자를 중복해서 입력했을 경우")
    public void duplicateError(){
        Error error = new Error();
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(1);
        numList.add(2);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> error.validateDupNumError(numList));//예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo("숫자를 중복 없이 입력해 주세요.");
    }
    @Test
    @DisplayName("재시작에 대해 답할때 1, 2가 아닌 다른 값을 입력한 경우")
    public void restartError(){
        Error error = new Error();
        int num = 3;
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> error.validateRestartError(num));//예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo("숫자 1 또는 2를 입력해 주세요.");
    }
}
