package ladder.app;

import ladder.domain.LadderSize;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameFactoryTest {

    @Test
    @DisplayName("예외 없이 실행되고 최종 위치가 [0, persons-1] 범위여야 한다")
    void randomGameBuildAndRunOK() {
        LadderSize size = new LadderSize(7, 5);
        LadderGame game = LadderGameFactory.randomLadderGame(size);

        int end = game.run(Position.from(0)).getValue();

        assertThat(end).isBetween(0, size.persons() - 1);
    }

    @Test
    @DisplayName("같은 seed면 시작→끝 매핑이 동일해야 한다")
    void SameSeedSameResult() {
        LadderSize size = new LadderSize(5, 5);
        long seed = 10;

        LadderGame game1 = LadderGameFactory.randomLadderGame(size, seed);
        LadderGame game2 = LadderGameFactory.randomLadderGame(size, seed);

        int persons = size.persons();
        int[] m1 = new int[persons];
        int[] m2 = new int[persons];

        for (int s = 0; s < persons; s++) {
            m1[s] = game1.run(Position.from(s)).getValue();
            m2[s] = game2.run(Position.from(s)).getValue();
        }

        assertThat(m1).isEqualTo(m2);
    }

}
