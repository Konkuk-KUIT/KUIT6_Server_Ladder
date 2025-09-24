import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderGameTest {
    @Test
    @DisplayName("사다리 게임 생성 테스트")
    void LadderGameCreateTest() {
        // given
        LadderGame ladderGame = new LadderGame(new LadderCreator(GreaterThanOne.from(5), GreaterThanOne.from(5)));
        //when

        //then

    }
}
