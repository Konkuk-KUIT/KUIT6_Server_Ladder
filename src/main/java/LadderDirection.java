public enum LadderDirection {
    Left(-1),
    Right(1),
    None(0);

    private final int direction;
    LadderDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
