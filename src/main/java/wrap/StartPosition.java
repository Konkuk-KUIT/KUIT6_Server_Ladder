package wrap;

import exceptions.InvalidStartPositionException;

public record StartPosition(int value) {

    public StartPosition {
        if (value < 0) {
            throw new InvalidStartPositionException("Node index cannot be negative: " + value);
        }
    }
}
