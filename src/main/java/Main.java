public class Main {
    public static void main(String[] args) {
        GreaterThanOne numberOfRows = GreaterThanOne.from(5);
        GreaterThanOne numberOfPlayers = GreaterThanOne.from(5);

//        LadderProvider normalLadderProvider = LadderGameFactory.createNormalLadderGame(numberOfRows, numberOfPlayers);
//        LadderGame normalLadderGame = new LadderGame(normalLadderProvider);
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

        LadderProvider randomLadderProvider = LadderGameFactory.createRandomLadderGame(numberOfRows, numberOfPlayers);
        LadderGame randomLadderGame = new LadderGame(randomLadderProvider);
        int finalPosition = randomLadderGame.run(0);

        System.out.println("\n---- finalPosition = " + finalPosition + " ----");

    }
}
