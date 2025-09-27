import ladder.Constant.LadderType;
import ladder.Creator.LadderCreator;
import ladder.Creator.LadderCreatorFactory;
import ladder.Domain.GreaterThanOne;
import ladder.LadderGame;
import ladder.Domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        GreaterThanOne numberOfRows = GreaterThanOne.from(2);
        LadderCreator ladderCreator = LadderCreatorFactory.getLadderCreator(LadderType.LADDER_TYPE_MANUAL,numberOfPerson,numberOfRows);
        LadderGame ladderGame = LadderGame.createLadderGame(ladderCreator);

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
        LadderCreator ladderCreator = LadderCreatorFactory.getLadderCreator(LadderType.LADDER_TYPE_MANUAL,numberOfPerson,row);
        LadderGame ladderGame = LadderGame.createLadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(1));
        ladderCreator.drawLine(Position.from(2),Position.from(0));

        //given
        Position nthOfPerson = Position.from(0);

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
    @Test
    @DisplayName("자동사다리 결과 확인")
    void testAutoLadderResult() {
        //when
        GreaterThanOne row = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderCreator ladderCreator = LadderCreatorFactory.getLadderCreator(LadderType.LADDER_TYPE_AUTO,numberOfPerson,row);
        LadderGame ladderGame = LadderGame.createLadderGame(ladderCreator);

    }
}