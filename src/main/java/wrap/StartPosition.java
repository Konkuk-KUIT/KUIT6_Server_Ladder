package wrap;

import exceptions.InvalidStartPositionException;

public class StartPosition {

    private final int value;

    private StartPosition(int value) {
        if (value < 0) {
            throw new InvalidStartPositionException("Node index cannot be negative: " + value);
        }
        this.value = value;
    }
    
    public static StartPosition at(int value) {
        return new StartPosition(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StartPosition that = (StartPosition) obj;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return "StartPosition{" + "value=" + value + '}';
    }
}