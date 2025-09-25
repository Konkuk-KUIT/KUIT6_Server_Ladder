package ladder.build;

import static org.junit.jupiter.api.Assertions.*;

import ladder.domain.LadderSize;
import ladder.domain.Position;
import ladder.domain.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;


import static org.assertj.core.api.Assertions.assertThat;

class RandomLadderCreatorTest {

    @Test
    @DisplayName("총 가로선 수 = floor(rows * persons * 0.3) 이어야 한다")
    void totalLinesEqualTarget() {
        LadderSize size = new LadderSize(10, 6);
        int expected = size.targetLines();

        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(size, new Random());
        Row[] rows = randomLadderCreator.getRows();

        int actual = 0;
        for (Row row : rows) {
            actual += countRightEdges(row, size.persons());
        }

        assertThat(actual).isEqualTo(expected);
    }

    private int countRightEdges(Row row, int persons) {
        int count = 0;
        for (int i = 0; i < persons - 1; i++) {
            int next = row.moveNextPosition(Position.from(i)).getValue();
            if (next == i + 1) count++;
        }
        return count;
    }


}