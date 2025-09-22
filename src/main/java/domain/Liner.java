package domain;

import validator.LinerValidator;

public class Liner implements LadderMaker{
    private final int row;
    private final int numberOfPerson;
    private final Ladder ladder;

    public Liner(int row, int numberOfPerson) {
        LinerValidator.validateLiner(row, numberOfPerson);
        this.row = row;
        this.numberOfPerson = numberOfPerson;
        this.ladder = makeLadder(this.row, this.numberOfPerson);
    }

    public Ladder makeLadder(int row, int numberOfPerson) {
        return new Ladder(row, numberOfPerson);
    }

    public void drawLine(int left, int right, int height) {
        ladder.drawLine(left, right, height, numberOfPerson);
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
