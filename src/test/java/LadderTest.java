import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리생성")
    void TestDrawLadder() {
        Ladder ladder = new Ladder(5, 6);
        ladder.drawLine();
        ladder.drawLadder();
    }

    @Test
    @DisplayName("사다리실행")
    void TestRunLadder() {
        Ladder ladder = new Ladder(5, 6);
        ladder.drawLine();
        ladder.drawLadder();
        for(int i = 1; i <= 6; i++){
            System.out.println(i+" "+ ladder.run(i));
        }
    }

    @Test
    @DisplayName("row, col 값 이상 확인(error throw check)")
    void errorThrowCheckByValues() {
        int col = 6;
        Ladder ladder = new Ladder(5, col);
        ladder.drawLine();

        assertThrows(IllegalArgumentException.class, () -> ladder.run(-1));

        assertThrows(IllegalArgumentException.class, () -> ladder.run(0));
        assertDoesNotThrow(() -> ladder.run(1));
        assertDoesNotThrow(() -> ladder.run(col));
        assertThrows(IllegalArgumentException.class, () -> ladder.run(col+1));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(5, -1));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(5, 0));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(-1, 6));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0, 6));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(-1, -1));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0, 0));
    }

}