package java_baseball.java_baseball;

public class Game {
    Player player;
    Computer computer;
    GameController gameController;
    Game(){
        this.computer = new Computer();
        this.player = new Player();
        this.gameController = new GameController(player,computer);
    }
    public void gameStart(){
        do{
            computer.generateRandomNum();
            play();
        } while(gameController.getRestartState());
    }
    private void play(){
        do{
            computer.askNumber();
            player.inputControl();
            gameController.countScore();
            gameController.printScore();
        }while (gameController.isGameEnd());
    }
}