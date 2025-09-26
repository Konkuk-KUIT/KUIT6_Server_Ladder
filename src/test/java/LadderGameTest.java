import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;

public class LadderGameTest {

    public void run() {
        delegatesCreationAndRunningToCollaborators();
        usesInjectedObserver();
        createsRandomGameThroughFactory();
    }

    private void delegatesCreationAndRunningToCollaborators() {
        LadderCreator creator = new LadderCreator(2, 3);
        creator.placeBridge(0, 1);
        creator.placeBridge(1, 0);

        LadderGame game = new LadderGame(creator);

        int destination = game.run(2);

        Assertions.assertEquals(0, destination);
    }

    private void usesInjectedObserver() {
        Ladder ladder = new LadderCreator(1, 2).toLadder();
        LadderProvider provider = () -> ladder;

        StringBuilder log = new StringBuilder();
        LadderTraversalObserver observer = new LadderTraversalObserver() {
            @Override
            public void beforeStep(int rowIndex, int currentPosition, Ladder ladder) {
                log.append("before");
            }

            @Override
            public void afterStep(int rowIndex, int currentPosition, Ladder ladder) {
                log.append("after");
            }
        };

        LadderGame game = LadderGameFactory.create(provider, observer);

        game.run(0);

        Assertions.assertEquals("beforeafter", log.toString());
    }

    private void createsRandomGameThroughFactory() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream capture = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capture));
        try {
            LadderGame game = LadderGameFactory.createRandomLadderGame(3, 4, new java.util.Random(42L));
            int result = game.run(0);

            Assertions.assertTrue(result >= 0);
            Assertions.assertTrue(result < 4);
            Assertions.assertTrue(capture.toString().contains("Before"));
            Assertions.assertTrue(capture.toString().contains("After"));
        } finally {
            System.setOut(originalOut);
        }
    }
}