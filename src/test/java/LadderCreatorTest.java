import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderCreatorTest {
    @Test
    @DisplayName("사다리 생성 테스트")
    void createLadder () {
        //given
        GreaterThanOne numberOfPeople = GreaterThanOne.from(3);
        GreaterThanOne rows = GreaterThanOne.from(5);
        //when
        LadderCreator ladderCreator = new LadderCreator(rows, numberOfPeople);
        //then
        assertThat(ladderCreator).isNotNull();
    }
}