public class ManualLadderCreator implements LadderCreator{
    private final Row[] rows;

    public LadderSize getLadderSize() {
        return ladderSize;
    }

    private LadderSize ladderSize;

    public ManualLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        this.rows = new Row[ladderSize.getRow().getNumber()];
        for (int i = 0; i < ladderSize.getRow().getNumber(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }

    public void drawLine(Position row, Position col){
        rows[row.getValue()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }
}
