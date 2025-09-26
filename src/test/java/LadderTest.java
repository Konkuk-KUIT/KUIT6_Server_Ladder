import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Ladder 단위 테스트")
class LadderTest {
    @Test
    @DisplayName("같은 위치에 drawLine 중복 시 예외발생")
    void drawLineException() {
        Ladder ladder = new Ladder(new NaturalNumber(2), new NaturalNumber(3));
        ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));

        assertThrows(IllegalArgumentException.class,
                () -> ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1)));
    }
}