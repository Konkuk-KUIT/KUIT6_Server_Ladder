package ladder;

import ladder.build.CustomLadderCreator;
import ladder.domain.GreaterThanOne;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomLadderCreatorTest {

    @Test
    @DisplayName("행 인덱스가 범위를 벗어나면 예외")
    void drawLineRowError() {
        CustomLadderCreator creator =
                new CustomLadderCreator(GreaterThanOne.from(3), GreaterThanOne.from(4));

        // row = -1
        assertThatThrownBy(() ->
                creator.drawLine(Position.from(-1), Position.from(0))
        ).isInstanceOf(IllegalArgumentException.class);

        // row = 3 (rows.length=3 → 0..2만 유효)
        assertThatThrownBy(() ->
                creator.drawLine(Position.from(3), Position.from(0))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 칸에서 시작하는 가로선은 금지")
    void drawLineLastColumnMakesError() {
        CustomLadderCreator creator =
                new CustomLadderCreator(GreaterThanOne.from(2), GreaterThanOne.from(3)); // persons=3 → 유효 col: 0,1

        // 마지막 칸(=2)에서 시작 → 금지
        assertThatThrownBy(() ->
                creator.drawLine(Position.from(0), Position.from(2))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 행에서 인접한 가로선 연속 금지")
    void drawLineSequenceError() {
        CustomLadderCreator creator =
                new CustomLadderCreator(GreaterThanOne.from(2), GreaterThanOne.from(5)); // persons=5 → 0..3 시작 가능

        creator.drawLine(Position.from(0), Position.from(1));

        assertThatThrownBy(() ->
                creator.drawLine(Position.from(0), Position.from(2))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}