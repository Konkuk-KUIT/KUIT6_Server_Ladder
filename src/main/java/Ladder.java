public class Ladder {
    // todo 사다리 책임 분배
    private final Row[] rows;

    public int getLadderInfoByPosition(Position position) {
        if (position.getX() >= rows[0].getLength() || position.getY() >= rows.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
        return rows[position.getY()].getValue(position.getX());
    }

    // todo int 타입 포장 (numberOfPerson)
    public Ladder(GreaterThanOne row, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfPerson.getNumber()];
        for (int i = 0; i < row.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position pos1, Position pos2) {
        validDrawPosition(pos1, pos2);
        rows[pos1.getY()].drawLine(pos1, pos2);
    }

    private void validDrawPosition(Position pos1, Position pos2) {
        if (pos1.getY() >= rows.length || pos2.getY() >= rows.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    public int run(int startX) {
        if (startX < 0 || startX >= rows[0].getLength()) {
            throw new ArrayIndexOutOfBoundsException(ErrorMessage.INVALID_POSITION.getMessage());
        }
        int finalX = startX;
        for (Row row : rows) {
            finalX = row.getNextPosition(finalX);
        }

        return finalX;
    }
}
