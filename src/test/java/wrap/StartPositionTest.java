package wrap;

import exceptions.InvalidStartPositionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartPositionTest {

    @Test
    void StartPosition_at_정상_생성_테스트() {
        StartPosition position = StartPosition.at(3);
        
        assertEquals(3, position.getValue());
    }

    @Test
    void 음수_입력_시_InvalidStartPositionException_발생_테스트() {
        assertThrows(InvalidStartPositionException.class, () -> StartPosition.at(-1));
        assertThrows(InvalidStartPositionException.class, () -> StartPosition.at(-5));
    }

    @Test
    void 경계값_영_처리_테스트() {
        StartPosition position = StartPosition.at(0);
        
        assertEquals(0, position.getValue());
    }

    @Test
    void equals_테스트() {
        StartPosition position1 = StartPosition.at(5);
        StartPosition position2 = StartPosition.at(5);
        StartPosition position3 = StartPosition.at(3);
        
        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
        assertNotEquals(position1, null);
    }

    @Test
    void 값_객체_특성_테스트() {
        StartPosition position1 = StartPosition.at(3);
        StartPosition position2 = StartPosition.at(3);
        
        assertEquals(position1, position2);
        assertEquals(position1.hashCode(), position2.hashCode());
    }
}