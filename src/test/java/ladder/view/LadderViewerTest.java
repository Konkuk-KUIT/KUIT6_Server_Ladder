package ladder.view;

import ladder.domain.GreaterThanOne;
import ladder.domain.PlayerState;
import ladder.domain.Position;
import ladder.domain.Row;
import ladder.build.LadderCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderViewerTest {

    @Test
    @DisplayName("사다리 그리기 테스트")
    public void printLadderTest() throws Exception {
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(4), numberOfPerson);


        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(1));

        PlayerState playerState = PlayerState.from(1, Position.from(0));

        // LadderViewer를 생성합니다.
        Row[] rows = ladderCreator.getRows();

        LadderViewer ladderViewer = LadderViewer.from();

        // when: 사다리를 출력합니다.
        ladderViewer.print(rows,playerState,0);
     }

}