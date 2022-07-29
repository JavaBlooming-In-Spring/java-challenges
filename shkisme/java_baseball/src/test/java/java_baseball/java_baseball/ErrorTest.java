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
        Constant constant = new Constant();
        Error error = new Error();
        String[] inputArr = {"4","5","2","1","7"};
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> error.validateLength(inputArr));//예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo(Error.ErrorMessage.LENGTH_ERROR.getMessage());
    }
    @Test
    @DisplayName("숫자가 9보다 큰 경우")
    public void valueUpError(){
        Error error = new Error();
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(5);
        numList.add(10);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> error.validateNumberValue(numList));//예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo(Error.ErrorMessage.VALUE_ERROR.getMessage());
    }
    @Test
    @DisplayName("숫자가 1보다 작은 경우")
    public void valueDownError(){
        Error error = new Error();
        List<Integer> numList = new ArrayList<>();
        numList.add(0);
        numList.add(1);
        numList.add(5);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> error.validateNumberValue(numList));//예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo(Error.ErrorMessage.VALUE_ERROR.getMessage());
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
                () -> error.validateDupicateNumber(numList));//예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo(Error.ErrorMessage.DUPLICATENUMBER_ERROR.getMessage());
    }
    @Test
    @DisplayName("재시작에 대해 답할때 1, 2가 아닌 다른 값을 입력한 경우")
    public void restartError(){
        Error error = new Error();
        int num = 3;
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> error.validateRestart(num));//예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo(Error.ErrorMessage.RESTART_ERROR.getMessage());
    }
}
