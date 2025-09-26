import java.util.Objects;

public class PlayerPosition {
    private int position;

    private PlayerPosition(int position) {
        this.position = position;
    }

    public static PlayerPosition from(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_POSITION.getMessage());
        }
        return new PlayerPosition(position);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerPosition that)) return false;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}