import ladder.LadderPosition;
import ladder.factory.LadderGameFactory;
import ladder.model.GreaterThanOne;
import ladder.model.Position;
import ladder.LadderGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LadderGameTest {

    @Test
    @DisplayName("일반 게임 run 테스트")
    void testNormalLadderGameRuns() {

        List<LadderPosition> ladderPositions = new ArrayList<>();
        ladderPositions.add(new LadderPosition(1, 1));
        ladderPositions.add(new LadderPosition(3, 0));
        ladderPositions.add(new LadderPosition(4, 1));

        LadderGame game = LadderGameFactory.createNormalLadder(GreaterThanOne.from(5), GreaterThanOne.from(3), ladderPositions);

        int result1 = game.run(Position.from(1));
        assertThat(result1).isEqualTo(1);

        int result2 = game.run(Position.from(2));
        assertThat(result2).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 게임 run 테스트")
    void testRandomLadderGameRuns() {
        LadderGame game = LadderGameFactory.createRandomLadder(GreaterThanOne.from(5), GreaterThanOne.from(3));
        for (int start = 0; start < 3; start++) {
            int result = game.run(Position.from(start));
            assertTrue(result >= 0 && result <= 4);
        }
    }

    @Test
    @DisplayName("일반 게임 print 테스트")
    void testNormalLadderGamePrint() {

        List<LadderPosition> ladderPositions = new ArrayList<>();
        ladderPositions.add(new LadderPosition(1, 0));
        ladderPositions.add(new LadderPosition(2, 1));
        ladderPositions.add(new LadderPosition(3, 1));

        LadderGame game = LadderGameFactory.createNormalLadder(GreaterThanOne.from(5), GreaterThanOne.from(3), ladderPositions);

        System.out.println("-------- 일반 사다리 테스트 --------");
        game.runWithPrint(Position.from(1));
        game.runWithPrint(Position.from(0));
    }

    @Test
    @DisplayName("랜덤 게임 print 테스트")
    void testRandomLadderGamePrint() {
        LadderGame game = LadderGameFactory.createRandomLadder(GreaterThanOne.from(5), GreaterThanOne.from(3));

        System.out.println("-------- 랜덤 사다리 테스트 --------");
        game.runWithPrint(Position.from(1));
    }
}
