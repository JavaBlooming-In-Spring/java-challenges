package java_baseball.java_baseball;

import java.util.List;

import static java_baseball.java_baseball.GameController.GameControllerMessage.*;
import static java_baseball.java_baseball.RestartStatus.RESTART;


public class GameController {
    private int strike;
    private int ball;
    private boolean restartState = false;
    Player player;
    Computer computer;
    GameController(Player player, Computer computer){
        this.player = player;
        this.computer = computer;
    }
    public void countScore(){
        saveStrikeCount(countStrike(player.playersNumber));
        saveBallCount(countBall(player.playersNumber));
    }
    private int countStrike(List<Integer> playersNum){
        int count =0;
        for (int i= 0; i< Constant.LIST_SIZE; i++){
            if (playersNum.get(i).equals(computer.getRandomNumberList().get(i)))
                count += 1;
        }
        return count;
    }
    private int countBall(List<Integer> playersNum){
        int count = 0;
        for (int i =0 ;i < Constant.LIST_SIZE; i++){
            if (computer.getRandomNumberList().contains(playersNum.get(i)) && !(playersNum.get(i).equals(computer.getRandomNumberList().get(i))))
                count+=1;
        }
        return count;
    }
    private void saveStrikeCount(int countNumber){
        this.strike = countNumber;
    }
    private void saveBallCount(int countNumber){
        this.ball = countNumber;
    }
    public void printScore(){
        if (ball >0 && strike > 0){
            System.out.println(ball + BALL_STRING.getMessage() + strike + STRIKE_STRING.getMessage());
        }
        else if (ball > 0){
            System.out.println(ball + BALL_STRING.getMessage());
        }
        else if (strike > 0){
            System.out.println(strike + STRIKE_STRING.getMessage());
        }
        else{
            System.out.println(NOTHING.getMessage());
        }
    }
    public boolean isGameEnd(){
        if (strike == Constant.LIST_SIZE){
            gameClear();
            return false;
        }
        else{
            return true;
        }
    }
    private void gameClear(){
        gameClearMessage();
        computer.askGameRestart();
        judgeGameRestart(player.restartAnswer());
    }
    void gameClearMessage(){
        System.out.println(ALL_CORRECT.getMessage());
    }
    private void judgeGameRestart(int playersAnswer){
        if (playersAnswer == RESTART.getRestartStatus()){
            setRestartStateTrue();
        }
        else{
            setRestartStateFalse();
        }
    }
    private void setRestartStateTrue(){
        restartState = true;
    }
    public void setRestartStateFalse(){
        restartState = false;
    }
    public boolean getRestartState(){
        return restartState;
    }
    enum GameControllerMessage {
        BALL_STRING ("볼 "),
        STRIKE_STRING ("스트라이크 "),
        NOTHING ("낫싱"),
        ALL_CORRECT ("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        private String message;
        GameControllerMessage(String message){
            this.message = message;
        }
        public String getMessage(){
            return this.message;
        }
    }
}