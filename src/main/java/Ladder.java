public class Ladder {
    private final LadderLine[] lines;
    private final GreaterThanOne playerCount;

    public Ladder(GreaterThanOne row, GreaterThanOne playerCount) {
        if (row.getNumber() < 2 || playerCount.getNumber() < 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_NUMBER.getMessage());
        }

        this.playerCount = playerCount;
        this.lines = new LadderLine[row.getNumber()];

        for (int i = 0; i < row.getNumber(); i++) {
            lines[i] = new LadderLine(playerCount);
        }
    }

    public void drawLine(int row, int column) {
        lines[row].drawLine(column);
    }

    public int getRowCount() {
        return lines.length;
    }

    public int getPlayerCount() {
        return playerCount.getNumber();
    }

    public LadderLine getLine(int row) {
        return lines[row];
    }
}
