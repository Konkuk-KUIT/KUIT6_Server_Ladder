package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderSizeTest {

    @Test
    @DisplayName("가로줄 수 규칙 충족 확인")
    void CheckTargetLinesRule() {
        LadderSize size = new LadderSize(10, 6);
        assertThat(size.rows()).isEqualTo(10);
        assertThat(size.persons()).isEqualTo(6);
        assertThat(size.targetLines()).isEqualTo((int)Math.floor(10 * 6 * 0.3)); // 18
    }

    @Test
    @DisplayName("LadderSize 잘못되면 예외 발생")
    void LadderSizeError() {
        assertThatThrownBy(() -> new LadderSize(1, 5))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LadderSize(5, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}