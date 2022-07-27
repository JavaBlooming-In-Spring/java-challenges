package java_baseball.java_baseball;

import java.util.List;

import static java_baseball.java_baseball.RestartStatus.RESTART;

class GameControllerMessage {
    public static final String BALL_STRING = "볼 ";
    public static final String STRIKE_STRING = "스트라이크 ";
    public static final String NOTHING = "낫싱";
    public static final String ALL_CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
}

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
        saveStrikeCount(countStrike(player.playersNum));
        saveBallCount(countBall(player.playersNum));
    }
    private int countStrike(List<Integer> playersNum){
        int cnt =0;
        for (int i= 0; i< Constant.LIST_SIZE; i++){
            if (playersNum.get(i).equals(computer.getRandomNumList().get(i)))
                cnt += 1;
        }
        return cnt;
    }
    private int countBall(List<Integer> playersNum){
        int cnt = 0;
        for (int i =0 ;i < Constant.LIST_SIZE; i++){
            if (computer.getRandomNumList().contains(playersNum.get(i)) && !(playersNum.get(i).equals(computer.getRandomNumList().get(i))))
                cnt+=1;
        }
        return cnt;
    }
    private void saveStrikeCount(int countNum){
        this.strike = countNum;
    }
    private void saveBallCount(int countNum){
        this.ball = countNum;
    }
    public void printScore(){
        if (ball >0 && strike > 0){
            System.out.println(ball + GameControllerMessage.BALL_STRING + strike + GameControllerMessage.STRIKE_STRING);
        }
        else if (ball > 0){
            System.out.println(ball + GameControllerMessage.BALL_STRING);
        }
        else if (strike > 0){
            System.out.println(strike + GameControllerMessage.STRIKE_STRING);
        }
        else{
            System.out.println(GameControllerMessage.NOTHING);
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
        System.out.println(GameControllerMessage.ALL_CORRECT);
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
}