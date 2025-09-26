package ladder.domain;

import ladder.validator.GreaterThanOne;

public final class LadderSize {
    private final GreaterThanOne numberOfRows;
    private final GreaterThanOne numberOfPerson;

    public LadderSize(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        this.numberOfRows = numberOfRows;
        this.numberOfPerson = numberOfPerson;
    }

    public GreaterThanOne getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfRowsValue() {
        return numberOfRows.getNumber();
    }

    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }
}