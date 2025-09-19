package wrap;

import exceptions.ErrorMessage;
import exceptions.InvalidLadderHeightException;

public record LadderHeight(int value) {
    public LadderHeight {
        if (value <= 0) {
            throw new InvalidLadderHeightException(ErrorMessage.INVALID_LADDER_HEIGHT.getMessage());
        }
    }

    public boolean isValidRow(int row) {
        return row < 0 || row >= value;
    }
}
