package Ladder.Core;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        validatePosition(position);
        return new Position((position));
    }

    private static void validatePosition(int position) {
        if(!isPosition(position)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }

    // 다양한 값을 정의하면 나중에 사용할 때 혼란, value로 통일한다
    public int getValue() {
        return position;
    }

    public void prev() {
        position--;
    }

    public void next() {
        position++;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }
}
