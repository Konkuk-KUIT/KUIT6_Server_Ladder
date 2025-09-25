public class LadderCreator {
    private final Row[] rows;

    public LadderCreator(GreaterThanOne height, GreaterThanOne numberOfPerson) {
        rows = new Row[height.getNumber()];
        for(int i = 0; i < height.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public Row[] getRows() {
        return rows;
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }
}
