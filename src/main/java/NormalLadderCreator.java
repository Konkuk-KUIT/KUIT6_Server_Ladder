public class NormalLadderCreator implements LadderProvider {
    private final Row[] rows;

    public int getLadderInfoByPosition(Position position) {
        validLadderBound(position);
        return rows[position.getY()].getValue(position.getX());
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    public NormalLadderCreator(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRows.getNumber()];
        for (int i = 0; i < numberOfRows.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position pos1, Position pos2) {
        validDrawPosition(pos1, pos2);
        rows[pos1.getY()].drawLine(pos1, pos2);
    }

    // valid methods
    private void validLadderBound(Position position) {
        if (position.getX() >= rows[0].getLength() || position.getY() >= rows.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validDrawPosition(Position pos1, Position pos2) {
        if (pos1.getY() >= rows.length || pos2.getY() >= rows.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }
}
