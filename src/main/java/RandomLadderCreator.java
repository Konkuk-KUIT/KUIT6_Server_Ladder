import java.util.*;

public class RandomLadderCreator implements LadderProvider {

    private final Row[] rows;
    private static final double BRIDGE_DENSITY = 0.3;

    public RandomLadderCreator(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        this.rows = new Row[numberOfRows.getNumber()];
        for (int i = 0; i < numberOfRows.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }

        generateRandomBridges(numberOfRows.getNumber(), numberOfPerson.getNumber());
    }

    private void generateRandomBridges(int height, int width) {
        int placeableWidth = width - 1;

        List<Position> allPossiblePositions = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < placeableWidth; x++) {
                allPossiblePositions.add(Position.from(x, y));
            }
        }

        Collections.shuffle(allPossiblePositions);

        int targetBridgeCount = (int) (height * width * BRIDGE_DENSITY);
        int bridgesPlaced = 0;

        boolean[][] hasBridge = new boolean[height][placeableWidth];

        for (Position pos : allPossiblePositions) {
            if (bridgesPlaced >= targetBridgeCount) {
                break;
            }

            int x = pos.getX();
            int y = pos.getY();

            boolean isLeftBlocked = (x > 0) && hasBridge[y][x - 1];
            boolean isRightBlocked = (x < placeableWidth - 1) && hasBridge[y][x + 1];

            if (!hasBridge[y][x] && !isLeftBlocked && !isRightBlocked) {
                this.drawLine(pos, Position.from(x + 1, y));
                hasBridge[y][x] = true;
                bridgesPlaced++;
            }
        }
    }

    private void drawLine(Position pos1, Position pos2) {
        rows[pos1.getY()].drawLine(pos1, pos2);
    }

    @Override
    public Row[] getRows() {
        return this.rows;
    }
}
