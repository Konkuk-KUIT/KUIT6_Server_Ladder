import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("drawLine 메서드 테스트")
    void drawLine() {
        Ladder ladder = new Ladder(3, 3);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);

        assertThat(ladder.getRows()).isEqualTo(new int[][]{{1, 0}, {0, 1}, {0, 0}});
    }

    @Test
    @DisplayName("run 메서드 테스트")
    void run() {
        Ladder ladder = new Ladder(3, 3);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);

        assertThat(ladder.run(0)).isEqualTo(2);
    }

    @Test
    @DisplayName("run 메서드 테스트2")
    void run2() {
        Ladder ladder = new Ladder(5, 4);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(3, 0);
        ladder.drawLine(2, 2);

        assertThat(ladder.run(1)).isEqualTo(1);
    }
}