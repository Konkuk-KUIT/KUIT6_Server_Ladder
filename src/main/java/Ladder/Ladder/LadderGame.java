package Ladder.Ladder;

import Ladder.Core.Position;
import Ladder.Core.Row;
import Ladder.Creator.LadderCreator;

public class LadderGame {
    LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position startPosition) {
        Row[] rows = ladderCreator.getRows();
        LadderRunner ladderRunner = new LadderRunner(rows);
        return ladderRunner.run(startPosition);
    }
}
