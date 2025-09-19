package wrap;

import exceptions.ErrorMessage;
import exceptions.InvalidLadderHeightException;

public class LadderHeight {
    private final int value;

    public LadderHeight(int value) {
        if (value <= 0) {
            throw new InvalidLadderHeightException(ErrorMessage.INVALID_LADDER_HEIGHT.getMessage());
        }
        this.value = value;
    }

    public boolean isValidRow(int row) {
        return row >= 0 && row < value;
    }
    
    public int getValue() {
        return value;
    }
}
