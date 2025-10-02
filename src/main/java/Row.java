import java.util.Arrays;

public final class Row {
    private final boolean[] bridges;

    Row(int numberOfPerson) {
        if (numberOfPerson < 2) {
            throw new IllegalArgumentException("Row requires at least two participants.");
        }
        this.bridges = new boolean[numberOfPerson - 1];
    }

    private Row(boolean[] bridges) {
        this.bridges = bridges;
    }

    void placeBridge(int columnIndex) {
        validateColumnIndex(columnIndex);
        if (bridges[columnIndex]) {
            throw new IllegalStateException("Bridge already exists at column " + columnIndex);
        }
        if (columnIndex > 0 && bridges[columnIndex - 1]) {
            throw new IllegalStateException("Adjacent bridge exists to the left of column " + columnIndex);
        }
        if (columnIndex < bridges.length - 1 && bridges[columnIndex + 1]) {
            throw new IllegalStateException("Adjacent bridge exists to the right of column " + columnIndex);
        }
        bridges[columnIndex] = true;
    }

    public boolean connectsToRightFrom(int position) {
        validatePosition(position);
        return position < bridges.length && bridges[position];
    }

    public boolean connectsToLeftFrom(int position) {
        validatePosition(position);
        return position > 0 && bridges[position - 1];
    }

    public int width() {
        return bridges.length + 1;
    }

    Row snapshot() {
        return new Row(Arrays.copyOf(bridges, bridges.length));
    }

    private void validateColumnIndex(int columnIndex) {
        if (columnIndex < 0 || columnIndex >= bridges.length) {
            throw new IllegalArgumentException("Column index out of bounds: " + columnIndex);
        }
    }

    private void validatePosition(int position) {
        if (position < 0 || position >= width()) {
            throw new IllegalArgumentException("Position out of bounds: " + position);
        }
    }
}