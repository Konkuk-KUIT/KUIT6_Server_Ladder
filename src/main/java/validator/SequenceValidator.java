package validator;

import exception.IllegalSequenceException;

public class SequenceValidator {
    public static void validateSequence(int left, int right) {
        if (right - left != 1)
            throw new IllegalSequenceException();
    }
}
