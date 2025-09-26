package ladder.domain;

import java.util.Objects;

public class LadderPosition {

    private final Position row;
    private final Position col;

    public LadderPosition(Position row, Position col) {
        this.row = row;
        this.col = col;
    }

    public Position getRow() {
        return row;
    }

    public Position getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return row == ((LadderPosition) obj).row && col == ((LadderPosition) obj).col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
