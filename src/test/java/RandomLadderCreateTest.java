import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomLadderCreateTest {
    LadderGame ladderGame;

    @Test
    @DisplayName("랜덤 사다리 생성 확인")
    void createLadder(){
        ladderGame = LadderGameFactory.createRandomLadderGame(7,7);
        assertThat(ladderGame).isNotNull();
    }

    @Test
    @DisplayName("랜덤 사다리 출력")
    void drawAndShowLadder(){
        ladderGame = LadderGameFactory.createRandomLadderGame(7, 7);
        Ladder ladder = new Ladder(ladderGame.getRows());
        ladder.showTotalLadder();
    }
}
