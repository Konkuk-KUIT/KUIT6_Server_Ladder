package game;

import LadderMaker.LadderMaker;
import domain.Ladder;
import domain.LadderNumber;

public class LadderGame {
    private final LadderMaker ladderMaker;

    private LadderGame(LadderMaker ladderMaker) {
        this.ladderMaker = ladderMaker;
    }

    public static LadderGame from(LadderMaker ladderMaker) {
        return new LadderGame(ladderMaker);
    }

    public int run(LadderNumber ladderNum) {
        Ladder ladder = ladderMaker.getLadder();
        LadderRunner ladderRunner = LadderRunner.from(ladder);

        return ladderRunner.run(ladderNum);
    }
}
