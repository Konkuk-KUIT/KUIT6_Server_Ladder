import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    @DisplayName("(0, 0) Position 만들기")
    void createInitialPosition() {
        // given
        Position position = new Position(0, 0);
        //when & then
        assertThat(position.getX()).isEqualTo(0);
        assertThat(position.getY()).isEqualTo(0);
    }

    @Test
    @DisplayName("음수 포지션을 만들면 오류 발생")
    void minusValueThrowException() {
        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Position(-1, -1);
                });
    }
}