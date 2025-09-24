public class PlayerPosition {
    private int position;

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

    public void prev() {
       position--;
    }

    public void next() {
       position++;
    }

    public int getValue() {
        return position;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }
}
