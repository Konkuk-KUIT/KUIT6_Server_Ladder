import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("사다리 가로 설치")
    public void setUpLadder () throws Exception {
        //given
        Ladder ladder = new Ladder(NoneNegative.from(13), NoneNegative.from(4));
        //when & then
        ladder.drawLine(new Position(NoneNegative.from(0), NoneNegative.from(2)));
        ladder.drawLine(new Position(NoneNegative.from(0), NoneNegative.from(2)));
        ladder.drawLine(new Position(NoneNegative.from(1), NoneNegative.from(1)));
        ladder.drawLine(new Position(NoneNegative.from(2), NoneNegative.from(0)));
        ladder.drawLine(new Position(NoneNegative.from(3), NoneNegative.from(2)));
        ladder.drawLine(new Position(NoneNegative.from(4), NoneNegative.from(1)));
        ladder.drawLine(new Position(NoneNegative.from(5), NoneNegative.from(0)));
        ladder.drawLine(new Position(NoneNegative.from(6), NoneNegative.from(0)));
        ladder.drawLine(new Position(NoneNegative.from(7), NoneNegative.from(1)));
        ladder.drawLine(new Position(NoneNegative.from(8), NoneNegative.from(1)));
        ladder.drawLine(new Position(NoneNegative.from(9), NoneNegative.from(1)));
        ladder.drawLine(new Position(NoneNegative.from(10), NoneNegative.from(2)));
        ladder.drawLine(new Position(NoneNegative.from(11), NoneNegative.from(0)));
        ladder.drawLine(new Position(NoneNegative.from(12), NoneNegative.from(1)));
    }

    @Test
    @DisplayName("줄 선택 후 결과 확인")
    public void checkLadderResult () throws Exception {
        //given
        Ladder ladder = new Ladder(NoneNegative.from(13), NoneNegative.from(4));
        //when & then
        ladder.drawLine(new Position(NoneNegative.from(0), NoneNegative.from(2)));
        ladder.drawLine(new Position(NoneNegative.from(1), NoneNegative.from(1)));
        ladder.drawLine(new Position(NoneNegative.from(2), NoneNegative.from(0)));
        ladder.drawLine(new Position(NoneNegative.from(3), NoneNegative.from(2)));
        ladder.drawLine(new Position(NoneNegative.from(4), NoneNegative.from(1)));
        ladder.drawLine(new Position(NoneNegative.from(5), NoneNegative.from(0)));
        ladder.drawLine(new Position(NoneNegative.from(6), NoneNegative.from(0)));
        ladder.drawLine(new Position(NoneNegative.from(7), NoneNegative.from(1)));
        ladder.drawLine(new Position(NoneNegative.from(8), NoneNegative.from(1)));
        ladder.drawLine(new Position(NoneNegative.from(9), NoneNegative.from(1)));
        ladder.drawLine(new Position(NoneNegative.from(10), NoneNegative.from(2)));
        ladder.drawLine(new Position(NoneNegative.from(11), NoneNegative.from(0)));
        ladder.drawLine(new Position(NoneNegative.from(12), NoneNegative.from(1)));

        assertThat(ladder.run(2)).isEqualTo(3);
    }

}