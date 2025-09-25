import ladder.creator.LadderCreator;
import ladder.creator.NormalLadderCreator;
import ladder.creator.RandomLadderCreator;
import ladder.model.GreaterThanOne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderCreatorTest {

    @Test
    @DisplayName("일반 사다리 생성 확인")
    void testCreateNormalLadder() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderCreator ladderCreator = new NormalLadderCreator(numberOfRow, numberOfPerson);

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    @DisplayName("랜덤 사다리 생성 확인")
    void testCreateRandomLadder() {

        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        LadderCreator ladderCreator = new RandomLadderCreator(numberOfRow, numberOfPerson);

        assertThat(ladderCreator).isNotNull();

    }

}