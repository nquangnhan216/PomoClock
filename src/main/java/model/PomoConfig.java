package model;

public class PomoConfig {
    private int workDuraSec;
    private int breakDuraSec;

    //chứa settings
    public PomoConfig(int workDuraSec, int breakDuraSec) {
        this.workDuraSec = workDuraSec;
        this.breakDuraSec = breakDuraSec;
    }
    public void setWorkDura(int workDura) {
        this.workDuraSec = workDura;
    }
    public void setBreakDura(int breakDura) {
        this.breakDuraSec = breakDura;
    }
    public int getWorkDura() {
        return workDuraSec;
    }
    public int getBreakDura() {
        return breakDuraSec;
    }
}
