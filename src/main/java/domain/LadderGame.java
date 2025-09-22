package domain;

import LadderMaker.LadderMaker;

public class LadderGame {
    private final LadderMaker ladderMaker;

    private LadderGame(LadderMaker ladderMaker) {
        this.ladderMaker = ladderMaker;
    }

    public static LadderGame from(LadderMaker ladderMaker) {
        return new LadderGame(ladderMaker);
    }

    public int run(int ladderNum) {
        Ladder ladder = ladderMaker.getLadder();
        LadderRunner ladderRunner = new LadderRunner(ladder.getRows(), ladderMaker.getNumberOfPerson());

        return ladderRunner.run(ladderNum);
    }
}
