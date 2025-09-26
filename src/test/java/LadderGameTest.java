import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderGameTest {

    @Test
    void moveRightOnSingleLine() {
        // given
        GreaterThanOne playerCount = GreaterThanOne.from(3); // 플레이어 3명
        LadderLine line = new LadderLine(playerCount);

        PlayerPosition startCol = PlayerPosition.from(0);
        line.drawLine(startCol);

        // when
        PlayerPosition pos = PlayerPosition.from(0);
        line.move(pos);

        // then
        assertEquals(1, pos.getValue()); // 오른쪽으로 이동해야 함
    }

    @Test
    void moveLeftOnSingleLine() {
        // given
        GreaterThanOne playerCount = GreaterThanOne.from(3);
        LadderLine line = new LadderLine(playerCount);

        // col = 0 에서 오른쪽으로 연결 -> col=1 은 자동으로 왼쪽
        PlayerPosition startCol = PlayerPosition.from(0);
        line.drawLine(startCol);

        // when
        PlayerPosition pos = PlayerPosition.from(1);
        line.move(pos);

        // then
        assertEquals(0, pos.getValue()); // 왼쪽으로 이동해야 함
    }


    @Test
    void simulateMultipleLineMovements() {
        GreaterThanOne rowCount = GreaterThanOne.from(4);
        GreaterThanOne playerCount = GreaterThanOne.from(5);

        LadderCreator creator = new LadderCreator(rowCount, playerCount);

        creator.drawLine(PlayerPosition.from(0), PlayerPosition.from(0));
        creator.drawLine(PlayerPosition.from(1), PlayerPosition.from(1));

        LadderGame game = new LadderGame(creator);

        game.run(PlayerPosition.from(0));
    }

}