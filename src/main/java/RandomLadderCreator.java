import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomLadderCreator implements LadderProvider {
    private final LadderCreator delegate;

    public RandomLadderCreator(int height, int numberOfPerson, Random random) {
        this.delegate = new LadderCreator(height, numberOfPerson);
        generateRandomBridges(height, numberOfPerson, random);
    }

    private void generateRandomBridges(int height, int numberOfPerson, Random random) {
        int availableColumns = numberOfPerson - 1;
        int targetLines = (int) Math.round(height * availableColumns * 0.3);
        if (targetLines <= 0) {
            return;
        }
        List<Position> candidates = new ArrayList<>();
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < availableColumns; column++) {
                candidates.add(new Position(row, column));
            }
        }
        Collections.shuffle(candidates, random);
        int placed = 0;
        for (Position candidate : candidates) {
            if (placed >= targetLines) {
                break;
            }
            try {
                delegate.placeBridge(candidate.row, candidate.column);
                placed++;
            } catch (IllegalStateException ignored) {
                // Skip invalid placements and continue searching for viable slots.
            }
        }
    }

    @Override
    public Ladder provide() {
        return delegate.provide();
    }

    private static final class Position {
        private final int row;
        private final int column;

        private Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}