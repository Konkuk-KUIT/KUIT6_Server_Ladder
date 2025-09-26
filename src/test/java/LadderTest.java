import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;
import ladder.domain.LadderSize;
import ladder.domain.Row;
import ladder.validator.GreaterThanOne;
import ladder.game.LadderGame;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LadderTest {


    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        CustomLadderCreator ladderCreator = new CustomLadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        Position position = Position.from(4);

        assertThatThrownBy(() -> ladderGame.run(position)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        GreaterThanOne row = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = new LadderSize(row, numberOfPerson);

        CustomLadderCreator ladderCreator = new CustomLadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(1));
        ladderCreator.drawLine(Position.from(2), Position.from(0));

        Position nthOfPerson = Position.from(0);
        assertThat(ladderGame.run(nthOfPerson)).isEqualTo(2);

        nthOfPerson = Position.from(1);
        assertThat(ladderGame.run(nthOfPerson)).isEqualTo(1);

        nthOfPerson = Position.from(2);
        assertThat(ladderGame.run(nthOfPerson)).isEqualTo(0);
    }
}
