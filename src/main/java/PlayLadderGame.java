public class PlayLadderGame {
    private final Ladder ladder;

    public PlayLadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public int run(PlayerPosition startPosition) {
        PlayerPosition position = startPosition;
        for (int row = 0; row < ladder.getRowCount(); row++) {
            LadderLine line = ladder.getLine(row);
            position = line.move(position);
        }
        return position.getValue();
    }
}
