import ladder.core.LadderGame;
import ladder.core.LadderGameFactory;
import ladder.unit.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomLadderCreatorTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        //given
        LadderGame ladderGame = LadderGameFactory.customLadderGame(LadderSize.of(3, 5));

        //then
        assertThat(ladderGame).isNotNull();
    }

}