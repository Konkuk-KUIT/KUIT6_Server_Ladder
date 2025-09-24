package wrap;

import exceptions.InvalidNodeIndexException;

public class NodeIndex {

    private final int value;

    private NodeIndex(int value) {
        validateRange(value);
        this.value = value;
    }
    
    public static NodeIndex at(int value) {
        return new NodeIndex(value);
    }

    private void validateRange(int value) {
        if (value < 0) {
            throw new InvalidNodeIndexException("Node index cannot be negative: " + value);
        }
    }

    public int getValue() {
        return value;
    }

    public boolean isValidFor(PersonCount personCount) {
        return value >= personCount.getMaxLineIndex();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NodeIndex that = (NodeIndex) obj;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return "NodeIndex{" + "value=" + value + '}';
    }
}