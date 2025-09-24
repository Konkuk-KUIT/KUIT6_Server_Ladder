package domain;

import ladderMaker.LadderMaker;
import exception.IllegalLadderNumberException;

public class LadderNumber {
    private final LadderMaker ladderMaker;
    private final int number;

    private LadderNumber(LadderMaker ladderMaker, int number) {
        this.ladderMaker = ladderMaker;
        validateNumber(number);
        this.number = number;
    }

    public static LadderNumber of(LadderMaker ladderMaker, int number) {
        return new LadderNumber(ladderMaker, number);
    }

    private void validateNumber(int number) {
        if (number <= 0 || number > ladderMaker.getNumberOfPerson()) {
            throw new IllegalLadderNumberException();
        }
    }

    public int getNumber() {
        return number;
    }
}
