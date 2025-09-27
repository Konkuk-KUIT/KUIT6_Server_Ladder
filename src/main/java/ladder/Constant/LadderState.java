package ladder.Constant;

public enum LadderState {
    LADDER_STATE_BEFORE("before"),
    LADDER_STATE_AFTER("after");

    private final String state;

    LadderState(String message) {
        this.state = message;
    }

    public String getMessage() {
        return state;
    }
}
