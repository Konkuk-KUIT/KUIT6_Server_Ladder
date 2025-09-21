package validator;

import exception.IllegalLadderNumberException;

public class LadderNumberValidator {
    public static void validateLadderNumber(int ladderNumber, int numberOfPerson) {
        if (ladderNumber > numberOfPerson || ladderNumber <= 0) {
            throw new IllegalLadderNumberException();
        }
    }
}
