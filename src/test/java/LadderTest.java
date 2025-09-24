import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("Ladder가 정상적으로 rowCount와 playerCount로 초기화됩니다.")
    void testLadderInitialization() {
        //given
        Ladder ladder = new Ladder(GreaterThanOne.from(3), GreaterThanOne.from(4));

        //when & then
        assertEquals(3, ladder.getRowCount());
        assertEquals(4, ladder.getPlayerCount());
    }

    @Test
    @DisplayName("LadderLine이 정상적으로 생성됩니다.")
    void testLadderLineInitialization() {
        // given
        LadderLine line = new LadderLine(GreaterThanOne.from(4));
        // when & then
        for (int i = 0; i < 4; i++) {
            int current = line.move(PlayerPosition.from(i)).getValue();
            assertEquals(i, current); // 아무 이동이 없어야 함
        }
    }

    @Test
    @DisplayName("drawLine을 호출하면 해당 위치가 LEFT/RIGHT로 설정됩니다.")
    void testDrawLine() {
        // Given
        LadderLine line = new LadderLine(GreaterThanOne.from(4));
        // When
        line.drawLine(1);
        // Then
        assertEquals(2, line.move(PlayerPosition.from(1)).getValue());
        assertEquals(1, line.move(PlayerPosition.from(2)).getValue());
    }

    @Test
    @DisplayName("잘못된 위치에 drawLine을 하면 예외가 발생합니다.")
    void testDrawLineInvalidPosition() {
        // Given
        LadderLine line = new LadderLine(GreaterThanOne.from(4));

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> line.drawLine(-1));
        assertThrows(IllegalArgumentException.class, () -> line.drawLine(3));
    }

    @Test
    @DisplayName("PlayLadderGame에서 최종 위치가 올바르게 계산된다")
    void testPlayLadderGame() {
        // Given
        Ladder ladder = new Ladder(GreaterThanOne.from(3), GreaterThanOne.from(4));
        ladder.drawLine(0, 0); // row0: 0-1
        ladder.drawLine(1, 2); // row1: 2-3
        ladder.drawLine(2, 1); // row2: 1-2
        PlayLadderGame game = new PlayLadderGame(ladder);

        // When & Then
        assertEquals(2, game.run(PlayerPosition.from(0))); // 0 → 2
        assertEquals(0, game.run(PlayerPosition.from(1)));  // 1 → 0
        assertEquals(3, game.run(PlayerPosition.from(2)));  // 2 → 3
        assertEquals(1, game.run(PlayerPosition.from(3)));  // 3 → 1
    }
}