package java_baseball.java_baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    Error error = new Error();
    List<Integer> playersNum = new ArrayList<>();

    public void inputControl(){
        String inputStr = playersInput();
        String[] inputArr = splitString(inputStr);
        error.validateLengthError(inputArr);
        clearList();
        generatePlayersList(inputArr);
        error.validateNumValueError(playersNum);
        error.validateDupNumError(playersNum);
    }
    private String playersInput(){
        String str = sc.nextLine();
        return str;
    }
    private String[] splitString(String str){
        String[] inputArr = str.split(" ");
        return inputArr;
    }
    private void clearList(){
        if (playersNum.size() == Constant.LIST_SIZE)
            playersNum.clear();
    }
    private void generatePlayersList(String[] inputArr){
        for (int i =0 ;i < Constant.LIST_SIZE; i++){
            playersNum.add(Integer.parseInt(inputArr[i]));
        }
    }
    public int restartAnswer(){
        String inputStr = playersInput();
        int restartSignal = stringToInt(inputStr);
        error.validateRestartError(restartSignal);
        return restartSignal;
    }
    private int stringToInt(String inputStr){
        int num = Integer.parseInt(inputStr);
        return num;
    }
}
