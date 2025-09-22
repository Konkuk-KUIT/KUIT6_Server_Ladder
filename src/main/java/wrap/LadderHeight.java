package wrap;

import exceptions.ErrorMessage;
import exceptions.InvalidLadderHeightException;

import java.util.Objects;

public class LadderHeight {

    private final int value;

    private LadderHeight(int value) {
        if (value <= 0) {
            throw new InvalidLadderHeightException(ErrorMessage.INVALID_LADDER_HEIGHT.getMessage());
        }
        this.value = value;
    }
    
    public static LadderHeight of(int value) {
        return new LadderHeight(value);
    }

    public int getValue() {
        return value;
    }

    public boolean isValidRow(int row) {
        return row < 0 || row >= value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight that = (LadderHeight) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "LadderHeight{" + "value=" + value + '}';
    }
}