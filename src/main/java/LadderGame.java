public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator){
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position){
        Row[] rows = ladderCreator.getRows();

        LadderRunner ladderRunner = new LadderRunner(rows);

        return ladderRunner.run(position);
    }
}
