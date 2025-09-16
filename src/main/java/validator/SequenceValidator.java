package validator;

import exception.IllegalSequenceException;

public class SequenceValidator {
    public static void validateSequence(int left, int right) {
        if (left >= right)
            throw new IllegalSequenceException();
    }
}
