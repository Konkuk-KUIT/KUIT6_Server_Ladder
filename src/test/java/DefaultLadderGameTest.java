import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultLadderGameTest {
    LadderGame ladderGame = LadderGameFactory.createDefaultLadderGame(7, 7);
//    LadderCreator ladderCreator = ladderGame.getLadderCreator();

    @BeforeEach
    void setUp() {
        ladderGame.drawLine(new Position(0,0));
        ladderGame.drawLine(new Position(1,1));
        ladderGame.drawLine(new Position(2,5));
        ladderGame.drawLine(new Position(5,2));
//        ladderCreator.drawLine(new Position(0, 0));
//        ladderCreator.drawLine(new Position(1, 1));
//        ladderCreator.drawLine(new Position(2, 5));
//        ladderCreator.drawLine(new Position(5, 2));
    }


    @Test
    @DisplayName("사다리 게임 정상 작동 테스트")
    void testGame() {
        assertEquals(2, ladderGame.run(1));
//        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
//        assertEquals(2, ladderRunner.run(1));
    }

}
