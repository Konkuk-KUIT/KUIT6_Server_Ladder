import ladder.core.LadderSize;
import ladder.creator.CustomLadderCreator;
import ladder.util.GreaterThanOne;
import ladder.core.LadderGame;
import ladder.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        CustomLadderCreator ladderCreator = new CustomLadderCreator(ladderSize);
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
        LadderSize ladderSize = LadderSize.of(row, numberOfPerson);

        CustomLadderCreator ladderCreator = new CustomLadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

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
}