package java_baseball.java_baseball;

public enum RestartStatus {
    RESTART(1),
    END(2);

    private int value;
    RestartStatus(int num){
        this.value = num;
    }

    public int getRestartStatus(){
        return this.value;
    }
}