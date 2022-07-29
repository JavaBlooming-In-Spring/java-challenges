public class Main {

  public static void main(String[] args) {
    PlayBall playBall = new PlayBall();
    do {
      playBall.start();
      playBall.chooseGameStart();
    } while(playBall.isNotStop());
    GameUtils.SCANNER.close();
  }

}
