import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("가로줄이 하나도 없을 때, run() 결과는 시작 위치와 동일해야 한다.")
    void noRungs_run_returnsSamePosition() {
        // given
        Ladder ladder = new Ladder(5, 5);
        LadderRunner runner = new LadderRunner(ladder);

        // when & then
        assertEquals(1, runner.run(1));
        assertEquals(3, runner.run(3));
        assertEquals(5, runner.run(5));
    }

    @Test
    @DisplayName("가로줄이 하나 있을 때, 연결된 두 라인의 결과는 서로 바뀌어야 한다.")
    void singleRung_run_swapsPositions() {
        // given
        Ladder ladder = new Ladder(4, 5);
        ladder.drawLine(2, 3); // 3층 높이에 2번과 3번 라인 연결
        LadderRunner runner = new LadderRunner(ladder);

        // when & then
        assertEquals(1, runner.run(1)); // 1번 -> 1번
        assertEquals(3, runner.run(2)); // 2번 -> 3번
        assertEquals(2, runner.run(3)); // 3번 -> 2번
        assertEquals(4, runner.run(4)); // 4번 -> 4번
    }

    @Test
    @DisplayName("복잡하게 연결된 사다리의 경로를 정확하게 계산해야 한다.")
    void complexLadder_run_followsPathCorrectly() {
        // given: 5명의 참가자, 높이 5의 사다리
        Ladder ladder = new Ladder(5, 5);
        ladder.drawLine(1, 1); // 높이 1, 1-2 연결
        ladder.drawLine(3, 2); // 높이 2, 3-4 연결
        ladder.drawLine(2, 3); // 높이 3, 2-3 연결
        ladder.drawLine(4, 4); // 높이 4, 4-5 연결
        LadderRunner runner = new LadderRunner(ladder);

        // when & then
        assertEquals(3, runner.run(1), "1번 참가자 결과");
        assertEquals(1, runner.run(2), "2번 참가자 결과");
        assertEquals(5, runner.run(3), "3번 참가자 결과");
        assertEquals(2, runner.run(4), "4번 참가자 결과");
        assertEquals(4, runner.run(5), "5번 참가자 결과");
    }

    @Test
    @DisplayName("연속된 가로줄을 그리려고 하면 예외가 발생해야 한다.")
    void drawLine_adjacentRung_throwsException() {
        // given
        Ladder ladder = new Ladder(4, 5);
        ladder.drawLine(1, 2); // 높이 2에 1-2 라인 연결

        // when & then: 같은 높이에 2-3 라인을 연결하려고 시도하면 예외 발생
        assertThrows(IllegalStateException.class, () -> {
            ladder.drawLine(2, 2);
        });
    }
}