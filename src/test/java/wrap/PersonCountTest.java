package wrap;

import exceptions.InvalidPersonCountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonCountTest {

    @Test
    void PersonCount_from_정상_생성_테스트() {
        PersonCount count = PersonCount.from(5);
        
        assertEquals(5, count.getValue());
    }

    @Test
    void 영_입력_시_InvalidPersonCountException_발생_테스트() {
        assertThrows(InvalidPersonCountException.class, () -> PersonCount.from(0));
    }

    @Test
    void 음수_입력_시_예외_발생_테스트() {
        assertThrows(InvalidPersonCountException.class, () -> PersonCount.from(-1));
        assertThrows(InvalidPersonCountException.class, () -> PersonCount.from(-5));
    }

    @Test
    void getMaxLineIndex_계산_정확성_테스트() {
        PersonCount count = PersonCount.from(5);
        
        assertEquals(4, count.getMaxLineIndex());
    }

    @Test
    void isInValidLineIndex_테스트() {
        PersonCount count = PersonCount.from(5);
        
        assertFalse(count.isInValidLineIndex(0));
        assertFalse(count.isInValidLineIndex(2));
        assertFalse(count.isInValidLineIndex(3));
        assertTrue(count.isInValidLineIndex(-1));
        assertTrue(count.isInValidLineIndex(4));
        assertTrue(count.isInValidLineIndex(5));
    }

    @Test
    void equals_테스트() {
        PersonCount count1 = PersonCount.from(5);
        PersonCount count2 = PersonCount.from(5);
        PersonCount count3 = PersonCount.from(3);
        
        assertEquals(count1, count2);
        assertNotEquals(count1, count3);
        assertNotEquals(count1, null);
    }
}