package ladder.build;

import ladder.domain.GreaterThanOne;
import ladder.domain.LadderSize;
import ladder.domain.Position;
import ladder.domain.Row;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements LadderCreator {

    private final CustomLadderCreator customLadderCreator;
    private final LadderSize ladderSize;
    private final Random random;


    public RandomLadderCreator(LadderSize ladderSize, Random random) {
        this.ladderSize = ladderSize;
        this.random = random;
        this.customLadderCreator = new CustomLadderCreator(
                GreaterThanOne.from(ladderSize.rows()),
                GreaterThanOne.from(ladderSize.persons())
        );
        autoDraw();
    }

    private void autoDraw() {
        final int rows    = ladderSize.rows();
        final int persons = ladderSize.persons();
        final int target  = ladderSize.targetLines();

        int placed = 0;

        while (placed < target) {
            int row = random.nextInt(rows);        // 0..rows-1
            int col = random.nextInt(persons - 1); // 0..persons-2 (마지막 칸 시작 불가)

            try {
                customLadderCreator.drawLine(Position.from(row), Position.from(col));
                placed++;
            } catch (IllegalArgumentException ignore) {
                // 예외가 발생해도 처리하지 않고 다른 곳에 가로 줄을 그릴 수 있도록 한다.
            }
        }

    }

    @Override public void drawLine(Position row, Position col) { customLadderCreator.drawLine(row, col); }
    @Override public Row[] getRows() { return customLadderCreator.getRows(); }
}
