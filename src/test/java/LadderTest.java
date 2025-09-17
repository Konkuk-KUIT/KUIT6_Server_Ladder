import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LadderTest {
    final int row = 10;
    final int people = 3;

    @Test
    @DisplayName("사다리 생성, run까지")
    void 생성부터run까지() {
        Ladder ladder = new Ladder(row, people);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        assertThat(ladder.run(1)).isEqualTo(3);
        assertThat(ladder.run(2)).isEqualTo(1);
        assertThat(ladder.run(3)).isEqualTo(2);

    }

    @Test
    @DisplayName("중복 선 체크")
    void 중복예외반환() {
        Ladder ladder = new Ladder(row, people);
        ladder.drawLine(1, 1);
        assertThatThrownBy(() -> ladder.drawLine(1, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 범위 입력")
    void 범위오류() {
        Ladder ladder = new Ladder(row, people);

        assertThatThrownBy(() -> ladder.drawLine(3, 3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ladder.drawLine(10, 0)).isInstanceOf(IllegalArgumentException.class);

        Ladder ladder1 = new Ladder(5, 7);
        assertThatThrownBy(() -> ladder1.drawLine(6, 2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ladder1.drawLine(3,7)).isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    @DisplayName("같은 높이 연속된 선 에외")
    void 연속선예외() {
        Ladder ladder = new Ladder(row, people);
        ladder.drawLine(0, 0);
        ladder.drawLine(2, 1);

        assertThatThrownBy(() -> ladder.drawLine(0, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ladder.drawLine(2, 0)).isInstanceOf(IllegalArgumentException.class);
    }
}