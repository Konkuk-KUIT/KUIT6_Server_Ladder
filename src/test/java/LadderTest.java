import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    final int row = 10;
    final int people = 3;

    @Test
    @DisplayName("빈 사다리 생성")
    void 초기생성() {
        Ladder ladder = new Ladder(row, people);
        int position;
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        assertThat(ladder.run(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("중복 선 체크")
    void 중복선() {
        Ladder ladder = new Ladder(row, people);
        int position;
        ladder.drawLine(1, 1);
        assertThatThrownBy(() -> ladder.drawLine(1, 1)).isInstanceOf(IllegalArgumentException.class);
    }
}