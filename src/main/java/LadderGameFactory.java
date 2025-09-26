public class LadderGameFactory {
    public static LadderProvider createNormalLadderGame(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        return new NormalLadderCreator(numberOfRows, numberOfPerson);
    }

    public static LadderProvider createRandomLadderGame(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        return new RandomLadderCreator(numberOfRows, numberOfPerson);
    }
}
