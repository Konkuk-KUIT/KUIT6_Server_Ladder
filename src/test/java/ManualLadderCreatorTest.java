import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ManualLadderCreatorTest {
    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        // given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        // when
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(LadderSize.from(numberOfRow, numberOfPerson));

        // then
        assertThat(manualLadderCreator).isNotNull();
    }
}