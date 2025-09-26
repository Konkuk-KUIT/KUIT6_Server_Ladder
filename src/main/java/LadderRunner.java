public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(int startX) {
        validStartPosition(startX);

        LadderViewer ladderViewer = new LadderViewer(rows);

        int finalX = startX;
        for (int i = 0; i < rows.length; i++) {
            Position beforePosition = Position.from(finalX, i);
            finalX = rows[i].getNextPosition(finalX);
            Position afterPosition = Position.from(finalX, i);

            ladderViewer.drawLadder(beforePosition, afterPosition);
        }

        return finalX;
    }

    // valid methods
    private void validStartPosition(int startX) {
        if (startX < 0 || startX >= rows[0].getLength()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }
}
