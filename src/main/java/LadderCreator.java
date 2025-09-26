public class LadderCreator {
    private final Row[] rows;

    public LadderCreator(GreaterThanOne height, GreaterThanOne numberOfPerson) {
        rows = new Row[height.getNumber()];
        for(int i = 0; i < height.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public Row[] getLadder() {
        return rows;
    }

    public GreaterThanOne getHeight() {
        return GreaterThanOne.from(rows.length);
    }

    public GreaterThanOne getNumberOfPerson() {
        return GreaterThanOne.from(rows[0].getNodeLength());
    }

    public Row getLadderRow(int row) {
        return rows[row];
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }
}
