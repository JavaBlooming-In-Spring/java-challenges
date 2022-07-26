package java_baseball.java_baseball;

import java.util.List;

public class Error {
    public void validateLengthError(String[] inputArr){
        if (inputArr.length != Constant.LIST_SIZE){
            throw new IllegalArgumentException(Constant.LENGTH_ERROR);
        }
    }
    public void validateNumValueError(List<Integer> playersNum){
        for (int i= 0; i< Constant.LIST_SIZE;i++){
            if (!(1<=playersNum.get(i) && playersNum.get(i) <= 9)){
                throw new IllegalArgumentException(Constant.VALUE_ERROR);
            }
        }
    }
    public void validateDupNumError(List<Integer> playersNum){
        int num1 = playersNum.get(Constant.FIRST_INDEX);
        int num2 = playersNum.get(Constant.SECOND_INDEX);
        int num3 = playersNum.get(Constant.THIRD_INDEX);
        if (num1 == num2 || num1==num3 || num2 == num3){
            throw new IllegalArgumentException(Constant.DUPNUM_ERROR);
        }
    }
    public void validateRestartError(int restartSignal){
        if (restartSignal != 1 && restartSignal != 2){
            throw new IllegalArgumentException(Constant.RESTART_ERROR);
        }
    }
}
