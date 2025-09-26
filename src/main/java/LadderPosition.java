import java.util.Objects;

public class LadderPosition {


    private final PlayerPosition row;
    private final PlayerPosition col;
    private LadderPosition(PlayerPosition row, PlayerPosition col) {
        this.row = row;
        this.col = col;
    }

    public static LadderPosition of(PlayerPosition row, PlayerPosition col) {
        return new LadderPosition(row, col);
    }

    public PlayerPosition getRow() {
        return row;
    }

    public PlayerPosition getCol() {
        return col;
    }

    public int getRowPosition() {
        return row.getValue();
    }

    public int getColPosition() {
        return col.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderPosition that = (LadderPosition) o;
        return Objects.equals(row, that.row) && Objects.equals(col, that.col);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);

    }
}