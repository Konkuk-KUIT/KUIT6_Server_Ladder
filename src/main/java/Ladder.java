public class Ladder {
    private final LadderLine[] lines;
    private final int playerCount;

    public Ladder(int row, int playerCount) {
        if (row < 2 || playerCount < 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_NUMBER.getMessage());
        }

        this.playerCount = playerCount;
        this.lines = new LadderLine[row];

        for (int i = 0; i < row; i++) {
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
        return playerCount;
    }

    public LadderLine getLine(int row) {
        return lines[row];
    }
}
