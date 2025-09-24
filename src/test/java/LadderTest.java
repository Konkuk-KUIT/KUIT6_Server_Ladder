import Ladder.Creator.LadderCreator;
import Ladder.GreaterThanOne;
import Ladder.LadderGame;
import Ladder.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class LadderTest {


    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(2), numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        //when
        GreaterThanOne row = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(1));
        ladderCreator.drawLine(Position.from(2),Position.from(0));

        //given
        Position nthOfPerson = Position.from(0);
        Position endPosition = ladderGame.run(nthOfPerson);

        //then
        assertThat(endPosition.getValue()).isEqualTo(2);

        //given
        nthOfPerson = Position.from(1);
        endPosition = ladderGame.run(nthOfPerson);

        //then
        assertThat(endPosition.getValue()).isEqualTo(1);

        //given
        nthOfPerson = Position.from(2);
        endPosition = ladderGame.run(nthOfPerson);

        //then
        assertThat(endPosition.getValue()).isEqualTo(0);
    }

}