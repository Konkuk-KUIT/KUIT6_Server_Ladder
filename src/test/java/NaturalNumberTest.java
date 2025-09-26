import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("NaturalNumber 테스트")
class NaturalNumberTest {
    @Test
    @DisplayName("0 이하의 숫자로 생성하면 예외")
    void negativeAndZeroException() {
        assertThrows(IllegalArgumentException.class, () -> new NaturalNumber(0));
        assertThrows(IllegalArgumentException.class, () -> new NaturalNumber(-5));
    }

    @Test
    @DisplayName("자연수 생성 확인")
    void success() {
        NaturalNumber n = new NaturalNumber(5);
        assertEquals(5, n.value());
    }

    @Test
    @DisplayName("add 확인")
    void addSuccess() {
        NaturalNumber n = new NaturalNumber(3);
        NaturalNumber result = n.add(2);
        assertEquals(5, result.value());
    }

    @Test
    @DisplayName("subtract 확인")
    void subtractSuccess() {
        NaturalNumber n = new NaturalNumber(5);
        NaturalNumber result = n.subtract(2);
        assertEquals(3, result.value());
    }

    @Test
    @DisplayName("subtract 결과가 0 이하일 경우 예외")
    void subtractException() {
        NaturalNumber n = new NaturalNumber(2);
        assertThrows(IllegalArgumentException.class, () -> n.subtract(5));
    }
}