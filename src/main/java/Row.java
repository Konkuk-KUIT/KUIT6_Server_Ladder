public class Row {

    private final Node[] row;

    public Row(GreaterThanOne numberOfPerson) {
        row = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            row[i] = Node.from(0);
        }
    }

    public int getLength() {
        return row.length;
    }

    public int getValue(int x) {
        return row[x].getValue();
    }

    public void drawLine(Position pos1, Position pos2) {
        validDrawPosition(pos1, pos2);
        row[pos1.getX()].computeDirection(pos1, pos2);
        row[pos2.getX()].computeDirection(pos2, pos1);
    }

    private void validDrawPosition(Position pos1, Position pos2) {
        if (pos1.getY() != pos2.getY() || pos1.getX() == pos2.getX()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
        if (pos1.getX() >= row.length || pos2.getX() >= row.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    public int getNextPosition(int xPos) {
        return (xPos + row[xPos].getValue());
    }
}