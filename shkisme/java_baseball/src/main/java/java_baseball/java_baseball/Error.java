package java_baseball.java_baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java_baseball.java_baseball.Error.ErrorMessage.*;
import static java_baseball.java_baseball.RestartStatus.END;
import static java_baseball.java_baseball.RestartStatus.RESTART;


public class Error {
    public void validateLength(String[] inputArr){
        if (inputArr.length != Constant.LIST_SIZE){
            throw new IllegalArgumentException(LENGTH_ERROR.getMessage());
        }
    }
    public void validateNumberValue(List<Integer> playersNumer){
        for (int i= 0; i< Constant.LIST_SIZE;i++){
            if (isNumberValueError(playersNumer.get(i))){
                throw new IllegalArgumentException(VALUE_ERROR.getMessage());
            }
        }
    }
    private boolean isNumberValueError(int number){
        if (Constant.BALL_MIN<=number && number <= Constant.BALL_MAX){
            return false;
        }
        else{
            return true;
        }
    }
    public void validateDupicateNumber(List<Integer> playersNumer){
        HashSet<Integer> set = new HashSet<>(playersNumer);
        if (!(set.size() == Constant.LIST_SIZE)){
            throw new IllegalArgumentException(DUPLICATENUMBER_ERROR.getMessage());
        }
    }
    public void validateRestart(int restartSignal){
        if (restartSignal != RESTART.getRestartStatus() && restartSignal != END.getRestartStatus()){
            throw new IllegalArgumentException(RESTART_ERROR.getMessage());
        }
    }
    enum ErrorMessage {
        LENGTH_ERROR ("숫자 3개를 입력해 주세요."),
        VALUE_ERROR ("1부터 9 사이의 숫자를 입력해 주세요."),
        DUPLICATENUMBER_ERROR ("숫자를 중복 없이 입력해 주세요."),
        RESTART_ERROR ("숫자 1 또는 2를 입력해 주세요.");
        private String message;
        ErrorMessage(String message){
            this.message = message;
        }
        public String getMessage(){
            return this.message;
        }
    }
}