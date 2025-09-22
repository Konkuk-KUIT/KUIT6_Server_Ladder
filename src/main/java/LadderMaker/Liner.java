package LadderMaker;

import domain.Ladder;
import validator.HeightValidator;
import validator.LadderNumberValidator;
import validator.LinerValidator;
import validator.SequenceValidator;

public class Liner implements LadderMaker {
    private final int row;
    private final int numberOfPerson;
    private final Ladder ladder;

    public Liner(int row, int numberOfPerson) {
        LinerValidator.validateLiner(row, numberOfPerson);
        this.row = row;
        this.numberOfPerson = numberOfPerson;
        this.ladder = makeLadder(this.row, this.numberOfPerson);
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

        ladder.drawLine(left, right, height, numberOfPerson);
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
