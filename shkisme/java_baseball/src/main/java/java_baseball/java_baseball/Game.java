package java_baseball.java_baseball;

public class Game {
    Player player;
    Computer computer;
    Game(){
        this.computer = new Computer();
        this.player = new Player();
    }
    public void gameStart(){
        do{
            play();
        } while(computer.getRestartState());
    }
    private void play(){
        computer.generateRandomNum();
        do{
            computer.askNum();
            computer.gameStateSet();
            computer.compareNum(player.inputNum());
            computer.printScore();
            computer.isGameEnd(player);
        }while (computer.getGameState());
    }
}
