package wrap;

import exceptions.InvalidNodeIndexException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeIndexTest {

    @Test
    void NodeIndex_at_정상_생성_테스트() {
        NodeIndex index = NodeIndex.at(3);
        
        assertEquals(3, index.getValue());
    }

    @Test
    void 음수_입력_시_InvalidNodeIndexException_발생_테스트() {
        assertThrows(InvalidNodeIndexException.class, () -> NodeIndex.at(-1));
        assertThrows(InvalidNodeIndexException.class, () -> NodeIndex.at(-5));
    }

    @Test
    void 영_이상_값_검증_테스트() {
        NodeIndex index0 = NodeIndex.at(0);
        NodeIndex index1 = NodeIndex.at(1);
        NodeIndex index5 = NodeIndex.at(5);
        
        assertEquals(0, index0.getValue());
        assertEquals(1, index1.getValue());
        assertEquals(5, index5.getValue());
    }

    @Test
    void isValidFor_PersonCount_검증_로직_테스트() {
        NodeIndex index = NodeIndex.at(2);
        PersonCount personCount = PersonCount.of(5);
        
        assertTrue(!index.isValidFor(personCount));
    }

    @Test
    void isValidFor_PersonCount와의_경계값_테스트() {
        PersonCount personCount = PersonCount.of(3);
        
        NodeIndex validIndex0 = NodeIndex.at(0);
        NodeIndex validIndex2 = NodeIndex.at(2);
        NodeIndex invalidIndex3 = NodeIndex.at(3);
        
        assertFalse(validIndex0.isValidFor(personCount));
        assertTrue(validIndex2.isValidFor(personCount));
        assertTrue(invalidIndex3.isValidFor(personCount));
    }

    @Test
    void equals_테스트() {
        NodeIndex index1 = NodeIndex.at(5);
        NodeIndex index2 = NodeIndex.at(5);
        NodeIndex index3 = NodeIndex.at(3);
        
        assertEquals(index1, index2);
        assertNotEquals(index1, index3);
        assertNotEquals(index1, null);
    }
}