package exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorMessageTest {

    @Test
    void INVALID_PERSON_COUNT_메시지_내용_검증() {
        String expectedMessage = "사람의 수가 0 이하인 경우 게임 진행이 불가합니다";
        
        assertEquals(expectedMessage, ErrorMessage.INVALID_PERSON_COUNT.getMessage());
    }

    @Test
    void INVALID_LADDER_HEIGHT_메시지_내용_검증() {
        String expectedMessage = "사다리 높이는 0보다 커야 합니다";
        
        assertEquals(expectedMessage, ErrorMessage.INVALID_LADDER_HEIGHT.getMessage());
    }

    @Test
    void format_메서드_동작_테스트() {
        String formattedMessage = ErrorMessage.INVALID_COORDINATE_Y.format(5, 3);
        String expectedMessage = "Y 좌표가 범위를 벗어났습니다: 5 (0-3)";
        
        assertEquals(expectedMessage, formattedMessage);
    }

    @Test
    void 모든_에러_메시지가_비어있지_않음_확인() {
        for (ErrorMessage errorMessage : ErrorMessage.values()) {
            assertNotNull(errorMessage.getMessage());
            assertFalse(errorMessage.getMessage().isEmpty());
        }
    }
}