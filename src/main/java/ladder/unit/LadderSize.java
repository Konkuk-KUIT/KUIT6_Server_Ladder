package ladder.unit;

import ladder.util.GreaterThanOne;

public class LadderSize {
    private GreaterThanOne numberOfRow;
    private GreaterThanOne numberOfPerson;

    private LadderSize(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public static LadderSize of(int numberOfRows, int numberOfPerson) {
        return new LadderSize(GreaterThanOne.from(numberOfRows), GreaterThanOne.from(numberOfPerson));
    }

    public GreaterThanOne getNumberOfRow() {
        return numberOfRow;
    }
    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }
}
