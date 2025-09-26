public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(LadderCreator ladderCreator) {
        return new LadderGame(ladderCreator);
    }
}
