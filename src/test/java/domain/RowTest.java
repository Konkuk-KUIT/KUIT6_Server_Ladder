package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("domain.Row 단위 테스트")
class RowTest {

    @Test
    @DisplayName("라인을 정상적으로 그릴 수 있는 경우")
    void drawLineSuccess() {
        Row row = new Row(4);
        assertTrue(row.canDrawLine(1));
        row.drawLine(1);
        assertEquals(1, row.getColumns()[1]);
        assertEquals(-1, row.getColumns()[2]);
    }

    @Test
    @DisplayName("같은 위치에 중복 라인 그리기 시 예외 발생")
    void drawLineDuplicateException() {
        Row row = new Row(4);
        row.drawLine(1);
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(1));
    }

    // 바로 옆에는 라인 못 그림
    @Test
    @DisplayName("연속된 라인(겹침) 방지 확인")
    void drawLineAdjacentException() {
        Row row = new Row(4);
        row.drawLine(1);
        assertFalse(row.canDrawLine(2));
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(2));
    }

    @Test
    @DisplayName("왼쪽으로 이동되는 경우")
    void moveLeft() {
        Row row = new Row(3);
        row.drawLine(0);
        Position pos = new Position(new NaturalNumber(2), new NaturalNumber(3));
        Position moved = row.move(pos);
        assertEquals(1, moved.value());
    }

    @Test
    @DisplayName("오른쪽으로 이동되는 경우")
    void moveRight() {
        Row row = new Row(3);
        row.drawLine(0);
        Position pos = new Position(new NaturalNumber(1), new NaturalNumber(3));
        Position moved = row.move(pos);
        assertEquals(2, moved.value());
    }

    @Test
    @DisplayName("이동이 없는 경우 (라인 없음)")
    void noMove() {
        Row row = new Row(3);
        Position pos = new Position(new NaturalNumber(2), new NaturalNumber(3));
        Position moved = row.move(pos);
        assertEquals(2, moved.value());
    }
}
