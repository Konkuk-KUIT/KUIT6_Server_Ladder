package exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateLineExceptionTest {

    @Test
    void 메시지와_함께_예외_생성_테스트() {
        String message = "중복된 라인이 존재합니다";
        
        DuplicateLineException exception = new DuplicateLineException(message);
        
        assertEquals(message, exception.getMessage());
    }

    @Test
    void RuntimeException_상속_확인() {
        DuplicateLineException exception = new DuplicateLineException("test");
        
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    void null_메시지로_예외_생성_테스트() {
        DuplicateLineException exception = new DuplicateLineException((String) null);
        
        assertNull(exception.getMessage());
    }
    
    @Test
    void nodeIndex로_예외_생성_테스트() {
        int nodeIndex = 3;
        
        DuplicateLineException exception = new DuplicateLineException(nodeIndex);
        
        assertEquals(nodeIndex, exception.getNodeIndex());
        assertEquals("Duplicate line at node index: " + nodeIndex, exception.getMessage());
    }
    
    @Test
    void getNodeIndex_테스트() {
        int nodeIndex = 5;
        
        DuplicateLineException exception = new DuplicateLineException(nodeIndex);
        
        assertEquals(nodeIndex, exception.getNodeIndex());
    }
}