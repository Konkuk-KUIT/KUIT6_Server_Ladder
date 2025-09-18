public class Ladder {
    private final LadderLine[] lines;
    private final int playerCount;

    public Ladder(int row, int playerCount) {
        if (row <= 0) {
            throw new IllegalArgumentException("row 개수는 1 이상이어야 합니다.");
        }
        if (playerCount < 2) {
            throw new IllegalArgumentException("참가자는 최소 2명 이상이어야 합니다.");
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
