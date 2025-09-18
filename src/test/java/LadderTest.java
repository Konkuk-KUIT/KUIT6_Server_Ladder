import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


class LadderTest {


    @Test
    @DisplayName("사다리 가로줄 그리기")
    public void drawRowLadderTest() throws Exception {
        Ladder ladder = new Ladder(3, 3);
        //given
        ladder.drawLine(new Position(0, 0));
        //when
        int endLine = ladder.run(0);
        //then
        assertThat(endLine).isEqualTo(1);
    }

    @Test
    @DisplayName("음수좌표를 받으면 오류 발생")
    public void positionError() throws Exception {
        //given
        Ladder ladder = new Ladder(3, 3);
        //when & then
        assertThatThrownBy(() -> ladder.drawLine(new Position(-1, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 불가능");
     }

    @Test
    @DisplayName("마지막 세로줄에선 사다리 가로줄 그릴 수 없다.")
    public void drawRowsLastColMakesError() throws Exception {
        Ladder ladder = new Ladder(3, 3);
        //given
        Position position = new Position(0, 2); // 3번째(인덱스 2) 세로줄에서 선을 그으려 함
        //when & then
        assertThatThrownBy(() -> ladder.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("오른쪽에 선을 그을 수 없습니다.");

    }

    @Test
    @DisplayName("사다리 가로줄을 이어서 그리면 오류 발생")
    public void drawRowsStraightMakesError() throws Exception {
        Ladder ladder = new Ladder(3, 3);
        //given
        ladder.drawLine(new Position(0, 0));
        //when

        //then
        assertThatThrownBy(() -> ladder.drawLine(new Position(0, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("가로선은 연속으로 그릴 수 없습니다.");
    }

    @Test
    @DisplayName("사다리 가로줄이 중복되면 오류 발생")
    public void drawRowsSamePositionMakesError() throws Exception {
        //given
        Ladder ladder = new Ladder(3, 3);
        ladder.drawLine(new Position(0, 0));
        //when & then
        assertThatThrownBy(() -> ladder.drawLine(new Position(0, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 위치에 이미 가로선이 존재합니다.");
     }

    @Test
    @DisplayName("사다리타기 테스트")
    public void runLadderTest() throws Exception {
        // given
        Ladder ladderForRun = new Ladder(3, 3);
        ladderForRun.drawLine(new Position(0, 0));
        ladderForRun.drawLine(new Position(1, 1));

        // when
        int endPosition1 = ladderForRun.run(0); // 0번 줄
        int endPosition2 = ladderForRun.run(1); // 1번 줄
        int endPosition3 = ladderForRun.run(2); // 2번 줄

        // then
        /*
         * 0   1   2
         * |---|   |
         * |   |---|
         * |   |   |
         * ↓   ↓   ↓
         * 1   2   0  (최종 도착지)
         *
         */
        assertThat(endPosition1).isEqualTo(2);
        assertThat(endPosition2).isEqualTo(0);
        assertThat(endPosition3).isEqualTo(1);

    }

    @Test
    @DisplayName("빈 사다리에서는 출발지와 도착지가 같다.")
    public void emptyLadderKeepsPosition() throws Exception {
        // given
        Ladder ladder = new Ladder(5, 5);

        // when & then
        for (int i = 0; i < 5; i++) {
            assertThat(ladder.run(i)).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("사다리 결과는 항상 일대일 매핑이다.")
    public void ladderMappingIsOneToOne() throws Exception {
        // given
        Ladder ladder = new Ladder(5, 5);
        ladder.drawLine(new Position(0, 0));
        ladder.drawLine(new Position(1, 2));
        ladder.drawLine(new Position(2, 1));
        ladder.drawLine(new Position(3, 3));

        // when
        Set<Integer> results = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            results.add(ladder.run(i));
        }

        // then
        assertThat(results.size()).isEqualTo(5); // 모든 참가자가 서로 다른 위치에 도착한다.
    }

}