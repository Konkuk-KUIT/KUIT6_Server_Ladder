package laddermaker;

import domain.Ladder;
import domain.LadderNumber;
import exception.IllegalLinerException;
import exception.IllegalSequenceException;

public class Liner implements LadderMaker {
    private final int row;
    private final int numberOfPerson;
    private final Ladder ladder;

    public Liner(int row, int numberOfPerson) {
        validateLiner(row, numberOfPerson);
        this.row = row;
        this.numberOfPerson = numberOfPerson;
        this.ladder = new Ladder(row, numberOfPerson);
    }

    @Override
    public void validateLiner(int row, int numberOfPerson) {
        if (row <= 0 || numberOfPerson <= 1)
            throw new IllegalLinerException();
    }

    @Override
    public void drawLine(LadderNumber left, LadderNumber right, int height) {
        validateSequence(left, right);

        ladder.drawLine(left, right, height);
    }

    private void validateSequence(LadderNumber left, LadderNumber right) {
        if (right.getNumber() - left.getNumber() != 1) {
            throw new IllegalSequenceException();
        }
    }

    @Override
    public Ladder getLadder() {
        return ladder;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }
}
