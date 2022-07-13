public class PlayBall {

  private PlayStatus playStatus = PlayStatus.START;
  private String msg;

  public void start() {
    showGameInformation();
    GeneratedTarget generatedTarget = new GeneratedTarget();
    GameHelper gameHelper = new GameHelper();
    do {
      gameHelper.userInput();
      gameHelper.compareInput(generatedTarget.getTarget());
    } while(gameHelper.isNotGameOver());
  }

  private void showGameInformation() {
    System.out.println("GAME START!");
    System.out.println("랜덤 수가 생성되었습니다.");
  }

  public void chooseGameStart() {
    showGameChooseInformation();
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

  private void showGameChooseInformation() {
    System.out.println("========== BASEBALL GAME ==========");
    System.out.println("1. GAME START");
    System.out.println("2. EXIT");
    System.out.print("YOUR CHOOSE ? ");
  }

  public boolean isNotStop() {
    return playStatus.getStatus();
  }

}
