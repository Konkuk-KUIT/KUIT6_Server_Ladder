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

    public void drawLine(Position pos1, Position pos2) {
        if (pos1.getY() != pos2.getY() || pos1.getX() == pos2.getX()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
        row[pos1.getX()] = pos2.getX() - pos1.getX();
        row[pos2.getX()] = pos1.getX() - pos2.getX();
    }

    public int getNextPosition(int xPos) {
        return (xPos + row[xPos]);
    }
}