import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        row.drawLine(new Position(0, 0), new Position(1, 0));

        // then
        assertEquals(1, row.getValue(0));   // 0번 → 1번
        assertEquals(-1, row.getValue(1));  // 1번 → 0번
    }

    @Test
    @DisplayName("getNextPosition은 연결된 위치로 이동한다")
    void getNextPositionMovesCorrectly() {
        // given
        Row row = new Row(new GreaterThanOne(3));
        row.drawLine(new Position(0, 0), new Position(1, 0));

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

    @ParameterizedTest(name = "길이 {0}의 Row 생성 → getLength() = {0}")
    @ValueSource(ints = {2, 3, 5, 10})
    @DisplayName("Row 길이 생성 검증 (Parameterized)")
    void createRowWithVariousLengths(int size) {
        Row row = new Row(new GreaterThanOne(size));
        assertEquals(size, row.getLength());
    }

    @ParameterizedTest(name = "drawLine(({0},0), ({1},0)) → row[{0}] = {1}-{0}, row[{1}] = {0}-{1}")
    @CsvSource({
            "0,1,3",   // 길이 3, (0<->1)
            "1,2,3",   // 길이 3, (1<->2)
            "2,4,5",   // 길이 5, (2<->4)
            "0,3,4"    // 길이 4, (0<->3)
    })
    @DisplayName("drawLine로 양 끝 인덱스에 상대 차이가 저장된다")
    void drawLineStoresSignedOffsets(int x1, int x2, int size) {
        Row row = new Row(new GreaterThanOne(size));
        row.drawLine(new Position(x1, 0), new Position(x2, 0));

        int expectedAtX1 = x2 - x1;
        int expectedAtX2 = x1 - x2;

        assertEquals(expectedAtX1, row.getValue(x1), "왼쪽 인덱스에 오른쪽-왼쪽 값이 저장되어야 함");
        assertEquals(expectedAtX2, row.getValue(x2), "오른쪽 인덱스에 왼쪽-오른쪽 값이 저장되어야 함");
    }

    @ParameterizedTest(name = "drawLine(({0},0), ({1},0)), start={2} → next={3}")
    @CsvSource({
            // (0<->1) 에서 0 시작 → 1, 1 시작 → 0, 2는 연결 없음 → 2
            "0,1,0,1,3",
            "0,1,1,0,3",
            "0,1,2,2,3",

            // (2<->4) 에서 2 시작 → 4, 4 시작 → 2, 3은 연결 없음 → 3
            "2,4,2,4,5",
            "2,4,4,2,5",
            "2,4,3,3,5",

            // (0<->3) 에서 0 시작 → 3, 3 시작 → 0, 1은 연결 없음 → 1
            "0,3,0,3,4",
            "0,3,3,0,4",
            "0,3,1,1,4"
    })
    @DisplayName("getNextPosition은 연결된 위치면 반대편으로, 아니면 제자리")
    void nextPositionAfterDrawLine(int x1, int x2, int start, int expected, int size) {
        Row row = new Row(new GreaterThanOne(size));
        row.drawLine(new Position(x1, 0), new Position(x2, 0));

        int next = row.getNextPosition(start);
        assertEquals(expected, next);
    }

    @ParameterizedTest(name = "연결 없음: size={0}, start={1} → next={1}")
    @CsvSource({
            "3,0", "3,1", "3,2",
            "5,0", "5,3", "5,4"
    })
    @DisplayName("어떤 선도 그리지 않았을 때는 자기 자신을 반환한다")
    void nextPositionWithoutAnyLine(int size, int start) {
        Row row = new Row(new GreaterThanOne(size));
        assertEquals(start, row.getNextPosition(start));
    }
}