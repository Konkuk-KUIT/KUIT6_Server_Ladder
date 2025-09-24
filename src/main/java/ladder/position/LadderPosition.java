package ladder.position;

import java.util.Objects;

public class LadderPosition {

    // 원래는 하나의 row에서 position값으로 LEFT/RIGHT의 이동만 결정했지만
    // 이제는 *을 찍기 위해 row,col 모두 필요

    private final Position row;
    private final Position col;
    private LadderPosition(Position row, Position col) {
        this.row = row;
        this.col = col;
    }

    // row와 col 2개의 값을 받기 때문에 from이 아니라 of 선택

    public static LadderPosition of(Position row, Position col) {
        return new LadderPosition(row, col);
    }

    public Position getRow() {
        return row;
    }

    public Position getCol() {
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
