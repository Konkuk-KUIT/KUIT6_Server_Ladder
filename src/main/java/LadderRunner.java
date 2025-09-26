public class LadderRunner {
    private final Ladder ladder;
    private final LadderViewer ladderViewer;

    public LadderRunner(Ladder ladder, LadderViewer ladderViewer) {
        this.ladder = ladder;
        this.ladderViewer = ladderViewer;
    }
    public void run(int startCol) {
        int position = startCol;
        Row[] rows = ladder.getRows();

        for (int i = 0; i < rows.length; i++) {
            ladderViewer.printLadder(rows, new LadderPosition(i, position));
            position = rows[i].nextPosition(position);
        }
        ladderViewer.printLadder(rows, new LadderPosition(rows.length, position));
    }
}

