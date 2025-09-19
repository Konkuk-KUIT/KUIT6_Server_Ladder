import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    public void emptyLadder() {
        Ladder ladder = new Ladder(4, 5);
        assertEquals(1, ladder.run(1));
        assertEquals(2, ladder.run(2));
        assertEquals(3, ladder.run(3));
        assertEquals(4, ladder.run(4));
        assertEquals(5, ladder.run(5));
    }

    @Test
    public void swapLadder() {
        Ladder ladder = new Ladder(4, 4);
        ladder.drawLine(1,1);
        ladder.drawLine(2,2);
        assertEquals(3,ladder.run(1) );
        assertEquals(1, ladder.run(2));
        assertEquals(2, ladder.run(3));
        assertEquals(4, ladder.run(4));
    }

    @Test
    @DisplayName("position/row 하한·상한 범위 체크")
    void out_of_range_drawLine() {
        Ladder ladder = new Ladder(4, 4);
        assertThatThrownBy(() -> ladder.drawLine(1, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ladder.drawLine(1, 4)).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ladder.drawLine(0, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ladder.drawLine(5, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("여러 행을 누적 이동(지그재그)")
    void zigzag_moves_across_multiple_rows() {
        Ladder l = new Ladder(4, 4);
        l.drawLine(1, 2); // (2~3)
        l.drawLine(2, 1); // (1~2)
        l.drawLine(2, 3);
        assertThat(l.run(1)).isEqualTo(2);
        assertThat(l.run(2)).isEqualTo(4);
        assertThat(l.run(3)).isEqualTo(1);
        assertThat(l.run(4)).isEqualTo(3);
    }

    @Test
    @DisplayName("인접한 사다리는 허용하지 않음")
    public void AdjacentLadder() throws Exception {
        Ladder ladder = new Ladder(4, 4);
        ladder.drawLine(1,2);

        assertThatThrownBy(() -> ladder.drawLine(1,3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ladder.drawLine(1,1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ladder.drawLine(1,2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주어진 라인에 벗어난 사다리는 허용하지 않음")
    public void OutOfRangeLadder() throws Exception {
        Ladder ladder = new Ladder(4, 4);

        assertThatThrownBy(() -> ladder.drawLine(1,4))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("같은 행이고 인접하지 않으면 허용")
    void sameRowButNoAdjacent() {
        Ladder ladder = new Ladder(4, 4);
        assertThatCode(() -> {
            ladder.drawLine(1, 1);
            ladder.drawLine(1, 3);
        }).doesNotThrowAnyException(); // 칸 띄었으면 허용(모델에 따라)
    }
}