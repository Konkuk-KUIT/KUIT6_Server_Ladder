import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class LadderTest {

    @Test
    @DisplayName("3X4 성공적으로 사다리 타기")
    public void test1() {
        Ladder ladder = new Ladder(4, 3);
        ladder.drawLine(new Position(0, 1), new Position(1, 1));
        ladder.drawLine(new Position(1, 2), new Position(2, 2));

        assertThat(ladder.run(0)).isEqualTo(2);
        assertThat(ladder.run(1)).isEqualTo(0);
        assertThat(ladder.run(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("4X5 성공적으로 사다리 타기")
    public void test2() {
        Ladder ladder = new Ladder(5, 4);
        ladder.drawLine(new Position(0, 1), new Position(1, 1));
        ladder.drawLine(new Position(2, 1), new Position(3, 1));
        ladder.drawLine(new Position(1, 2), new Position(2, 2));
        ladder.drawLine(new Position(1, 3), new Position(2, 3));

        assertThat(ladder.run(0)).isEqualTo(1);
        assertThat(ladder.run(1)).isEqualTo(0);
        assertThat(ladder.run(2)).isEqualTo(3);
        assertThat(ladder.run(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("경계를 넘어서 사다리를 탈 때")
    public void test3() {
        Ladder ladder = new Ladder(4, 3);

        assertThatThrownBy(() -> ladder.run(-1))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> ladder.run(3))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("사다리의 경계를 이을 때")
    public void test4() {
        Ladder ladder = new Ladder(5, 4);
        assertThatThrownBy(() -> ladder.drawLine(new Position(0, 0), new Position(1, 0)))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> ladder.drawLine(new Position(0, 4), new Position(1, 4)))
                .isInstanceOf(IllegalStateException.class);

    }

    @Test
    @DisplayName("경계 밖을 이을 때")
    public void test5() {
        Ladder ladder = new Ladder(5, 4);
        assertThatThrownBy(() -> ladder.drawLine(new Position(-1, 1), new Position(0, 1)))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("사다리를 여러 개 한 번에 이을 때")
    public void test6() {
        Ladder ladder = new Ladder(5, 4);
        assertThatThrownBy(() -> ladder.drawLine(new Position(0, 1), new Position(2, 1)))
                .isInstanceOf(IllegalStateException.class);
    }
    @Test
    @DisplayName("높이가 다른 지점을 이을 때")
    public void test7() {
        Ladder ladder = new Ladder(5, 4);
        assertThatThrownBy(() -> ladder.drawLine(new Position(0, 1), new Position(2, 2)))
                .isInstanceOf(IllegalStateException.class);
    }


}