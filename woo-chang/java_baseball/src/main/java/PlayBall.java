public class PlayBall {

  private final GeneratedTarget generatedTarget = new GeneratedTarget();
  private final GameHelper gameHelper = new GameHelper();
  private PlayStatus playStatus = PlayStatus.START;
  private String msg;

  public void start() {
    GameGuide.showGameInformation();
    generatedTarget.generatedNewTarget();
    do {
      do {
        gameHelper.userInput();
      } while(gameHelper.isInvalidInput());
      gameHelper.setInput();
      gameHelper.compareInput(generatedTarget.getTarget());
    } while(gameHelper.isNotGameOver());
  }

  public void chooseGameStart() {
    GameGuide.showGameChooseInformation();
    try {
      int choose = GameUtils.SCANNER.nextInt();
      if (choose == 1) {
        msg = "Loading...";
        playStatus = PlayStatus.START;
      } else if (choose == 2) {
        msg = "GAME STOP!";
        playStatus = PlayStatus.STOP;
      } else {
        msg = "CHOOSE 1 OR 2";
        playStatus = PlayStatus.START;
      }
    } catch (Exception e) {
      msg = "INPUT NUMBER! GAME STOP";
      playStatus = PlayStatus.STOP;
    } finally {
      System.out.println(msg);
    }
  }

  public boolean isNotStop() {
    return playStatus.getStatus();
  }

}
