package test.java;

import ladder.util.GreaterThanOne;
import ladder.position.LadderPosition;
import ladder.creator.LadderCreator;
import ladder.core.LadderGame;
import ladder.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("같은 층에서 (col)~(col+1)을 연결하면 양방향으로 서로 바뀐다")
    void singleConnection_swapsNeighbors() {
        //given
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(2), GreaterThanOne.from(3));
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0), Position.from(0)); // row0: 1-2 연결

        //when&then
        assertEquals(2, ladderGame.run(LadderPosition.of(0,0))); // 1→2
        assertEquals(1, ladderGame.run(LadderPosition.of(0,1))); // 2→1
        assertEquals(3, ladderGame.run(LadderPosition.of(0,2))); // 3은 영향 없음
    }

    @Test
    @DisplayName("같은 row에서 연속 가로선은 금지된다")
    void noSequenceDrawLineInSameRow(){
        //given
        LadderCreator ladderCreater = new LadderCreator(GreaterThanOne.from(2), GreaterThanOne.from(5));

        //when
        ladderCreater.drawLine(Position.from(0), Position.from(1));
        assertThrows(IllegalArgumentException.class, () -> ladderCreater.drawLine(Position.from(0), Position.from(0)));
        assertThrows(IllegalArgumentException.class, () -> ladderCreater.drawLine(Position.from(0), Position.from(2)));

        //then
        ladderCreater.drawLine(Position.from(0), Position.from(3));
    }

    @Test
    @DisplayName("왼쪽 연결을 우선 감지한다(오른쪽 검사 전에 왼쪽을 본다)")
    void preferLeftWhenOnRightSideOfABar() {
        //given
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(2), GreaterThanOne.from(3));
        LadderGame ladderGame = new LadderGame(ladderCreator);
        ladderCreator.drawLine(Position.from(0), Position.from(0)); // row0: 1-2


        //when
        int result = ladderGame.run(LadderPosition.of(0,1)); // col=1에서 왼쪽(rows[0][0]) 먼저 체크

        //then
        assertEquals(1, result);
    }

    @Test
    @DisplayName("오른쪽에 선이 있으면 오른쪽으로, 왼쪽에 선이 있으면 왼쪽으로 이동한다")
    void moveLeftOrRightPerRow() {
        //given
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(2), GreaterThanOne.from(3));
        LadderGame ladderGame = new LadderGame(ladderCreator);
        ladderCreator.drawLine(Position.from(0), Position.from(0)); // row0: 1-2
        ladderCreator.drawLine(Position.from(1), Position.from(1)); // row1: 2-3

        //when
        int from1 = ladderGame.run(LadderPosition.of(0,0)); // row0: 1→2, row1: 2→3  => 3
        int from2 = ladderGame.run(LadderPosition.of(0,1)); // row0: 2→1(left 우선), row1: 1 유지 => 1
        int from3 = ladderGame.run(LadderPosition.of(0,2)); // row0: 3 유지, row1: 3→2(left) => 2

        //then
        assertEquals(3, from1);
        assertEquals(1, from2);
        assertEquals(2, from3);
    }





}