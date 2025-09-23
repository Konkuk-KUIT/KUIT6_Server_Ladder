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
        DuplicateLineException exception = new DuplicateLineException(null);
        
        assertNull(exception.getMessage());
    }
}