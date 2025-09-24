package LadderMaker;

import domain.Ladder;
import exception.IllegalLinerException;
import validator.HeightValidator;
import validator.LadderNumberValidator;
import validator.SequenceValidator;

public class Liner implements LadderMaker {
    private final int row;
    private final int numberOfPerson;
    private final Ladder ladder;

    public Liner(int row, int numberOfPerson) {
        validateLiner(row, numberOfPerson);
        this.row = row;
        this.numberOfPerson = numberOfPerson;
        this.ladder = makeLadder(this.row, this.numberOfPerson);
    }

    @Override
    public void validateLiner(int row, int numberOfPerson) {
        if (row <= 0 || numberOfPerson <= 1)
            throw new IllegalLinerException();
    }

    @Override
    public Ladder makeLadder(int row, int numberOfPerson) {
        return new Ladder(row, numberOfPerson);
    }

    @Override
    public void drawLine(int left, int right, int height) {
        LadderNumberValidator.validateLadderNumber(left, numberOfPerson);
        LadderNumberValidator.validateLadderNumber(right, numberOfPerson);
        SequenceValidator.validateSequence(left, right);
        HeightValidator.validateHeight(left, right, ladder.getRows(), height);

        ladder.drawLine(left, right, height);
    }

    @Override
    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    @Override
    public Ladder getLadder() {
        return ladder;
    }
}
