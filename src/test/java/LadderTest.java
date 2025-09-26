import Ladder.Creator.*;
import Ladder.Core.GreaterThanOne;
import Ladder.Ladder.LadderGame;
import Ladder.Ladder.LadderGameFactory;
import Ladder.Core.Position;
import Ladder.Ladder.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        // 근데 row가 1이면?

        //given
        Position nthOfPerson = Position.from(4);
        LadderGame ladderGame = LadderGameFactory.createCustomLadderGame(ladderSize);

        //then
        assertThatThrownBy(() -> ladderGame.run(nthOfPerson))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator = CustomLadderCreatorImpl.createEmptyLadder(ladderSize);

        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(1));
        ladderCreator.drawLine(Position.from(2),Position.from(0));

        //given
        Position nthOfPerson = Position.from(0);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //then
        assertThat(ladderGame.run(nthOfPerson)).isEqualTo(2);

        //given
        nthOfPerson = Position.from(1);

        //then
        assertThat(ladderGame.run(nthOfPerson)).isEqualTo(1);

        //given
        nthOfPerson = Position.from(2);

        //then
        assertThat(ladderGame.run(nthOfPerson)).isEqualTo(0);
    }
}