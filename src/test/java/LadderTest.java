import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {
    @Test
    @DisplayName("초기 사다리는 0으로 초기화")
    void initialLadder() {
        // given
        Ladder ladder = new Ladder(3, 3);

        //when
        Position pos = new Position(0, 0);

        //then
        assertThat(ladder.getLadderInfoByPosition(pos)).isEqualTo(0);

    }

    @Test
    @DisplayName("사다리 그리면 거리만큼 반영")
    void drawComplete() {
        // given
        Ladder ladder = new Ladder(3, 3);
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(1, 0);

        //when
        ladder.drawLine(pos1, pos2);

        //then
        assertThat(ladder.getLadderInfoByPosition(pos1)).isEqualTo(1);
        assertThat(ladder.getLadderInfoByPosition(pos2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("사다리 타기 정상 작동")
    void drawLineAndRun() {
        // given
        Ladder ladder = new Ladder(5, 5);

        // y=0: (0 <-> 1)
        ladder.drawLine(new Position(0, 0), new Position(1, 0));
        // y=1: (2 <-> 3)
        ladder.drawLine(new Position(2, 1), new Position(3, 1));
        // y=3: (1 <-> 2)
        ladder.drawLine(new Position(1, 3), new Position(2, 3));

        // when & then
        assertThat(ladder.run(0)).isEqualTo(2);
        assertThat(ladder.run(1)).isEqualTo(0);
        assertThat(ladder.run(2)).isEqualTo(3);
        assertThat(ladder.run(3)).isEqualTo(1);
        assertThat(ladder.run(4)).isEqualTo(4);

    }
}
