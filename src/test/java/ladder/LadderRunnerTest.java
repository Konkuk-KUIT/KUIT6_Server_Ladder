package ladder;

import ladder.app.LadderGame;
import ladder.build.CustomLadderCreator;
import ladder.domain.GreaterThanOne;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRunnerTest {

    @Test
    @DisplayName("사다리 타기 기본 경로 테스트")
    void run_basicPath_ok() {
        // given
        GreaterThanOne rows = GreaterThanOne.from(4);
        GreaterThanOne persons = GreaterThanOne.from(3);
        CustomLadderCreator creator = new CustomLadderCreator(rows, persons);

        // 가로선
        creator.drawLine(Position.from(0), Position.from(0));
        creator.drawLine(Position.from(1), Position.from(1));
        creator.drawLine(Position.from(2), Position.from(0));

        LadderGame game = new LadderGame(creator);

        // when
        Position end = game.run(Position.from(0));

        // then
        assertThat(end.getValue()).isEqualTo(2);
    }
}