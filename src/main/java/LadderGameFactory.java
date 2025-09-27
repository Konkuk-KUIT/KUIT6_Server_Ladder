public class LadderGameFactory {

    private LadderGameFactory() {
    }

    public static LadderGame createCustomLadderGame(GreaterThanOne rowCount, GreaterThanOne playerCount) {
        LadderCreator creator = new CustomLadderCreator(rowCount, playerCount);
        return new LadderGame(creator);
    }

    public static LadderGame createRandomLadderGame(GreaterThanOne rowCount, GreaterThanOne playerCount) {
        LadderCreator creator = new RandomLadderCreator(rowCount, playerCount);
        return new LadderGame(creator);
    }
}