public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        validatePosition(x, y);
        this.x = x;
        this.y = y;
    }

    public static Position from(int x, int y) {
        return new Position(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private static void validatePosition(int x, int y) {
        if (!isPosition(x, y)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int x, int y) {
        return x >= 0 && y >= 0;
    }
}
