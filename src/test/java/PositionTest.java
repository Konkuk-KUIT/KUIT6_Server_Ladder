import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Position 테스트")
class PositionTest {

    private NaturalNumber defaultMax;

    @BeforeEach
    void setUp() {
        defaultMax = new NaturalNumber(4);
    }

    @Test
    @DisplayName("생성 시 범위를 벗어나면 예외 발생")
    void rangeException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Position(new NaturalNumber(5), defaultMax));
    }

    @Test
    @DisplayName("moveRight 정상 동작 확인")
    void moveRightSuccess() {
        Position pos = new Position(new NaturalNumber(2), defaultMax);
        Position moved = pos.moveRight(defaultMax);
        assertEquals(3, moved.value());
    }

    @Test
    @DisplayName("오른쪽 끝에서 moveRight 시 예외 발생")
    void moveRightRangeException() {
        NaturalNumber max = new NaturalNumber(3);
        Position pos = new Position(new NaturalNumber(3), max);
        assertThrows(IllegalArgumentException.class,
                () -> pos.moveRight(max));
    }

    @Test
    @DisplayName("moveLeft 정상 동작 확인")
    void moveLeftSuccess() {
        Position pos = new Position(new NaturalNumber(3), defaultMax);
        Position moved = pos.moveLeft(defaultMax);
        assertEquals(2, moved.value());
    }

    @Test
    @DisplayName("왼쪽 끝에서 moveLeft 시 예외 발생")
    void moveLeftRangeException() {
        Position pos = new Position(new NaturalNumber(1), defaultMax);
        assertThrows(IllegalArgumentException.class,
                () -> pos.moveLeft(defaultMax));
    }
}
