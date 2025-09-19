package wrap;

import exceptions.InvalidNodeIndexException;

public record NodeIndex(int value) {

    public NodeIndex {
        validateRange(value);
    }

    private void validateRange(int value) {
        if (value < 0) {
            throw new InvalidNodeIndexException("Node index cannot be negative: " + value);
        }
    }

    public boolean isValidFor(PersonCount personCount) {
        return value >= personCount.getMaxLineIndex();
    }
}