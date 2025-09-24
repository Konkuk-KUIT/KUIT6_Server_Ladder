import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {
    @Test
    @DisplayName("Row 생성 시 길이가 올바르게 설정된다")
    void createRowWithLength() {
        // given
        GreaterThanOne numberOfPerson = new GreaterThanOne(3);

        // when
        Row row = new Row(numberOfPerson);

        // then
        assertEquals(3, row.getLength());
    }

    @Test
    @DisplayName("drawLine으로 연결된 두 위치의 값이 올바르게 저장된다")
    void drawLineStoresValues() {
        // given
        Row row = new Row(new GreaterThanOne(3));

        // when
        row.drawLine(0, 1);

        // then
        assertEquals(1, row.getValue(0));   // 0번 → 1번
        assertEquals(-1, row.getValue(1)); // 1번 → 0번
    }

    @Test
    @DisplayName("getNextPosition은 연결된 위치로 이동한다")
    void getNextPositionMovesCorrectly() {
        // given
        Row row = new Row(new GreaterThanOne(3));
        row.drawLine(0, 1);

        // when
        int next = row.getNextPosition(0);

        // then
        assertEquals(1, next);
    }

    @Test
    @DisplayName("연결되지 않은 위치는 자기 자신을 반환한다")
    void getNextPositionWithoutLine() {
        // given
        Row row = new Row(new GreaterThanOne(3));

        // when
        int next = row.getNextPosition(2);

        // then
        assertEquals(2, next); // 기본값 0 → 자기 자신
    }
}