package java_baseball.java_baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java_baseball.java_baseball.Computer.ComputerMessage.ASK_PLAYER_RESTART;
import static java_baseball.java_baseball.Computer.ComputerMessage.PLAYER_INPUT_NUM;

public class Computer {
    private List<Integer> randomNumberList;

    public void generateRandomNum(){
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        while(randomList.size() < Constant.LIST_SIZE){
            int randomNumber = random.nextInt(100) % Constant.BALL_MAX + Constant.BALL_MIN;
            if (!randomList.contains(randomNumber))
                randomList.add(randomNumber);
        }
        randomNumberList = randomList;
    }
    public void askNumber(){
        System.out.println(PLAYER_INPUT_NUM.getMessage());
    }

    public void askGameRestart(){
        System.out.println(ASK_PLAYER_RESTART.getMessage());
    }

    public List<Integer> getRandomNumberList(){
        return randomNumberList;
    }
    enum ComputerMessage{
        PLAYER_INPUT_NUM("숫자를 입력해 주세요 : "),
        ASK_PLAYER_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        private String message;
        ComputerMessage(String message){
            this.message = message;
        }
        public String getMessage(){
            return this.message;
        }
    }
}