package creator;

import static org.junit.jupiter.api.Assertions.*;

import creator.CustomLadderCreator;
import domain.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("creator.CustomLadderCreator 단위 테스트")
class CustomLadderCreatorTest {

    @Test
    @DisplayName("같은 위치에 drawLine 중복 시 예외 발생")
    void drawLineException() {
        LadderSize size = new LadderSize(2, 3);
        CustomLadderCreator creator = new CustomLadderCreator(size);

        creator.drawLine(0, 0);

        assertThrows(IllegalArgumentException.class,
                () -> creator.drawLine(0, 0));
    }
}
