package baseballGame;

public enum GameStatus {
  RESTART(1), END(2);

  private final int gameStatus;

  GameStatus(int status) {
    this.gameStatus = status;
  }

  public int getStatus() {
    return gameStatus;
  }
}
