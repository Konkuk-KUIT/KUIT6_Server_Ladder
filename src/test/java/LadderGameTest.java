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
    void simulateRandomLadderGame() {
        GreaterThanOne rowCount = GreaterThanOne.from(5);
        GreaterThanOne playerCount = GreaterThanOne.from(4);

        LadderCreator creator = new RandomLadderCreator(rowCount, playerCount);

        LadderGame game = new LadderGame(creator);

    }

}