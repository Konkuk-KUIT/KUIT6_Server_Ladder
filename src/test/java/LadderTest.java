import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("[1, 1]과 [1, 2] 사이에 줄을 그으면 [1, 1]은 1, [1, 2]는 -1를 반환한다.")
    void drawLine() throws Exception {
        //given
        Ladder ladder = Ladder.createSeveralLineLadder(2, 4);
        
        //when
        ladder.drawLine(1, 1);
        
        //then
        assertThat(ladder.getRows(1, 1)).isEqualTo(1);
        assertThat(ladder.getRows(1,2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("가로가 1일 때 2를 입력하면 2가 나온다.")
    void run_initial () throws Exception {
        //given
        Ladder ladder = Ladder.createOneLineLadder( 3);

        //when & then
        assertThat(ladder.run(2)).isEqualTo(2);
    }

    @Test
    @DisplayName("[1,1], [2,3], [3,2]에 줄을 그으면 1을 택했을 때 3이 나온다.")
    void run () throws Exception {
        //given
        Ladder ladder = Ladder.createSeveralLineLadder(4, 5);

        //when
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 3);
        ladder.drawLine(3, 2);

        //then
        assertThat(ladder.run(1)).isEqualTo(3);
    }

    @Test
    @DisplayName("[2,3], [3,2]에 줄을 그으면 1을 택했을 때 1이 나온다.")
    void run_no_line () throws Exception {
        //given
        Ladder ladder = Ladder.createSeveralLineLadder(4, 5);

        //when
        ladder.drawLine(2, 3);
        ladder.drawLine(3, 2);

        //then
        assertThat(ladder.run(1)).isEqualTo(1);
    }

    @Test
    @DisplayName("연속으로 줄을 그을 때 에러가 발생한다.")
    void drawLine_a_row () throws Exception {
        //given
        Ladder ladder = Ladder.createSeveralLineLadder(2, 4);

        //when
        ladder.drawLine(1, 1);

        //then
        assertThatThrownBy(() -> ladder.drawLine(1, 2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 position에 줄을 그을 때 에러가 발생한다.")
    void drawLine_last () throws Exception {
        //given
        Ladder ladder = Ladder.createSeveralLineLadder(2, 4);

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(1, 3)).isInstanceOf(IllegalArgumentException.class);
    }

}