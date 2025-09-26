import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomLadderGameTest {
    LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        ladderGame = LadderGameFactory.createRandomLadderGame(7,7);
    }


    @Test
    @DisplayName("사다리 게임 정상 작동 테스트")
    void testGame() {
        System.out.println("resultCol: "+ladderGame.run(1));
//        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
//        assertEquals(2, ladderRunner.run(1));
    }
}
