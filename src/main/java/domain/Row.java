package domain;

import direction.Direction;

public class Row {
    private final int[] nodes;

    public Row(int numberOfPerson) {
        this.nodes = new int[numberOfPerson];
        makeInitNodes(numberOfPerson);
    }

    public static Row[] makeInitRows(int row, int numberOfPerson) {
        Row[] rows = new Row[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new Row(numberOfPerson);
        }
        return rows;
    }

    public void makeInitNodes(int numberOfPerson) {
        for (int i = 0; i < numberOfPerson; i++) {
            nodes[i] = Direction.NONE.getValue();
        }
    }

    @Override
    public String toString() {
        StringBuilder rowString = new StringBuilder();
        for (int node : nodes) {
            rowString.append(getStringByNodeValue(node));
        }
        rowString.append("\n");
        return rowString.toString();
    }

    private String getStringByNodeValue(int node) {
        if (node == Direction.RIGHT.getValue()) {
            return "|—";
        }
        return "| ";
    }

    public String getStringPoint(int col) {
        StringBuilder str = new StringBuilder(toString());
        str.setCharAt(2 * col, '*');
        return str.toString();
    }

    public void assignDirection(int index, int direction) {
        nodes[index] = direction;
    }

    public int getNodeValue(int index) {
        return nodes[index];
    }
}