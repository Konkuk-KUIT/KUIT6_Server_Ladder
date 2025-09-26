package ladder.creator;
import ladder.core.LadderGame;

public final class LadderGameFactory {
    private LadderGameFactory() {}

    public static LadderGame randomLadderGame(LadderSize size, long seed) {
        LadderCreatorPort creator = new RandomLadderCreator(size, seed);
        return new LadderGame(creator);
    }

    public static LadderGame customLadderGame(LadderSize size) {
        LadderCreatorPort creator =
                new CustomLadderCreator(size.rowsAsGTO(), size.colsAsGTO());
        return new LadderGame(creator);
    }

    public static LadderGame of(LadderCreatorPort creator) {
        return new LadderGame(creator);
    }
}
