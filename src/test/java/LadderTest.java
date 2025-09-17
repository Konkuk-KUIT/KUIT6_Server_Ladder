import exception.IllegalHeightException;
import exception.IllegalLadderNumberException;
import exception.IllegalLinerException;
import exception.IllegalSequenceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("인원수가 1인 사다리 타기의 결과는 1이다.")
    void long_single_ladder_run(){
        // given
        Liner liner = new Liner(5,1);
        Ladder ladder = Ladder.from(liner);
        LadderGame ladderGame = new LadderGame(ladder);

        // when & then
        assertThat(ladderGame.run(1)).isEqualTo(1);
    }

    @Test
    @DisplayName("올바르지 않은 조건으로 라이너를 만들시 IllegalLinerException 발생한다.")
    void illegal_liner(){

        // when & then
        assertThatThrownBy(()->new Liner(-5,3)).isInstanceOf(IllegalLinerException.class);
    }

    @Test
    @DisplayName("올바르지 않은 순서로 라인을 만들시 IllegalSequenceException 발생한다.")
    void illegal_sequence(){
        // given
        Liner liner = new Liner(5,3);
        Ladder ladder = Ladder.from(liner);

        // when & then
        assertThatThrownBy(()->ladder.drawLine(3,1,1)).isInstanceOf(IllegalSequenceException.class);
    }

    @Test
    @DisplayName("이미 그려진 라인 바로 옆에 라인을 만들시 IllegalHeightException 발생한다.")
    void illegal_height(){
        // given
        Liner liner = new Liner(5,3);
        Ladder ladder = Ladder.from(liner);
        ladder.drawLine(1,2,1); // 1층에 1과 2를 연결

        // when & then
        assertThatThrownBy(()->ladder.drawLine(2,3,1)).isInstanceOf(IllegalHeightException.class);
    }

    @Test
    @DisplayName("존재하지 않는 사다리번호로 게임을 실행할시 IllegalLadderNumException 발생한다.")
    void illegal_ladder_game(){
        // given
        Liner liner = new Liner(5,3);
        Ladder ladder = Ladder.from(liner);
        LadderGame ladderGame = new LadderGame(ladder);

        // when & then
        assertThatThrownBy(()->ladderGame.run(5)).isInstanceOf(IllegalLadderNumberException.class);
    }

    @Test
    @DisplayName("1번과 2번 사다리를 한 번 교차시킨 사디리의 결과는, 1번 사다리를 타면 2번 사다리로 끝나며 2번 사다리를 탈 경우 1번 사다리로 끝난다.")
    void double_ladder_run_1(){
        // given
        Liner liner = new Liner(5,2);
        Ladder ladder = Ladder.from(liner);
        ladder.drawLine(1,2,3);
        LadderGame ladderGame = new LadderGame(ladder);

        // when & then
        assertThat(ladderGame.run(1)).isEqualTo(2);
        assertThat(ladderGame.run(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("1번과 2번 사다리를 한 번 교차시킨 후 2번과 3번을 연결한 사디리의 결과는, 1번 사다리를 타면 3번 사다리로 끝난다.")
    void double_ladder_run_3(){
        // given
        Liner liner = new Liner(5,3);
        Ladder ladder = Ladder.from(liner);
        ladder.drawLine(1,2,1);
        ladder.drawLine(2,3,4);
        LadderGame ladderGame = new LadderGame(ladder);

        // when & then
        assertThat(ladderGame.run(1)).isEqualTo(3);
        assertThat(ladderGame.run(2)).isEqualTo(1);
        assertThat(ladderGame.run(3)).isEqualTo(2);
    }
}