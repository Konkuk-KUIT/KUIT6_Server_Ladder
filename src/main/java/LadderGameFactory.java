public class LadderGameFactory {
    public static LadderGame randomLadderGame(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        LadderCreator creator = new RandomLadderCreator(numberOfRow, numberOfPerson);
        return new LadderGame(creator);
    }
}
