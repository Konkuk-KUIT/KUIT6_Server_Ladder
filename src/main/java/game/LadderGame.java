package game;

import LadderMaker.LadderMaker;
import domain.Ladder;
import validator.LadderNumberValidator;

public class LadderGame {
    private final LadderMaker ladderMaker;

    private LadderGame(LadderMaker ladderMaker) {
        this.ladderMaker = ladderMaker;
    }

    public static LadderGame from(LadderMaker ladderMaker) {
        return new LadderGame(ladderMaker);
    }

    public int run(int ladderNum) {
        LadderNumberValidator.validateLadderNumber(ladderNum, ladderMaker.getNumberOfPerson());
        Ladder ladder = ladderMaker.getLadder();
        LadderRunner ladderRunner = new LadderRunner(ladder.getRows());

        return ladderRunner.run(ladderNum);
    }
}
