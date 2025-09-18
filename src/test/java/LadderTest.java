import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("유효하지 않은 시작 위치로 실행하면 예외가 발생한다.")
    void run_invalid_startPosition_throw_exception() {
        Ladder ladder = new Ladder(3, 5);

        assertThrows(IllegalArgumentException.class, () -> ladder.run(0));
        assertThrows(IllegalArgumentException.class, () -> ladder.run(4));
    }

    @Test
    @DisplayName("가로선이 하나도 없을 때, 시작 위치 그대로 나온다.")
    void run_noLines_success() {
        Ladder ladder = new Ladder(5, 7);
        ladder.printLines();

        assertEquals(1, ladder.run(1));
        assertEquals(3, ladder.run(3));
        assertEquals(5, ladder.run(5));
    }

    @Test
    @DisplayName("가로선이 하나 있을 때, 연결된 두 사람의 위치가 서로 바뀐다.")
    void run_singleLine_success() {
        Ladder ladder = new Ladder(4, 5);
        ladder.drawLine(2, 1);
        ladder.printLines();

        assertEquals(1, ladder.run(1));
        assertEquals(3, ladder.run(2));
        assertEquals(2, ladder.run(3));
        assertEquals(4, ladder.run(4));
    }

    @Test
    @DisplayName("복잡한 가로선이 있을 때, 정확한 최종 위치를 계산해야 한다.")
    void run_complexLines_success() {
        Ladder ladder = new Ladder(4, 5);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 0);
        ladder.drawLine(3, 2);
        ladder.drawLine(4, 1);
        ladder.printLines();

        assertEquals(4, ladder.run(1));
        assertEquals(3, ladder.run(2));
        assertEquals(1, ladder.run(3));
        assertEquals(2, ladder.run(4));
    }

    @Test
    @DisplayName("유효하지 않은 row로 선을 그릴 때 예외가 발생한다.")
    void draw_invalid_row_throw_exception() {
        Ladder ladder = new Ladder(4, 3);

        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(3, 0));
    }

    @Test
    @DisplayName("유효하지 않은 col로 선을 그릴 때 예외가 발생한다.")
    void draw_invalid_col_throw_exception() {
        Ladder ladder = new Ladder(4, 3);

        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(0, -1));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(0, 3));
    }

    @Test
    @DisplayName("같은 높이에서 연속된 선을 그리려고 할 때 예외가 발생한다.")
    void draw_adjacent_line_in_same_height_throw_exception() {
        Ladder ladder = new Ladder(4, 5);
        ladder.drawLine(2, 1);

        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(2, 0));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(2, 2));
    }
}