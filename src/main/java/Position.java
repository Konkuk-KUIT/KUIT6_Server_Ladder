public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Invalid position");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
