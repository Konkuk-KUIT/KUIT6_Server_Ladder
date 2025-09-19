import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("객체 생성시 유효한 값이 각 인스턴스 변수에 잘 주입 되어야 한다.")
    void makeLadder_success() {
        // given
        int numberOfLadders = 3;
        int ladderHeight = 3;

        // when
        Ladder ladder = new Ladder(NaturalNumber.from(numberOfLadders), NaturalNumber.from(ladderHeight));

        // then
        assertThat(numberOfLadders).isEqualTo(ladder.getNumberOfLadders());
        assertThat(ladderHeight).isEqualTo(ladder.getLadderHeight());
    }

    @Test
    @DisplayName("객체 생성시 유효한 값이 아닌경우 예외가 발생해야 한다.")
    void makeLadder_fail_negative() {
        // given
        int numberOfLadders = -1;
        int ladderHeight = 3;

        // when & then
        assertThatThrownBy(()->new Ladder(NaturalNumber.from(numberOfLadders), NaturalNumber.from(ladderHeight)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이미 차지되지 않은 포지션에 라인을 그렸을 때 linemap에 반영이 되어야 한다.")
    void drawLine_success(){
        // given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(3));

        // when
        ladder.drawLine(NaturalNumber.from(2),NaturalNumber.from(3),NaturalNumber.from(1));

        // then
        assertThat(2).isEqualTo(ladder.returnLineMapValue(1,3));
    }
    @Test
    @DisplayName("이미 차지된 포지션에 라인을 그렸을 때 예외가 발생해야 한다.")
    void drawLine_fail_negative(){
        // given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(3));

        // when & then
        assertThatThrownBy(()->ladder.drawLine(NaturalNumber.from(-3),NaturalNumber.from(2),NaturalNumber.from(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이미 차지된 포지션에 라인을 그렸을 때 예외가 발생해야 한다.")
    void drawLine_fail_occupied(){
        // given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(3));
        ladder.drawLine(NaturalNumber.from(2),NaturalNumber.from(3),NaturalNumber.from(1));

        // when & then
        assertThatThrownBy(()->ladder.drawLine(NaturalNumber.from(3),NaturalNumber.from(2),NaturalNumber.from(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("line을 그리지 않고 run을 돌렸을 때 선택한 사다리가 그대로 출력 되어야 한다.")
    void runNoLine(){
        // given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(3));

        // when
        // 라인 안그렸을 때 -> 그대로 나와야 함

        // then
        assertThat(2).isEqualTo(ladder.run(NaturalNumber.from(2)));
    }

    @Test
    @DisplayName("line을 하나 그린 후 run을 돌렸을 때 line을 이동하여 그대로 출력 되어야 한다.")
    void runOneLine(){
        // given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(3));

        // when
        ladder.drawLine(NaturalNumber.from(2),NaturalNumber.from(3),NaturalNumber.from(1));

        // then
        assertThat(2).isEqualTo(ladder.run(NaturalNumber.from(3)));
    }

    @Test
    @DisplayName("line을 두 개 그린 후 run을 돌렸을 때 line을 이동하여 그대로 출력 되어야 한다.")
    void runTwoLine(){
        // given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(3));

        // when
        ladder.drawLine(NaturalNumber.from(2),NaturalNumber.from(3),NaturalNumber.from(1));
        ladder.drawLine(NaturalNumber.from(1),NaturalNumber.from(3),NaturalNumber.from(2));

        // then
        assertThat(1).isEqualTo(ladder.run(NaturalNumber.from(2)));
    }

    @Test
    @DisplayName("line을 높이만큼 그린 후 run을 돌렸을 때 line을 이동하여 그대로 출력 되어야 한다.")
    void runThreeLine(){
        // given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(3));

        // when
        ladder.drawLine(NaturalNumber.from(2),NaturalNumber.from(3),NaturalNumber.from(1));
        ladder.drawLine(NaturalNumber.from(1),NaturalNumber.from(3),NaturalNumber.from(2));
        ladder.drawLine(NaturalNumber.from(1),NaturalNumber.from(2),NaturalNumber.from(3));

        // then
        assertThat(2).isEqualTo(ladder.run(NaturalNumber.from(2)));
    }
}