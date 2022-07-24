public enum PlayStatus {
  STOP(false), START(true);

  private PlayStatus(boolean status) {
    this.status = status;
  }

  private final boolean status;

  public boolean getStatus() {
    return this.status;
  }
}
