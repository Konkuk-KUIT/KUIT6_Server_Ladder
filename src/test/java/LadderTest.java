// LadderTest.java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("가로줄이 하나도 없을 때, run() 결과는 시작 위치와 동일해야 한다.")
    void noRungs_run_returnsSamePosition() {
        Ladder ladder = new Ladder(5, 5);
        assertEquals(1, ladder.run(1));
        assertEquals(3, ladder.run(3));
        assertEquals(5, ladder.run(5));
    }

    @Test
    @DisplayName("가로줄이 하나 있을 때, 연결된 두 라인의 결과는 서로 바뀌어야 한다.")
    void singleRung_run_swapsPositions() {
        Ladder ladder = new Ladder(4, 5);
        ladder.drawLine(2, 3); // 3층 높이에 2번과 3번 라인 연결

        assertEquals(1, ladder.run(1)); // 1번 -> 1번
        assertEquals(3, ladder.run(2)); // 2번 -> 3번
        assertEquals(2, ladder.run(3)); // 3번 -> 2번
        assertEquals(4, ladder.run(4)); // 4번 -> 4번
    }

    @Test
    @DisplayName("복잡하게 연결된 사다리의 경로를 정확하게 계산해야 한다.")
    void complexLadder_run_followsPathCorrectly() {
        // 5명의 참가자, 높이 5의 사다리
        Ladder ladder = new Ladder(5, 5);

        /*
         * 1 |-| 2     3     4     5
         * |   |   |-|   |     |
         * | |-| |     |     |
         * |   |   |   |-|   |
         * |   |   |     | |-|
         */
        ladder.drawLine(1, 1); // 높이 1, 1-2 연결
        ladder.drawLine(3, 2); // 높이 2, 3-4 연결
        ladder.drawLine(2, 3); // 높이 3, 2-3 연결
        ladder.drawLine(4, 4); // 높이 4, 4-5 연결

        // 예상 결과
        // 1 -> 2 -> 2 -> 3 -> 3 -> 3
        assertEquals(3, ladder.run(1));

        // 2 -> 1 -> 1 -> 1 -> 1 -> 1
        assertEquals(1, ladder.run(2));

        // 3 -> 3 -> 4 -> 4 -> 5 -> 5
        assertEquals(5, ladder.run(3));

        // 4 -> 4 -> 3 -> 2 -> 2 -> 2
        assertEquals(2, ladder.run(4));

        // 5 -> 5 -> 5 -> 5 -> 4 -> 4
        assertEquals(4, ladder.run(5));
    }

    @Test
    @DisplayName("연속된 가로줄을 그리려고 하면 IllegalStateException이 발생해야 한다.")
    void drawLine_adjacentRung_throwsException() {
        Ladder ladder = new Ladder(4, 5);
        ladder.drawLine(1, 2); // 높이 2에 1-2 라인 연결

        // 같은 높이에 2-3 라인을 연결하려고 시도
        assertThrows(IllegalStateException.class, () -> {
            ladder.drawLine(2, 2);
        });
    }
}