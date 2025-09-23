import ladder.*;
import ladder.Creator.CustomLadderCreator;
import ladder.Creator.LadderCreator;
import ladder.Creator.RandomLadderCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        CustomLadderCreator ladderCreator = new CustomLadderCreator(GreaterThanOne.from(2), numberOfPerson);
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
        CustomLadderCreator ladderCreator = new CustomLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(1));
        ladderCreator.drawLine(Position.from(2), Position.from(0));

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
    @DisplayName(("자동 사다리 그리기 결과 확인"))
    void testRandomLadderResult() {
        //when
        GreaterThanOne row = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = LadderSize.from(row, numberOfPerson);
        RandomLadderCreator ladderCreator = LadderGameFactory.createLadderGame(ladderSize);
        ladderCreator.createLadder(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        ladderGame.run(Position.from(0));

    }
}