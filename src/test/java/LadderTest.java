import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("drawLine 메서드 테스트 1")
    void drawLine() {
        Ladder ladder = new Ladder(3, 3);
        StringArray stringArray = ladder.getStringArray();
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);

        assertThat(ladder.getStringArray().getValue(0, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("drawLine 메서드 테스트 1")
    void drawLine2() {
        Ladder ladder = new Ladder(6, 4);
        StringArray stringArray = ladder.getStringArray();
        ladder.drawLine(3, 2);
        assertThrows(IllegalArgumentException.class, () -> {
            ladder.drawLine(3, 3);
        });
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
    @DisplayName("run 메서드 테스트 2")
    void run2() {
        Ladder ladder = new Ladder(5, 4);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(3, 2);
        ladder.drawLine(2, 2);

        assertThat(ladder.run(0)).isEqualTo(2);
    }
}