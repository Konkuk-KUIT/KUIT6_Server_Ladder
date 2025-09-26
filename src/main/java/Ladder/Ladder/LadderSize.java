package Ladder.Ladder;

import Ladder.Core.GreaterThanOne;

public class LadderSize {
    private final GreaterThanOne numberOfRow;
    private final GreaterThanOne numberOfPerson;
    private final int totalSize;

    public LadderSize(GreaterThanOne rowSize, GreaterThanOne colSize) {
        this.numberOfRow = rowSize;
        this.numberOfPerson = colSize;
        this.totalSize = numberOfPerson.getNumber() * numberOfRow.getNumber();
    }

    public int randomCreatePolicyCount() {
        return (int)(totalSize * 0.3);
    }

    public GreaterThanOne getNumberOfRow() {
        return numberOfRow;
    }

    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }

    public int getTotalSize() {
        return totalSize;
    }
}
