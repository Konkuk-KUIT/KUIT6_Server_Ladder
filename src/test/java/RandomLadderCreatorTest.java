import ladder.core.LadderGame;
import ladder.core.LadderGameFactory;
import ladder.unit.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLadderCreatorTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testRandomCreateLadder() {
        //given
        LadderGame ladderGame = LadderGameFactory.randomLadderGame(LadderSize.of(3, 5));

        //then
        assertThat(ladderGame).isNotNull();
    }

}