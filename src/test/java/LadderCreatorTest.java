import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderCreatorTest {
    @Test
    @DisplayName("사다리 생성 확인")
    public void testCreateLadder () throws Exception{
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        //when
        LadderCreator ladderCreator = new LadderCreator(numberOfRow,numberOfPerson);
        //then
        assertThat(ladderCreator).isNotNull();

     }

}