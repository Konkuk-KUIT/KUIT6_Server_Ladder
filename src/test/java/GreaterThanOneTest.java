import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GreaterThanOneTest {

    @Test
    @DisplayName("동작확인")
    public void testGreaterThanOne() {
        GreaterThanOne from = GreaterThanOne.from(4);
        Assertions.assertEquals(4, from.getValue());

        Assertions.assertThrows(Exception.class,() -> GreaterThanOne.from(0));
    }
}
