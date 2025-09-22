package domain;

import direction.Direction;
import validator.HeightValidator;
import validator.LadderNumberValidator;
import validator.SequenceValidator;

public class Ladder {
    private final Row[] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = Row.makeInitRows(row, numberOfPerson);
    }

    public void drawLine(int left, int right, int height, int numberOfPerson) {
//        LadderNumberValidator.validateLadderNumber(left, numberOfPerson);
//        LadderNumberValidator.validateLadderNumber(right, numberOfPerson);
//        SequenceValidator.validateSequence(left, right);
//        HeightValidator.validateHeight(left, right, rows, height);

        rows[height - 1].assignDirection(left - 1, Direction.RIGHT.getValue());
        rows[height - 1].assignDirection(right - 1, Direction.LEFT.getValue());
    }

    public Row[] getRows() {
        return rows;
    }
}
