package domain;

import laddermaker.LadderMaker;
import exception.IllegalLadderNumberException;

public class LadderNumber {
    private final int number;

    private LadderNumber(int number) {
        this.number = number;
    }

    public static LadderNumber of(LadderMaker ladderMaker, int number) {
        validateNumber(number, ladderMaker.getNumberOfPerson());
        return new LadderNumber(number);
    }

    private static void validateNumber(int number, int numberOfPerson) {
        if (number <= 0 || number > numberOfPerson) {
            throw new IllegalLadderNumberException();
        }
    }

    public int getNumber() {
        return number;
    }
}
