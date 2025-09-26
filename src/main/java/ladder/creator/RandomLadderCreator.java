package ladder.creator;

import ladder.domain.LadderPosition;
import ladder.domain.LadderSize;
import ladder.domain.Position;
import ladder.domain.Row;

import java.util.HashSet;
import java.util.Random;

public class RandomLadderCreator implements LadderCreator {

    private final CustomLadderCreator customLadderCreator;
    private final LadderSize ladderSize;


    public RandomLadderCreator(CustomLadderCreator customLadderCreator) {
        this.ladderSize = customLadderCreator.getLadderSize();
        this.customLadderCreator = customLadderCreator;
        generateRandomLines();
    }

    private void generateRandomLines() {
        int height = ladderSize.getNumberOfRows().getNumber();
        int width = ladderSize.getNumberOfPerson().getNumber() - 1;

        if (width <= 0) {
            return;
        }

        int totalPossiblePositions = height * width;
        int totalLines = (int) (totalPossiblePositions * 0.3);

        if (totalLines == 0) {
            return;
        }

        HashSet<Integer> positions = new HashSet<>();
        Random random = new Random();
        int drawnLines = 0;

        while (drawnLines < totalLines) {
            if (positions.size() >= totalPossiblePositions) {
                break;
            }

            int randomPosition = random.nextInt(totalPossiblePositions);

            if (positions.contains(randomPosition)) {
                continue;
            }

            positions.add(randomPosition);

            Position row = Position.from(randomPosition / width);
            Position col = Position.from(randomPosition % width);

            LadderPosition realPosition = new LadderPosition(row, col);

            try {
                customLadderCreator.drawLine(realPosition);
                drawnLines++;
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    @Override
    public void drawLine(LadderPosition position) {
    }

    @Override
    public Row[] getRows() {
        return customLadderCreator.getRows();
    }

}