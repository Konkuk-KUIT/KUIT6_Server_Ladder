import Ladder.Creator.CustomLadderCreatorImpl;
import Ladder.Core.GreaterThanOne;
import Ladder.Core.Row;
import Ladder.Ladder.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderCreatorTest {

    @Test
    @DisplayName("빈 사다리 생성")
    void createLadder() {
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        Row[] rows = CustomLadderCreatorImpl.createEmptyLadder(ladderSize).getRows();

        assertThat(rows).isNotNull();
    }

    @Test
    @DisplayName("랜덤 사다리 생성")
    void createRandomLadder() {
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        Row[] rows = CustomLadderCreatorImpl.createEmptyLadder(ladderSize).getRows();

        assertThat(rows).isNotNull();
    }
}