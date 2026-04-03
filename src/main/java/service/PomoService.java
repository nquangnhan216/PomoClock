package service;
import model.PomoConfig;
import model.PomoState;
import model.PomoMode;

public class PomoService {
    private PomoState state;
    private PomoConfig config;
    //chứa hành vi chức năng
    public PomoService(PomoConfig config) {
        this.config = config;
        this.state = new PomoState(PomoMode.WORK, config.getWorkDura());
    }
    public PomoState getState() {
        return state;
    }
    public void start() {
        state.setRunning(true);
    }
    public void pause() {
        state.setRunning(false);
    }
    public void reset() {
        state.setRunning(false);
        if (state.getMode() == PomoMode.WORK) {
            state.setRemainingSeconds(config.getWorkDura());
        }
        else {
            state.setRemainingSeconds(config.getBreakDura());
        }

    }
    private void switchMode() {
        state.setRunning(false);
        if (state.getMode() == PomoMode.WORK) {
            state.setMode(PomoMode.BREAK);
            state.setRemainingSeconds(config.getBreakDura());
        } else {
            state.setMode(PomoMode.WORK);
            state.setRemainingSeconds(config.getWorkDura());
        }
    }
    public void tick() {
        if (state.isRunning()) {
            if (state.getRemainingSeconds() >0) {
                state.setRemainingSeconds(state.getRemainingSeconds()-1);
            }
            else {
                switchMode();
            }
        }
    }
}
