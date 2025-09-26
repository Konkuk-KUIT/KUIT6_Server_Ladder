package test.java;

import ladder.exception.ErrorMessage;
import ladder.util.GreaterThanOne;
import ladder.position.Position;
import ladder.creator.LadderCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RowTest {


    @Test
    @DisplayName("같은 구간은 두 번 그을 수 없다")
    void cannotDrawSameIntervalTwice() {
        // given
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(2),GreaterThanOne.from(5));
        ladderCreator.drawLine(Position.from(0),Position.from(1));

        // when & then
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ladderCreator.drawLine(Position.from(0), Position.from(1)));

        assertEquals(ErrorMessage.INVALID_DRAW_POSITION.getMessage(), ex.getMessage());
    }

    @Test
    @DisplayName("인접 구간을 연속으로 그을 수 없다: (1–2) 후 (2–3)")
    void cannotDrawAdjacentInterval() {
        // given
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(2), GreaterThanOne.from(5));
        ladderCreator.drawLine(Position.from(0), Position.from(1)); // (1–2)

        // when & then
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ladderCreator.drawLine(Position.from(0), Position.from(2))); // (2–3)

        assertEquals(ErrorMessage.INVALID_DRAW_POSITION.getMessage(), ex.getMessage());
    }

    @Test
    @DisplayName("떨어진 구간은 허용된다: (0–1) 후 (2–3)")
    void canDrawNonAdjacentIntervals() {
        // given
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(2), GreaterThanOne.from(5));
        ladderCreator.drawLine(Position.from(0), Position.from(0));

        // when & then
        assertDoesNotThrow(() -> ladderCreator.drawLine(Position.from(0), Position.from(2))); // (2–3)

    }

    @Test
    @DisplayName("범위를 벗어난 위치에 선을 그리면 INVALID_DRAW_POSITION")
    void drawLine_outOfRange_throwsInvalidPosition() {
        // given
        LadderCreator ladderCreater = new LadderCreator(GreaterThanOne.from(3), GreaterThanOne.from(4));

        // when & then
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ladderCreater.drawLine(Position.from(5), Position.from(5)));

        assertEquals(ErrorMessage.INVALID_DRAW_POSITION.getMessage(), ex.getMessage());


    }

    @Test
    @DisplayName("마지막 인덱스에서 선을 시작할 수 없다(우측 이웃 없음)")
    void cannotStartFromLastIndex() {
        // given
        LadderCreator ladderCreater = new LadderCreator(GreaterThanOne.from(3), GreaterThanOne.from(4));

        // when & then
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ladderCreater.drawLine(Position.from(0), Position.from(3)));

        assertEquals(ErrorMessage.INVALID_DRAW_POSITION.getMessage(), ex.getMessage());
    }




}
