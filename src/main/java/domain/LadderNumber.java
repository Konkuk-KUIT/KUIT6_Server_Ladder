package domain;

import exception.IllegalLadderNumberException;

public class LadderNumber {
    private final int number;

    private LadderNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LadderNumber from(int number) {
        return new LadderNumber(number);
    }

    private void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalLadderNumberException();
        }
    }

    public int getNumber() {
        return number;
    }
}
