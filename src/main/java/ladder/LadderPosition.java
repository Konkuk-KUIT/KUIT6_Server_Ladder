package ladder;

import java.util.Objects;

public class LadderPosition {
    private final int row;
    private final int col;

    public LadderPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof LadderPosition ladderPosition) {
            return this.row == ladderPosition.row && this.col == ladderPosition.col;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.row, this.col);
    }
}
