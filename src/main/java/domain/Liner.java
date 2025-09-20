package domain;

import direction.Direction;
import validator.HeightValidator;
import validator.LadderNumberValidator;
import validator.LinerValidator;
import validator.SequenceValidator;

public class Liner {
    private final int row;
    private final int numberOfPerson;

    public Liner(int row, int numberOfPerson) {
        LinerValidator.validateLiner(row, numberOfPerson);
        this.row = row;
        this.numberOfPerson = numberOfPerson;
    }

    public void drawLine(int left, int right, int height, int[][] rows) {
        LadderNumberValidator.validateLadderNumber(left, numberOfPerson);
        LadderNumberValidator.validateLadderNumber(right, numberOfPerson);
        SequenceValidator.validateSequence(left, right);
        HeightValidator.validateHeight(left, right, rows, height);

        rows[height - 1][left - 1] = Direction.RIGHT.getValue();
        rows[height - 1][right - 1] = Direction.LEFT.getValue();
    }

    public int getRow() {
        return row;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

}
