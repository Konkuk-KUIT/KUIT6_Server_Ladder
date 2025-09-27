public class CustomLadderCreator implements LadderCreator {
    private final LadderLine[] rows;

    public CustomLadderCreator(GreaterThanOne rowCount, GreaterThanOne playerCount) {
        rows = new LadderLine[rowCount.getNumber()];
        for (int i = 0; i < rowCount.getNumber(); i++) {
            rows[i] = new LadderLine(playerCount);
        }
    }

    @Override
    public LadderLine[] getRows() {
        return rows;
    }

    @Override
    public void drawLine(PlayerPosition row, PlayerPosition col) {
        rows[row.getValue()].drawLine(col);
    }
}