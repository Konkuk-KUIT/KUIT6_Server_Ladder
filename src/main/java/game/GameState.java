package game;

public enum GameState {
    BEFORE("Before"),
    AFTER("After");

    private final String state;

    public String getState() {
        return state;
    }

    GameState(String state) {
        this.state = state;
    }
}
