public class Ladder {
    // todo 사다리 책임 분배
    private final Row[] rows;

    public int getLadderInfoByPosition(Position position) {
        if (position.getX() >= rows[0].getLength() || position.getY() >= rows.length) {
            throw new IllegalArgumentException("Invalid position");
        }
        return rows[position.getY()].getValue(position.getX());
    }

    // todo int 타입 포장 (numberOfPerson)
    public Ladder(int row, int numberOfPerson) {
        rows = new Row[numberOfPerson];
        for (int i = 0; i < row; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position pos1, Position pos2) {
        if (pos1.getY() != pos2.getY() || pos1.getX() == pos2.getX()) {
            throw new IllegalArgumentException("Invalid position");
        }
        rows[pos1.getY()].drawLine(pos1.getX(), pos2.getX());
    }

    // todo int 타입 포장 (startX)
    public int run(int startX) {
        if (startX < 0 || startX >= rows[0].getLength()) {
            throw new ArrayIndexOutOfBoundsException("Invalid start position");
        }
        int finalX = startX;
        for (Row row : rows) {
            finalX = row.getNextPosition(finalX);
        }

        return finalX;
    }
}
