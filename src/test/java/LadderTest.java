import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(1);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //given
        int nthOfPerson = 4;

        //then
        assertThatThrownBy(() -> ladder.run(nthOfPerson))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        Ladder ladder = new Ladder(row, numberOfPerson);

        ladder.drawLine(0,0);
        ladder.drawLine(1,1);
        ladder.drawLine(2,0);

        //given
        int nthOfPerson = 0;

        //then
        assertThat(ladder.run(nthOfPerson)).isEqualTo(2);

        //given
        nthOfPerson = 1;

        //then
        assertThat(ladder.run(nthOfPerson)).isEqualTo(1);

        //given
        nthOfPerson = 2;

        //then
        assertThat(ladder.run(nthOfPerson)).isEqualTo(0);
    }
    @Test
    @DisplayName("점을 찍어 출력합니다.")
    void testDrawLadder() {
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        GreaterThanOne row = GreaterThanOne.from(4);

        Ladder ladder = new Ladder(row, numberOfPerson);
        ladder.clearAllLines();

        ladder.drawLine(0,0);
        ladder.drawLine(1,1);
        ladder.drawLine(2,2);

        //LadderViewer ladderViewer = new LadderViewer();
        //LadderRunner ladderRunner = new LadderRunner(ladder,ladderViewer);

        ladder.run(0);
    }
}