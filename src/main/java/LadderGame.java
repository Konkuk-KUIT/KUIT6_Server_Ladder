public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(int column) {
        int[][] rows = ladderCreator.getRows();

        LadderRunner ladderRunner = new LadderRunner(rows);

        return ladderRunner.run(column);
    }
}
