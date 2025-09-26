package ladder.core;
import ladder.creator.LadderCreatorPort;
import ladder.position.LadderPosition;
import ladder.position.Position;

public class LadderGame {
    private final LadderCreatorPort ladderCreator;

    public LadderGame(LadderCreatorPort ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(LadderPosition start) {
        Row[] rows = ladderCreator.getRows();
        LadderRunner runner = new LadderRunner(rows);
        return runner.run(start);
    }

    public void drawLine(Position row, Position col) {
        ladderCreator.drawLine(row, col);
    }

    public Row[] getRows() {
        return ladderCreator.getRows();
    }
}


