package java_baseball.java_baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    Error error = new Error();
    public List<Integer> inputNum(){
        List<Integer> playersNum = new ArrayList<>();
        String str = sc.nextLine();
        String[] inputArr = str.split(" ");

        error.validateLengthError(inputArr);

        playersNum.add(Integer.parseInt(inputArr[0]));
        playersNum.add(Integer.parseInt(inputArr[1]));
        playersNum.add(Integer.parseInt(inputArr[2]));

        error.validateNumValueError(playersNum);
        error.validateDupNumError(playersNum);
        return playersNum;
    }
    public int restartAnswer(){
        String str = sc.nextLine();
        int restartSignal = Integer.parseInt(str);
        error.validateRestartError(restartSignal);
        return restartSignal;
    }
}
