package wrap;

import exceptions.InvalidLadderHeightException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderHeightTest {

    @Test
    void LadderHeight_of_정상_생성_테스트() {
        LadderHeight height = LadderHeight.of(5);
        
        assertEquals(5, height.getValue());
    }

    @Test
    void 영_입력_시_InvalidLadderHeightException_발생_테스트() {
        assertThrows(InvalidLadderHeightException.class, () -> LadderHeight.of(0));
    }

    @Test
    void 음수_입력_시_예외_발생_테스트() {
        assertThrows(InvalidLadderHeightException.class, () -> LadderHeight.of(-1));
        assertThrows(InvalidLadderHeightException.class, () -> LadderHeight.of(-5));
    }

    @Test
    void isValidRow_테스트() {
        LadderHeight height = LadderHeight.of(5);
        
        assertFalse(height.isValidRow(0));
        assertFalse(height.isValidRow(3));
        assertFalse(height.isValidRow(4));
        assertTrue(height.isValidRow(5));
        assertTrue(height.isValidRow(10));
    }

    @Test
    void equals_테스트() {
        LadderHeight height1 = LadderHeight.of(5);
        LadderHeight height2 = LadderHeight.of(5);
        LadderHeight height3 = LadderHeight.of(3);
        
        assertEquals(height1, height2);
        assertNotEquals(height1, height3);
        assertNotEquals(height1, null);
    }
}