import org.junit.jupiter.api.Assertions;

public class LadderCreatorTest {

    public void run() {
        createsEmptyLadderWithRequestedDimensions();
        placesBridgeAtRequestedRowAndColumn();
        rejectsInvalidRowIndex();
        rejectsInvalidColumnIndex();
        rejectsAdjacentBridgePlacement();
    }

    private void createsEmptyLadderWithRequestedDimensions() {
        LadderCreator creator = new LadderCreator(3, 4);

        Ladder ladder = creator.toLadder();

        Assertions.assertEquals(3, ladder.getHeight());
        Assertions.assertEquals(4, ladder.getNumberOfPerson());
    }

    private void placesBridgeAtRequestedRowAndColumn() {
        LadderCreator creator = new LadderCreator(2, 3);

        creator.placeBridge(0, 1);
        Ladder ladder = creator.toLadder();

        Row firstRow = ladder.getRows()[0];
        Assertions.assertTrue(firstRow.connectsToRightFrom(1));
        Assertions.assertTrue(firstRow.connectsToLeftFrom(2));
    }

    private void rejectsInvalidRowIndex() {
        LadderCreator creator = new LadderCreator(2, 3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> creator.placeBridge(2, 0));
    }

    private void rejectsInvalidColumnIndex() {
        LadderCreator creator = new LadderCreator(2, 3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> creator.placeBridge(0, 2));
    }

    private void rejectsAdjacentBridgePlacement() {
        LadderCreator creator = new LadderCreator(1, 4);
        creator.placeBridge(0, 1);

        Assertions.assertThrows(IllegalStateException.class, () -> creator.placeBridge(0, 2));
    }
}