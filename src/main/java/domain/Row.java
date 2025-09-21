package domain;

public class Row {
    private final int[] nodes;

    public Row(int numberOfPerson) {
        this.nodes = new int[numberOfPerson];
    }

    public static Row[] makeInitRows(int row, int numberOfPerson) {
        Row[] rows = new Row[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new Row(numberOfPerson);
        }
        return rows;
    }

    public void assignDirection(int index, int direction) {
        nodes[index] = direction;
    }

    public int getNodeValue(int index) {
        return nodes[index];
    }
}