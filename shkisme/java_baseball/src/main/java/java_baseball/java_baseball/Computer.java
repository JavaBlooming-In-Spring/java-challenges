package java_baseball.java_baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class ComputerMessage{
    public static final String PLAYER_INPUT_NUM = "숫자를 입력해 주세요 : ";
    public static final String ASK_PLAYER_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
}

public class Computer {
    private List<Integer> randomNumList;

    public void generateRandomNum(){
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        while(randomList.size() < Constant.LIST_SIZE){
            int randomNum = random.nextInt(100) % Constant.BALL_MAX + Constant.BALL_MIN;
            if (!randomList.contains(randomNum))
                randomList.add(randomNum);
        }
        randomNumList = randomList;
    }
    public void askNum(){
        System.out.println(ComputerMessage.PLAYER_INPUT_NUM);
    }

    public void askGameRestart(){
        System.out.println(ComputerMessage.ASK_PLAYER_RESTART);
    }

    public List<Integer> getRandomNumList(){
        return randomNumList;
    }
}