public class LadderGameFactory {
    public static LadderProvider createNormalLadderGame(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        return new LadderCreator(numberOfRows, numberOfPerson);
    }

    public static LadderProvider createRandomLadderGame(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPerson);

        // y=0: (0 <-> 1)
        ladderCreator.drawLine(new Position(0, 0), new Position(2, 0));
        // y=1: (2 <-> 3)
        ladderCreator.drawLine(new Position(2, 1), new Position(3, 1));
        // y=3: (1 <-> 2)
        ladderCreator.drawLine(new Position(1, 3), new Position(2, 3));

        return ladderCreator;
    }
}
