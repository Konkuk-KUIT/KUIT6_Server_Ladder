import org.junit.jupiter.api.Assertions;

public class LadderRunnerTest {

    public void run() {
        movesAlongBridgesFromLeftToRight();
        movesAlongBridgesFromRightToLeft();
        reportsTraversalEventsToObserver();
    }

    private void movesAlongBridgesFromLeftToRight() {
        LadderCreator creator = new LadderCreator(2, 3);
        creator.placeBridge(0, 0);
        creator.placeBridge(1, 1);
        Ladder ladder = creator.toLadder();

        LadderRunner runner = new LadderRunner(ladder);

        int destination = runner.run(0);

        Assertions.assertEquals(2, destination);
    }

    private void movesAlongBridgesFromRightToLeft() {
        LadderCreator creator = new LadderCreator(1, 3);
        creator.placeBridge(0, 0);
        Ladder ladder = creator.toLadder();

        LadderRunner runner = new LadderRunner(ladder);

        int destination = runner.run(1);

        Assertions.assertEquals(0, destination);
    }

    private void reportsTraversalEventsToObserver() {
        LadderCreator creator = new LadderCreator(2, 3);
        creator.placeBridge(0, 0);
        creator.placeBridge(1, 1);
        Ladder ladder = creator.toLadder();

        LadderRunner runner = new LadderRunner(ladder);

        StringBuilder log = new StringBuilder();
        LadderTraversalObserver observer = new LadderTraversalObserver() {
            @Override
            public void beforeStep(int rowIndex, int currentPosition, Ladder ladder) {
                log.append("B").append(rowIndex).append(":").append(currentPosition).append(";");
            }

            @Override
            public void afterStep(int rowIndex, int currentPosition, Ladder ladder) {
                log.append("A").append(rowIndex).append(":").append(currentPosition).append(";");
            }
        };

        int destination = runner.run(0, observer);

        Assertions.assertEquals(2, destination);
        Assertions.assertEquals("B0:0;A0:1;B1:1;A1:2;", log.toString());
    }
}