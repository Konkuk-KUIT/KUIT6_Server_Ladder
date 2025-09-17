import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리생성")
    void TestDrawLadder() {
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(6));
        ladder.drawLine();
        LadderView.printRaw(ladder);
        LadderView.printAscii(ladder);
    }

    @Test
    @DisplayName("사다리실행")
    void TestRunLadder() {
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(6));
        ladder.drawLine();
        LadderView.printRaw(ladder);
        for(int i = 1; i <= 6; i++){
            System.out.println(i+" "+ ladder.run(NaturalNumber.from(i)));
        }
    }

    @Test
    @DisplayName("row, col 값 이상 확인(error throw check)")
    void errorThrowCheckByValues() {
        NaturalNumber col = NaturalNumber.from(6);
        Ladder ladder = new Ladder(NaturalNumber.from(5), col);
        ladder.drawLine();

        assertThrows(IllegalArgumentException.class, () -> ladder.run(NaturalNumber.from(-1)));

        assertThrows(IllegalArgumentException.class, () -> ladder.run(NaturalNumber.from(0)));
        assertDoesNotThrow(() -> ladder.run(NaturalNumber.from(1)));
        assertDoesNotThrow(() -> ladder.run(col));
        assertThrows(IllegalArgumentException.class, () -> ladder.run(NaturalNumber.from(col.getNumber()+1)));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(NaturalNumber.from(5), NaturalNumber.from(-1)));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(NaturalNumber.from(5), NaturalNumber.from(0)));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(NaturalNumber.from(-1), NaturalNumber.from(6)));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(NaturalNumber.from(0), NaturalNumber.from(6)));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(NaturalNumber.from(-1), NaturalNumber.from(-1)));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(NaturalNumber.from(0), NaturalNumber.from(0)));
    }

    @Test
    @DisplayName("초기화안된 사다리에 run()했을 경우")
    void runInEmptyLadder() {
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(6));
        assertThat(ladder.run(NaturalNumber.from(3))).isEqualTo(0); //자바에선 기본적으로 0으로 초기화되기에, 0이 return된다.
    }

}