package domain;

public class LadderGame {
    private final Liner liner;

    private LadderGame(Liner liner) {
        this.liner = liner;
    }

    public static LadderGame from(Liner liner) {
        return new LadderGame(liner);
    }

    public int run(int ladderNum) {
        Ladder ladder = liner.getLadder();
        LadderRunner ladderRunner = new LadderRunner(ladder.getRows(), liner.getNumberOfPerson());

        return ladderRunner.run(ladderNum);
    }
}
