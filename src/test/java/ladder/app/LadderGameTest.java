package ladder.app;

import ladder.build.CustomLadderCreator;
import ladder.domain.GreaterThanOne;
import ladder.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void run_returnsFinalPosition() {
        CustomLadderCreator creator =
                new CustomLadderCreator(GreaterThanOne.from(3), GreaterThanOne.from(4));

        creator.drawLine(Position.from(0), Position.from(1));
        creator.drawLine(Position.from(1), Position.from(0));

        LadderGame game = new LadderGame(creator);

        assertThat(game.run(Position.from(0)).getValue()).isEqualTo(1);
        assertThat(game.run(Position.from(1)).getValue()).isEqualTo(2);
    }
}