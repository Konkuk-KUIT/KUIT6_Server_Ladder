package Ladder.Ladder;

import Ladder.Core.Position;

public class LadderPosition {
    private final Position rowPosition;
    private final Position colPosition;

    private LadderPosition(Position rowPosition, Position colPosition) {
        this.rowPosition = rowPosition;
        this.colPosition = colPosition;
    }

    public static LadderPosition currentPosition(Position rowPosition, Position colPosition) {
        return new LadderPosition(rowPosition, colPosition);
    }

    public boolean isEqual(Position rowPosition, Position colPosition) {
        return isSamePosition(rowPosition, colPosition);
    }

    private boolean isSamePosition(Position rowPosition, Position colPosition) {
        return rowPosition.getValue() == this.rowPosition.getValue()
                && colPosition.getValue() == this.colPosition.getValue();
    }

    public Position getRowPosition() {
        return rowPosition;
    }

    public Position getColPosition() {
        return colPosition;
    }
}
