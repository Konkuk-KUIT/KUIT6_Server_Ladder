public class Row {
    // todo Node 객체 도입
    private final int[] row;

    public Row(GreaterThanOne numberOfPerson) {
        row = new int[numberOfPerson.getNumber()];
    }

    public int getLength() {
        return row.length;
    }

    public int getValue(int x) {
        return row[x];
    }

    public void drawLine(int xPos1, int xPos2) {
        row[xPos1] = xPos2 - xPos1;
        row[xPos2] = xPos1 - xPos2;
    }

    public int getNextPosition(int xPos) {
        return (xPos + row[xPos]);
    }
}
