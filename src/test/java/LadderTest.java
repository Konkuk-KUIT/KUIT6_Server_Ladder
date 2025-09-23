import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class LadderTest {

    @Test
    @DisplayName("3X4 성공적으로 사다리 타기")
    public void test1() {
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(4), GreaterThanOne.from(3));
        ladderCreator.drawLine(Position.from(0, 1));
        ladderCreator.drawLine(Position.from(1, 2));
        LadderGame ladderGame = new LadderGame(ladderCreator);

        assertThat(ladderGame.run(0)).isEqualTo(2);
        assertThat(ladderGame.run(1)).isEqualTo(0);
        assertThat(ladderGame.run(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("4X5 성공적으로 사다리 타기")
    public void test2() {
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(5), GreaterThanOne.from(4));
        ladderCreator.drawLine(Position.from(0, 1));
        ladderCreator.drawLine(Position.from(2, 1));
        ladderCreator.drawLine(Position.from(1, 2));
        ladderCreator.drawLine(Position.from(1, 3));
        LadderGame ladderGame = new LadderGame(ladderCreator);

        assertThat(ladderGame.run(0)).isEqualTo(1);
        assertThat(ladderGame.run(1)).isEqualTo(0);
        assertThat(ladderGame.run(2)).isEqualTo(3);
        assertThat(ladderGame.run(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("경계를 넘어서 사다리를 탈 때")
    public void test3() {
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(4), GreaterThanOne.from(3));
        LadderGame ladderGame = new LadderGame(ladderCreator);
        assertThatThrownBy(() -> ladderGame.run(-1))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> ladderGame.run(3))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("사다리의 경계를 이을 때")
    public void test4() {
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(5), GreaterThanOne.from(4));
        assertThatThrownBy(() -> ladderCreator.drawLine(Position.from(0, 0)))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> ladderCreator.drawLine(Position.from(0, 4)))
                .isInstanceOf(IllegalStateException.class);

    }

    @Test
    @DisplayName("경계 밖을 이을 때")
    public void test5() {
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(5), GreaterThanOne.from(4));
        assertThatThrownBy(() -> ladderCreator.drawLine(Position.from(-1, 1)))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("사다리 랜덤 생성")
    public void test6() {
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(GreaterThanOne.from(8), GreaterThanOne.from(8));
        System.out.println(ladderGame.run(0));
    }
}