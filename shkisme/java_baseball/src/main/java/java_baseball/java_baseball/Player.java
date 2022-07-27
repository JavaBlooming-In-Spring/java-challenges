package java_baseball.java_baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    Error error = new Error();
    List<Integer> playersNumber = new ArrayList<>();

    public void inputControl(){
        String inputString = playersInput();
        String[] inputArray = splitString(inputString);
        error.validateLength(inputArray);
        clearList();
        generatePlayersList(inputArray);
        error.validateNumberValue(playersNumber);
        error.validateDupicateNumber(playersNumber);
    }
    private String playersInput(){
        String string = sc.nextLine();
        return string;
    }
    private String[] splitString(String string){
        String[] inputArray = string.split(" ");
        return inputArray;
    }
    private void clearList(){
        if (playersNumber.size() == Constant.LIST_SIZE)
            playersNumber.clear();
    }
    private void generatePlayersList(String[] inputArray){
        for (int i =0 ;i < Constant.LIST_SIZE; i++){
            playersNumber.add(Integer.parseInt(inputArray[i]));
        }
    }
    public int restartAnswer(){
        String inputString = playersInput();
        int restartSignal = stringToInt(inputString);
        error.validateRestart(restartSignal);
        return restartSignal;
    }
    private int stringToInt(String inputString){
        int number = Integer.parseInt(inputString);
        return number;
    }
}
