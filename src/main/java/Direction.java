public enum Direction {
    LEFT(1),
    RIGHT(2);
    private final int direction;
    Direction(int direction) {
        this.direction = direction;
    }

    public int getValue() {
        return direction;
    }
}
