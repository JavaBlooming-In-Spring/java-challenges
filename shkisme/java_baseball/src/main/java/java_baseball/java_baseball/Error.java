package java_baseball.java_baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java_baseball.java_baseball.RestartStatus.END;
import static java_baseball.java_baseball.RestartStatus.RESTART;

class ErrorMessage {
    public static final String LENGTH_ERROR = "숫자 3개를 입력해 주세요.";
    public static final String VALUE_ERROR = "1부터 9 사이의 숫자를 입력해 주세요.";
    public static final String DUPNUM_ERROR = "숫자를 중복 없이 입력해 주세요.";
    public static final String RESTART_ERROR = "숫자 1 또는 2를 입력해 주세요.";
}
public class Error {
    public void validateLengthError(String[] inputArr){
        if (inputArr.length != Constant.LIST_SIZE){
            throw new IllegalArgumentException(ErrorMessage.LENGTH_ERROR);
        }
    }
    public void validateNumValueError(List<Integer> playersNum){
        for (int i= 0; i< Constant.LIST_SIZE;i++){
            if (isValueError(playersNum.get(i))){
                throw new IllegalArgumentException(ErrorMessage.VALUE_ERROR);
            }
        }
    }
    private boolean isValueError(int num){
        if (Constant.BALL_MIN<=num && num <= Constant.BALL_MAX){
            return false;
        }
        else{
            return true;
        }
    }
    public void validateDupNumError(List<Integer> playersNum){
        HashSet<Integer> set = new HashSet<>(playersNum);
        if (!(set.size() == Constant.LIST_SIZE)){
            throw new IllegalArgumentException(ErrorMessage.DUPNUM_ERROR);
        }
    }
    public void validateRestartError(int restartSignal){
        if (restartSignal != RESTART.getRestartStatus() && restartSignal != END.getRestartStatus()){
            throw new IllegalArgumentException(ErrorMessage.RESTART_ERROR);
        }
    }
}