package javablooming;

public enum RestartStatus {
  RESTART(1), END(2);

  private final int statusValue;

  RestartStatus(int statusValue) {
    this.statusValue = statusValue;
  }

  public int getStatusValue() {
    return statusValue;
  }
}
