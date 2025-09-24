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
            PlayerPosition position = PlayerPosition.from(i);
            line.move(position);
            assertEquals(i, position.getValue()); // 아무 이동이 없어야 함
        }
    }

    @Test
    @DisplayName("drawLine을 호출하면 해당 위치가 LEFT/RIGHT로 설정됩니다.")
    void testDrawLine() {
        // Given
        LadderLine line = new LadderLine(GreaterThanOne.from(4));

        line.drawLine(PlayerPosition.from(1));

        // Then
        PlayerPosition pos1 = PlayerPosition.from(1);
        line.move(pos1);
        assertEquals(2, pos1.getValue());

        PlayerPosition pos2 = PlayerPosition.from(2);
        line.move(pos2); // pos2 이동
        assertEquals(1, pos2.getValue());
    }

    @Test
    @DisplayName("PlayLadderGame에서 최종 위치가 올바르게 계산된다")
    void testPlayLadderGame() {
        // Given
        Ladder ladder = new Ladder(GreaterThanOne.from(3), GreaterThanOne.from(4));
        ladder.drawLine(PlayerPosition.from(0), PlayerPosition.from(0)); // row0: 0-1
        ladder.drawLine(PlayerPosition.from(1), PlayerPosition.from(2)); // row1: 2-3
        ladder.drawLine(PlayerPosition.from(2), PlayerPosition.from(1)); // row2: 1-2
        PlayLadderGame game = new PlayLadderGame(ladder);

        // When & Then
        assertEquals(2, game.run(PlayerPosition.from(0))); // 0 → 2
        assertEquals(0, game.run(PlayerPosition.from(1)));
        assertEquals(3, game.run(PlayerPosition.from(2)));
        assertEquals(1, game.run(PlayerPosition.from(3)));
    }


}