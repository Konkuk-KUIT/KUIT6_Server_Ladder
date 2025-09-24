package ladder;

import ladder.app.LadderGame;
import ladder.build.LadderCreator;
import ladder.domain.GreaterThanOne;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderRunnerTest {
    @Test
    @DisplayName("사다리 타기 테스트")
    public void LadderRunnderTest() throws Exception {
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
     }

}