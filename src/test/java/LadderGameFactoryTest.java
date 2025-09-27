import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class LadderGameFactoryTest {

    @Test
    void createRandomLadderGameAndRun() {
        GreaterThanOne rows = GreaterThanOne.from(5);
        GreaterThanOne players = GreaterThanOne.from(4);

        LadderGame game = LadderGameFactory.createRandomLadderGame(rows, players);
    }
}