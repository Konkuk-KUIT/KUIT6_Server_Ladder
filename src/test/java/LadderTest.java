import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne row = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(LadderSize.from(row, numberOfPerson));
        LadderGame ladderGame = new LadderGame(manualLadderCreator);

        //given
        Position positionn = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(positionn))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(LadderSize.from(row, numberOfPerson));
        LadderGame ladderGame = new LadderGame(manualLadderCreator);

        manualLadderCreator.drawLine(Position.from(0),Position.from(0));
        manualLadderCreator.drawLine(Position.from(1),Position.from(1));
        manualLadderCreator.drawLine(Position.from(2),Position.from(0));

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