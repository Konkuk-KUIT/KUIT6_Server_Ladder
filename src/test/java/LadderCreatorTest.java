import ladder.Constant.LadderType;
import ladder.Creator.LadderCreator;
import ladder.Creator.LadderCreatorFactory;
import ladder.Domain.GreaterThanOne;
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

        //when
        LadderCreator ladderCreator = LadderCreatorFactory.getLadderCreator(LadderType.LADDER_TYPE_MANUAL, numberOfRow, numberOfPerson);
        //then
        assertThat(ladderCreator).isNotNull();
    }
    @Test
    @DisplayName("자동 사다리 생성 확인")
    public void testAutoCreateLadder () throws Exception {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderCreator ladderCreator = LadderCreatorFactory.getLadderCreator(LadderType.LADDER_TYPE_AUTO, numberOfRow, numberOfPerson);
        //then
        assertThat(ladderCreator).isNotNull();
    }
  
}