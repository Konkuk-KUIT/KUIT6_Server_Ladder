import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderGameTest {

    @Test
    void moveRightOnSingleLine() {
        // given
        GreaterThanOne playerCount = GreaterThanOne.from(3);
        LadderLine line = new LadderLine(playerCount);

        PlayerPosition startCol = PlayerPosition.from(0);
        line.drawLine(startCol);

        // when
        PlayerPosition pos = PlayerPosition.from(0);
        line.move(pos);

        // then
        assertEquals(1, pos.getValue());
    }

    @Test
    void moveLeftOnSingleLine() {
        // given
        GreaterThanOne playerCount = GreaterThanOne.from(3);
        LadderLine line = new LadderLine(playerCount);

        PlayerPosition startCol = PlayerPosition.from(0);
        line.drawLine(startCol);

        // when
        PlayerPosition pos = PlayerPosition.from(1);
        line.move(pos);

        // then
        assertEquals(0, pos.getValue());
    }

    @Test
    @DisplayName("CustomLadderCreator 기반 사다리 게임 실행 테스트")
    void runGameWithCustomCreator() {
        GreaterThanOne rowCount = GreaterThanOne.from(4);
        GreaterThanOne playerCount = GreaterThanOne.from(4);

        LadderCreator creator = new CustomLadderCreator(rowCount, playerCount);
        creator.drawLine(PlayerPosition.from(0), PlayerPosition.from(0));
        creator.drawLine(PlayerPosition.from(1), PlayerPosition.from(2));
        creator.drawLine(PlayerPosition.from(2), PlayerPosition.from(1));


        LadderGame game = new LadderGame(creator);

        int startCol = 0;
        game.run(PlayerPosition.from(startCol));
    }

    @Test
    @DisplayName("RandomLadderCreator 기반 사다리 게임 실행 테스트")
    void runGameWithRandomCreator() {
        GreaterThanOne rowCount = GreaterThanOne.from(5);
        GreaterThanOne playerCount = GreaterThanOne.from(4);

        LadderCreator creator = new RandomLadderCreator(rowCount, playerCount);
        LadderGame game = new LadderGame(creator);

        int startCol = 2;
        game.run(PlayerPosition.from(startCol));

    }


}