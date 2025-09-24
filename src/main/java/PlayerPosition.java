public class PlayerPosition {
    private final int position;

    private PlayerPosition(int position) {
        this.position = position;
    }

    public static PlayerPosition from(int position) {
        validatePosition(position);
        return new PlayerPosition(position);
    }

    private static void validatePosition(int position) {
        if (!isPosition(position)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }

    public PlayerPosition prev() {
        return new PlayerPosition(position-1);
    }

    public PlayerPosition next() {
        return new PlayerPosition(position+1);
    }

    public int getValue() {
        return position;
    }
}
