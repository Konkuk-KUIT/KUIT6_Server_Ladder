import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("사다리 가로 설치")
    public void setUpLadder () throws Exception {
        //given
        Ladder ladder = new Ladder(13, 4);
        //when & then
        ladder.drawLine(new Position(0,2));
        ladder.drawLine(new Position(1,1));
        ladder.drawLine(new Position(2,0));
        ladder.drawLine(new Position(3,2));
        ladder.drawLine(new Position(4,1));
        ladder.drawLine(new Position(5,0));
        ladder.drawLine(new Position(6,0));
        ladder.drawLine(new Position(7,1));
        ladder.drawLine(new Position(8,1));
        ladder.drawLine(new Position(9,1));
        ladder.drawLine(new Position(10,2));
        ladder.drawLine(new Position(11,0));
        ladder.drawLine(new Position(12,1));
    }

    @Test
    @DisplayName("줄 선택 후 결과 확인")
    public void checkLadderResult () throws Exception {
        //given
        Ladder ladder = new Ladder(13, 4);
        //when & then
        ladder.drawLine(new Position(0,2));
        ladder.drawLine(new Position(1,1));
        ladder.drawLine(new Position(2,0));
        ladder.drawLine(new Position(3,2));
        ladder.drawLine(new Position(4,1));
        ladder.drawLine(new Position(5,0));
        ladder.drawLine(new Position(6,0));
        ladder.drawLine(new Position(7,1));
        ladder.drawLine(new Position(8,1));
        ladder.drawLine(new Position(9,1));
        ladder.drawLine(new Position(10,2));
        ladder.drawLine(new Position(11,0));
        ladder.drawLine(new Position(12,1));

        System.out.println(ladder.run(2));
    }

}