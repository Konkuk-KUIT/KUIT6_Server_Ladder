import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;
import ladder.domain.LadderSize;
import ladder.domain.Position;
import ladder.game.LadderGame;
import ladder.game.LadderGameFactory;
import ladder.validator.GreaterThanOne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderCreatorTest {
    @Test
    @DisplayName("사다리 기본 생성 확인")
    void testCustomCreateLadder() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        //when
//        LadderCreator ladderCreator = new CustomLadderCreator(ladderSize);
        LadderGame ladderGame = LadderGameFactory.customLadderGame(ladderSize);

        //then
        Position nthOfPerson = Position.from(0);
        ladderGame.run(nthOfPerson);
        assertThat(ladderGame).isNotNull();
    }

    @Test
    @DisplayName("사다리 랜덤 생성 확인")
    void testRandomCreateLadder() {
        GreaterThanOne numberOfRow = GreaterThanOne.from(5);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        LadderGame ladderGame = LadderGameFactory.randomLadderGame(ladderSize);

        Position nthOfPerson = Position.from(0);
        ladderGame.run(nthOfPerson);
        assertThat(ladderGame).isNotNull();
    }


}