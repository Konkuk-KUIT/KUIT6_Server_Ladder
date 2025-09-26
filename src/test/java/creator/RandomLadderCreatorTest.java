package creator;

import static org.junit.jupiter.api.Assertions.*;

import creator.RandomLadderCreator;
import domain.Ladder;
import domain.LadderSize;
import domain.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("creator.RandomLadderCreator 단위 테스트")
class RandomLadderCreatorTest {

    @Test
    @DisplayName("정책에 맞는 라인 수 만큼 랜덤으로 생성된다")
    void createRandomLadder() {
        LadderSize size = new LadderSize(10, 5); // 10행 5명
        RandomLadderCreator creator = new RandomLadderCreator(size);

        Row[] rows = creator.getRows();
        Ladder ladder = new Ladder(size, rows);

        int expectedLines = size.calculateLineCount();
        int actualLines = countLines(rows);

        assertEquals(expectedLines, actualLines);
        assertNotNull(ladder);
    }

    private int countLines(Row[] rows) {
        int count = 0;
        for (Row row : rows) {
            int[] cols = row.getColumns();
            for (int val : cols) {
                if (val == 1) count++;
            }
        }
        return count;
    }
}
