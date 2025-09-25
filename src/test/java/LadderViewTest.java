import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderViewTest {

    @Test
    @DisplayName("사다리 출력이 정상적으로 되는지 확인")
    public void ladder_view_test() throws Exception {
        // Given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(4));
        ladder.drawLine(NaturalNumber.from(1), NaturalNumber.from(1)); // row 1, col 1
        ladder.drawLine(NaturalNumber.from(2), NaturalNumber.from(2)); // row 2, col 2
        LadderView ladderView = new LadderView();

        // When
        // currentRow=1, currentPosition=2 (0-indexed) -> 2번째 줄, 3번째 사람 위치에 '*' 표시
        String ladderString = ladderView.getLadderString(ladder, 1, 2);

        // Then
        // 수정된 LadderView는 '|'를 '*'로 대체하여 현재 위치를 표시합니다.
        StringBuilder expectedLadder = new StringBuilder();
        expectedLadder.append("  |-----|     |     |" + "\n");
        expectedLadder.append("  |     |-----*     |" + "\n");
        expectedLadder.append("  |     |     |     |" + "\n");
        assertEquals(expectedLadder.toString(), ladderString);
    }

    @Test
    @DisplayName("사다리 객체가 null일 경우 예외 발생")
    public void ladder_is_null_test() {
        // Given
        LadderView ladderView = new LadderView();

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            ladderView.getLadderString(null, 1, 1);
        });
    }

    @Test
    @DisplayName("유효하지 않은 위치를 입력할 경우 예외 발생")
    public void invalid_position_test() throws Exception {
        // Given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(4));
        LadderView ladderView = new LadderView();

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            // 유효하지 않은 행
            ladderView.getLadderString(ladder, -1, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            // 유효하지 않은 위치
            ladderView.getLadderString(ladder, 0, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            // 행 범위 초과
            ladderView.getLadderString(ladder, 3, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            // 위치 범위 초과
            ladderView.getLadderString(ladder, 0, 4);
        });
    }

    @Test
    @DisplayName("참여 인원이 1명일 경우 정상 출력")
    public void one_person_ladder_test() throws Exception {
        // Given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(1));
        LadderView ladderView = new LadderView();

        // When
        // 1명인 경우 currentPosition은 0만 유효
        String ladderString = ladderView.getLadderString(ladder, 1, 0);

        // Then
        StringBuilder expectedLadder = new StringBuilder();
        expectedLadder.append("  |" + "\n");
        expectedLadder.append("  *" + "\n");
        expectedLadder.append("  |" + "\n");
        assertEquals(expectedLadder.toString(), ladderString);
    }

    @Test
    @DisplayName("사다리 높이가 0일 경우 예외 발생하는지 확인")
    public void zero_height_ladder_test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(NaturalNumber.from(0), NaturalNumber.from(4));
        });
    }
}
