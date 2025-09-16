package wrap;

import exceptions.InvalidPersonCountException;
import exceptions.ErrorMessage;

public class PersonCount {

    private final int value;

    public PersonCount(int value) {
        if (value <= 0) {
            throw new InvalidPersonCountException(ErrorMessage.INVALID_PERSON_COUNT.getMessage());
        };
        this.value = value;
    }

    public int getMaxLineIndex() {
        return value - 1;
    }
    
    public boolean isValidStartPosition(int startPosition) {
        return startPosition >= 0 && startPosition < value;
    }
    
    public boolean isValidLineIndex(int lineIndex) {
        return lineIndex >= 0 && lineIndex < getMaxLineIndex();
    }
    
    public int getValue() {
        return value;
    }
}
