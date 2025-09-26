public class LadderGame {
    private final LadderCreator ladderCreator;
    //private final LadderViewer viewer = new LadderViewer();
    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }
    public void addLine(int row, int col) {
        ladderCreator.drawline(row, col);
    }

    public Row[] getLadderRows() {
        return ladderCreator.getRows();
    }
}