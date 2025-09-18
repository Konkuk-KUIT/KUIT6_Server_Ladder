public class PlayLadderGame {
    private final Ladder ladder;

    public PlayLadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public int run(PlayerPosition startPosition) {
        if (startPosition.getPosition() < 0 || startPosition.getPosition() >= ladder.getPlayerCount()) {
            throw new IllegalArgumentException("시작 위치가 범위를 벗어났습니다: " + startPosition.getPosition());
        }

        PlayerPosition position = startPosition;
        for (int row = 0; row < ladder.getRowCount(); row++) {
            LadderLine line = ladder.getLine(row);
            position = line.move(position);

            if (position.getPosition() < 0 || position.getPosition() >= ladder.getPlayerCount()) {
                throw new IllegalStateException("이동 후 위치가 범위를 벗어났습니다: " + position.getPosition());
            }
        }
        return position.getPosition();
    }
}
