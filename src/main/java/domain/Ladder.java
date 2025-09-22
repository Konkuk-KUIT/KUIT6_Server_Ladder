package domain;

import direction.Direction;

public class Ladder {
    private final Row[] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = Row.makeInitRows(row, numberOfPerson);
    }

    public void drawLine(int left, int right, int height) {
        rows[height - 1].assignDirection(left - 1, Direction.RIGHT.getValue());
        rows[height - 1].assignDirection(right - 1, Direction.LEFT.getValue());
    }

    public Row[] getRows() {
        return rows;
    }
}
