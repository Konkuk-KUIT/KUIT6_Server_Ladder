package ladder.position;

import ladder.exception.ErrorMessage;

import java.util.Objects;

public class Position {
    private int position;

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

    public void prev(){
        position--;
    }

    public void next(){
        position++;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 같은 객체인지 확인
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position; // 내부 값(position)을 비교
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
