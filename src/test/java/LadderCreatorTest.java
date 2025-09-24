import ladder.core.LadderSize;
import ladder.creator.CustomLadderCreator;
import ladder.util.GreaterThanOne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderCreatorTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        //when
        CustomLadderCreator ladderCreator = new CustomLadderCreator(ladderSize);

        //then
        assertThat(ladderCreator).isNotNull();
    }
  
}