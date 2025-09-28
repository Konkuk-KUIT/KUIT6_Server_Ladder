import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintLadderTest {
    @Test
    @DisplayName("사다리 내려가기 출력")
    void printLadder () throws Exception {
        //given
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(4),GreaterThanOne.from(5));
        //when
        PrintLadder printLadder = new PrintLadder(ladderCreator);
        Position position = Position.from(0);
        //then
        printLadder.print(position);
    }

    @Test
    @DisplayName("연결이 있을 경우의 사다리 출력")
    void printRow () {
        //given
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(4),GreaterThanOne.from(5));
        //when
        Position position = Position.from(0);
        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(1));
        PrintLadder printLadder = new PrintLadder(ladderCreator);

        //then
        printLadder.print(position);
    }
}