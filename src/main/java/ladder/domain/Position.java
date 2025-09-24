package ladder.domain;

import ladder.support.ErrorMessage;

public class Position {
    private final int position; // 불변 객체로 변경

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        validatePosition(position);
        return new Position(position);
    }

    private static void validatePosition(int position) {
        if (!isPosition(position)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }

    public int getValue() {
        return position;
    }

    public Position prev() {
        int newPosition = position - 1;
        validatePosition(newPosition); // 음수면 예외
        return new Position(newPosition);
    }

    public Position next() {
        return new Position(position + 1);
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }


}
