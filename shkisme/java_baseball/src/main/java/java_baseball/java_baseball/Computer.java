package java_baseball.java_baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    private List<Integer> randomNumList;
    private int strike;
    private int ball;
    private boolean gameState = true;
    private boolean restartState = false;

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
    public void gameStateSet(){
        gameState = true;
    }
    public void askNum(){
        System.out.println(Constant.PLAYER_INPUT_NUM);
    }
    public void compareNum(List<Integer> playersNum){
        strikeCnt(playersNum);
        ballCnt(playersNum);
    }
    private void strikeCnt(List<Integer> playersNum){
        int cnt =0;
        for (int i= 0; i< 3; i++){
            if (playersNum.get(i).equals(this.randomNumList.get(i)))
                cnt += 1;
        }
        this.strike = cnt;
    }
    private void ballCnt(List<Integer> playersNum){
        int cnt = 0;
        for (int i =0 ;i < 3; i++){
            if (this.randomNumList.contains(playersNum.get(i)) && !(playersNum.get(i).equals(this.randomNumList.get(i))))
                cnt+=1;
        }
        this.ball = cnt;
    }
    public void printScore(){
        if (ball >0 && strike > 0){
            System.out.println(ball + Constant.BALL_STRING + strike + Constant.STRIKE_STRING);
        }
        else if (ball > 0){
            System.out.println(ball + Constant.BALL_STRING);
        }
        else if (strike > 0){
            System.out.println(strike + Constant.STRIKE_STRING);
        }
        else{
            System.out.println(Constant.NOTHING);
        }
    }
    public void isGameEnd(Player player){
        if (strike == Constant.ALL_STRIKE){
            gameClear(player);
            gameState = false;
        }
    }
    private void gameClear(Player player){
        System.out.println(Constant.ALL_CORRECT);
        int playersAnswer = askGameRestart(player);
        gameRestartJudging(playersAnswer);
    }
    private int askGameRestart(Player player){
        System.out.println(Constant.ASK_PLAYER_RESTART);
        int playersAnswer = player.restartAnswer();
        return playersAnswer;
    }
    private void gameRestartJudging(int playersAnswer){
        if (playersAnswer == Constant.RESTART_BUTTON){
            restartState = true;
        }
        else{
            restartState = false;
        }
    }
    public boolean getRestartState(){
        return restartState;
    }
    public boolean getGameState(){
        return gameState;
    }
    public List<Integer> getRandomNumList(){
        return randomNumList;
    }
}