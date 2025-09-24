package domain;

import exception.IllegalHeightException;

public class Ladder {
    private final Row[] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = Row.makeInitRows(row, numberOfPerson);
    }

    public void drawLine(int left, int right, int height) {
        validateHeight(left, right, height);
        rows[height - 1].assignDirection(left - 1, Direction.RIGHT.getValue());
        rows[height - 1].assignDirection(right - 1, Direction.LEFT.getValue());
    }

    public Row[] getRows() {
        return rows;
    }

    private void validateHeight(int left, int right, int height) {
        if (height <= 0) throw new IllegalHeightException();
        if (height > rows.length) throw new IllegalHeightException();
        if (rows[height - 1].getNodeValue(left - 1) != Direction.NONE.getValue()
                || rows[height - 1].getNodeValue(right - 1) != Direction.NONE.getValue()) {
            throw new IllegalHeightException();
        }
    }
}
