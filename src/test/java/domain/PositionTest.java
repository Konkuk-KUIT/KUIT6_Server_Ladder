package domain;

import static org.junit.jupiter.api.Assertions.*;

import domain.NaturalNumber;
import domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("domain.Position 테스트")
class PositionTest {

    @Test
    @DisplayName("생성 시 범위를 벗어나면 예외 발생")
    void rangeException() {
        NaturalNumber max = new NaturalNumber(4);
        assertThrows(IllegalArgumentException.class,
                () -> new Position(new NaturalNumber(5), max));
    }

    @Test
    @DisplayName("moveRight 확인")
    void moveRightSuccess() {
        NaturalNumber max = new NaturalNumber(4);
        Position pos = new Position(new NaturalNumber(2), max);
        Position moved = pos.moveRight(max);
        assertEquals(3, moved.value());
    }

    @Test
    @DisplayName("오른쪽 끝에서 moveRight 시 예외 발생")
    void moveRightRangeException() {
        NaturalNumber max = new NaturalNumber(3);
        Position pos = new Position(new NaturalNumber(2), max);
        assertThrows(IllegalArgumentException.class, () -> pos.moveRight(max));
    }

    @Test
    @DisplayName("moveLeft 확인")
    void moveLeftSuccess() {
        NaturalNumber max = new NaturalNumber(4);
        Position pos = new Position(new NaturalNumber(3), max);
        Position moved = pos.moveLeft(max);
        assertEquals(2, moved.value());
    }

    @Test
    @DisplayName("왼쪽 끝에서 moveLeft 시 예외 발생")
    void moveLeftRangeException() {
        NaturalNumber max = new NaturalNumber(4);
        Position pos = new Position(new NaturalNumber(1), max);
        assertThrows(IllegalArgumentException.class, () -> pos.moveLeft(max));
    }
}
