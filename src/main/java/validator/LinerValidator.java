package validator;

import exception.IllegalLinerException;

public class LinerValidator {
    public static void validateLiner(int row, int numberOfPerson) {
        if (row <= 0 || numberOfPerson <= 1)
            throw new IllegalLinerException();
    }
}
