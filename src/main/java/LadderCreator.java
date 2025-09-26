import java.util.Arrays;

public class LadderCreator implements LadderProvider {
    private final int height;
    private final int numberOfPerson;
    private final Row[] rows;

    public LadderCreator(int height, int numberOfPerson) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive.");
        }
        if (numberOfPerson < 2) {
            throw new IllegalArgumentException("Ladder requires at least two participants.");
        }
        this.height = height;
        this.numberOfPerson = numberOfPerson;
        this.rows = new Row[height];
        for (int i = 0; i < height; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void placeBridge(int rowIndex, int columnIndex) {
        validateRowIndex(rowIndex);
        rows[rowIndex].placeBridge(columnIndex);
    }

    public Ladder toLadder() {
        Row[] snapshot = new Row[rows.length];
        for (int i = 0; i < rows.length; i++) {
            snapshot[i] = rows[i].snapshot();
        }
        return new Ladder(snapshot, numberOfPerson);
    }

    @Override
    public Ladder provide() {
        return toLadder();
    }

    Row[] getRows() {
        return Arrays.copyOf(rows, rows.length);
    }

    private void validateRowIndex(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= rows.length) {
            throw new IllegalArgumentException("Row index out of bounds: " + rowIndex);
        }
    }
}