package test.java;

import ladder.core.LadderGame;
import ladder.core.LadderRunner;
import ladder.core.LadderViewer;
import ladder.creator.*;
import ladder.util.GreaterThanOne;
import ladder.position.LadderPosition;
import ladder.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderViewerTest {

    @Test
    @DisplayName("사용자가 사람 수를 입력하면 빈 사다리를 출력한다.")
    void printEmptyLadder() {
        //given
        LadderSize size = new LadderSize(GreaterThanOne.from(4), GreaterThanOne.from(5));
        LadderGame game = LadderGameFactory.customLadderGame(size);
        LadderViewer viewer = new LadderViewer();
        //when
        viewer.snapshotAllRows(game.getRows(), null);
        String actual = viewer.render();
        //then
        System.out.println("빈 사다리 생성\n");
        System.out.print(viewer.render());
        StringBuilder sb = new StringBuilder();
        sb.append("1 1 1 1 1\n")
                .append("1 1 1 1 1\n")
                .append("1 1 1 1 1\n")
                .append("1 1 1 1 1\n\n");
        String expected = sb.toString();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사용자가 좌표를 입력하면 사다리를 생성한다.")
    void drawLadderLine (){
        //given
        LadderSize size = new LadderSize(GreaterThanOne.from(3), GreaterThanOne.from(5));
        LadderGame custom = LadderGameFactory.customLadderGame(size);

        custom.drawLine(Position.from(0), Position.from(1));
        custom.drawLine(Position.from(2), Position.from(3));
        LadderViewer viewer = new LadderViewer();
        //when
        viewer.snapshotAllRows(custom.getRows(), null);
        String actual = viewer.render();
        //then
        System.out.println("사용자가 사다리 라인 생성\n");
        System.out.print(viewer.render());
        StringBuilder sb = new StringBuilder();
        sb.append("1 1 -1 1 1\n")
                .append("1 1 1 1 1\n")
                .append("1 1 1 1 -1\n\n");
        String expected = sb.toString();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("랜덤으로 사다리를 생성한다.(고정 시드로 생성된 사다리를 정확히 렌더링)")
    void drawRandomLine() {
        // given
        LadderSize size = new LadderSize(GreaterThanOne.from(3), GreaterThanOne.from(5));
        LadderGame random = LadderGameFactory.randomLadderGame(size, 42L);
        LadderViewer viewer = new LadderViewer();

        // when
        viewer.snapshotAllRows(random.getRows(), null);
        String actual = viewer.render();

        // then
        System.out.println("랜덤으로 사다리 라인 생성\n");
        System.out.print(viewer.render());
        String expected = new StringBuilder()
                .append("1 -1 1 1 -1\n")
                .append("1 1 1 1 1\n")
                .append("1 -1 1 -1 1\n\n")
                .toString();
        assertThat(actual).isEqualTo(expected);

    }


    @Test
    @DisplayName("사용자가 시작 위치 사다리(열)을 선택하면 사다리를 타고 내려간다.")
    void userMove() {
        //given
        LadderSize size = new LadderSize(GreaterThanOne.from(2), GreaterThanOne.from(3));
        LadderGame custom = LadderGameFactory.customLadderGame(size);
        custom.drawLine(Position.from(0), Position.from(0));
        custom.drawLine(Position.from(1), Position.from(1));
        LadderViewer viewer = new LadderViewer();
        LadderRunner runner = new LadderRunner(custom.getRows(), viewer);
        //when
        runner.run(LadderPosition.of(0,1));
        String actual = viewer.render();
        //then
        System.out.println("사다리 시작 위치 선택 시 위치 변화\n");
        System.out.print(viewer.render());
        StringBuilder sb = new StringBuilder();
        sb.append("Before\n")
                .append("1 -1* 1\n")
                .append("1 1 -1\n\n")
                .append("After\n")
                .append("1* -1 1\n")
                .append("1 1 -1\n\n\n")
                .append("Before\n")
                .append("1 -1 1\n")
                .append("1* 1 -1\n\n")
                .append("After\n")
                .append("1 -1 1\n")
                .append("1* 1 -1\n\n\n");

        String expected = sb.toString();
        assertThat(actual).isEqualTo(expected);
    }


}
