import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GreaterThanOneTest {
    @Test
    @DisplayName("GreaterThanOne 생성")
    void createGreaterThanOne() {
        // given
        GreaterThanOne num = new GreaterThanOne(3);
        //when & then
        assertThat(num.getNumber()).isEqualTo(3);
        assertThat(GreaterThanOne.from(2).getNumber()).isEqualTo(2);
    }

    @Test
    @DisplayName("1 이하의 숫자 생성 시 예외처리")
    void smallerThanTwoException() {
        // given
        assertThrows(IllegalArgumentException.class,
                () -> {
                    GreaterThanOne.from(0);
                });
        //when

        //then

    }
}