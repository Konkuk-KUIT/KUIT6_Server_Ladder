public class Main {
    public static void main(String[] args) {
        GreaterThanOne numberOfRows = GreaterThanOne.from(5);
        GreaterThanOne numberOfPlayers = GreaterThanOne.from(5);

//        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPlayers);
//        // y=0: (0 <-> 1)
//        ladderCreator.drawLine(new Position(0, 0), new Position(2, 0));
//        // y=1: (2 <-> 3)
//        ladderCreator.drawLine(new Position(2, 1), new Position(3, 1));
//        // y=3: (1 <-> 2)
//        ladderCreator.drawLine(new Position(1, 3), new Position(2, 3));
//
//
//        LadderGame ladderGame = new LadderGame(ladderCreator);
//        int finalPosition = ladderGame.run(0);
//        System.out.println("\n---- finalPosition = " + finalPosition + " ----");

        LadderCreator ladderCreator2 = LadderGameFactory.createRandomLadderGame(numberOfRows, numberOfPlayers);
        LadderGame ladderGame = new LadderGame(ladderCreator2);
        int finalPosition = ladderGame.run(0);

    }
}
