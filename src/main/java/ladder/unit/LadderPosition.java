package ladder.unit;

import java.util.Objects;

public class LadderPosition {
    private Position row;
    private Position position;

    private LadderPosition(Position row, Position position) {
        this.row = row;
        this.position = position;
    }

    public static LadderPosition of(int row, Position position) {
        return new LadderPosition(Position.from(row), position);
    }

    public int getPosition(){
        return this.position.getValue();
    }

    public int getRow(){
        return this.row.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {return false;}
        LadderPosition that = (LadderPosition) o;
        return row.getValue() == that.row.getValue() && position.getValue() == that.position.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, position);
    }
}
