package domain;

public class Row {
    private final int[] row;

    public Row(int numberOfPerson) {
        this.row = new int[numberOfPerson];
    }

    public int[] getRow() {
        return row;
    }
}
