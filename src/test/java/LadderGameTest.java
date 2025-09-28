import ladder.core.LadderGame;
import ladder.core.LadderGameFactory;
import ladder.unit.LadderPosition;
import ladder.unit.LadderSize;
import ladder.unit.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        LadderGame ladderGame = LadderGameFactory.customLadderGame(LadderSize.of(2, 3));

        //given
        Position nthOfPerson = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(nthOfPerson))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        //when
        LadderGame ladderGame = LadderGameFactory.customLadderGame(LadderSize.of(3, 5));

        ladderGame.getLadderCreator().drawLine(LadderPosition.of(0,Position.from(0)));
        ladderGame.getLadderCreator().drawLine(LadderPosition.of(1,Position.from(1)));
        ladderGame.getLadderCreator().drawLine(LadderPosition.of(2,Position.from(0)));

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
    @DisplayName("랜덤 사다리 결과 확인")
    void testRandomLadderResult() {
        //when
        LadderGame ladderGame = LadderGameFactory.randomLadderGame(LadderSize.of(3, 5));

        ladderGame.getLadderCreator().drawLine();

        //given
        Position nthOfPerson = Position.from(0);

        //then
        ladderGame.run(nthOfPerson);

        //given
        nthOfPerson = Position.from(1);

        //then
        ladderGame.run(nthOfPerson);

        //given
        nthOfPerson = Position.from(2);

        //then
        ladderGame.run(nthOfPerson);
    }
}