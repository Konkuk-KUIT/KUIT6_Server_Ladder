package ladder.creator;

import ladder.LadderPosition;
import ladder.model.GreaterThanOne;
import ladder.model.Position;
import ladder.model.Row;

import java.util.HashSet;
import java.util.Random;

public class RandomLadderCreator implements LadderCreator {

    private final NormalLadderCreator normalLadderCreator;


    public RandomLadderCreator(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {

        normalLadderCreator = new NormalLadderCreator(numberOfRows, numberOfPerson);

        createRandomLine(numberOfRows, numberOfPerson);
    }

    private void createRandomLine(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {

        int lineAmount = (int) (numberOfRows.getNumber() * numberOfPerson.getNumber() * 0.3);
        HashSet<LadderPosition> randomLine = new HashSet<>();
        Random random = new Random();

        while (randomLine.size() < lineAmount) {
            LadderPosition candidate = new LadderPosition(
                    random.nextInt(numberOfRows.getNumber()),
                    random.nextInt(numberOfPerson.getNumber() - 1)
            );
            // 같은 row에서 col이 연속된 경우 필터링
            boolean conflict = randomLine.stream().anyMatch(
                    lp -> lp.getRow() == candidate.getRow() &&
                            Math.abs(lp.getCol() - candidate.getCol()) <= 1
            );
            if (!conflict) {
                randomLine.add(candidate);
            }
        }
        for(LadderPosition ladderPosition : randomLine) {
            drawLine(Position.from(ladderPosition.getRow()), Position.from(ladderPosition.getCol()));
        }

    }

    @Override
    public void drawLine(Position row, Position col) {
        normalLadderCreator.drawLine(row, col);
    }

    @Override
    public Row[] getRows() {
        return normalLadderCreator.getRows();
    }
}
