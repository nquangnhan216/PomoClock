package model;

public class PomoState {
    private PomoMode mode;
    private int remainingSeconds;
    private boolean running = false;
    //chứa dữ liệu người dùng
    public PomoState(PomoMode mode, int remainingSeconds) {
        this.mode = mode;
        this.remainingSeconds = remainingSeconds;
    }
    public PomoMode getMode() {
        return mode;
    }
    public int getRemainingSeconds() {
        return remainingSeconds;
    }
    public void setMode(PomoMode mode) {
        this.mode = mode;
    }
    public void setRemainingSeconds(int remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
    }
    public boolean isRunning() {
        return running;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
    @Override
    public String toString() {
        return "Mode: " + mode + "\n" +
                "Remaining time: " + remainingSeconds + "\n" +
                "Running: " + running;
    }



}
