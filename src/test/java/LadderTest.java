import ladder.creator.LadderCreator;
import ladder.creator.NormalLadderCreator;
import ladder.creator.RandomLadderCreator;
import ladder.model.GreaterThanOne;
import ladder.LadderGame;
import ladder.model.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest { // 사다리 동작 확인

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new NormalLadderCreator(GreaterThanOne.from(2), numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경계값 테스트")
    void testLadderBoundary() {
        GreaterThanOne row = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new NormalLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        Position nthOfPerson = Position.from(0);
        assertThat(ladderGame.run(nthOfPerson)).isEqualTo(0);

        nthOfPerson = Position.from(2);
        assertThat(ladderGame.run(nthOfPerson)).isEqualTo(2);
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        //when
        GreaterThanOne row = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new NormalLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(1));
        ladderCreator.drawLine(Position.from(2), Position.from(0));

        //given
        Position nthOfPerson = Position.from(0);

        //then
        assertThat(ladderGame.run(nthOfPerson)).isEqualTo(2);

        //given
        nthOfPerson = Position.from(1);

        //then
        assertThat(ladderGame.run(nthOfPerson)).isEqualTo(1);

        //given
        nthOfPerson = Position.from(2);

        //then
        assertThat(ladderGame.run(nthOfPerson)).isEqualTo(0);
    }

    @Test
    @DisplayName("사다리 출력 확인")
    public void testLadderPrint() throws Exception {
        //given
        GreaterThanOne row = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new NormalLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(1));
        ladderCreator.drawLine(Position.from(2), Position.from(0));
        //when
        ladderGame.runWithPrint(Position.from(0));
        //then

    }


    @Test
    @DisplayName("RandomLadderCreator 생성 및 정상 동작 테스트")
    void testRandomLadderCreatorRuns() {
        GreaterThanOne row = GreaterThanOne.from(5);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderCreator ladderCreator = new RandomLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        // 모든 유효한 position에서 예외 없이 동작해야 함
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            Position position = Position.from(i);
            // 그냥 실행해서 예외가 발생하지 않음을 확인
            int result = ladderGame.run(position);
            assertTrue(result >= 0 && result < numberOfPerson.getNumber());
        }
    }

    @Test
    @DisplayName("RandomLadderCreator: 잘못된 사람 위치 입력시 예외 발생")
    void testRandomLadderCreatorThrowsOnInvalidPerson() {
        GreaterThanOne row = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(2);
        LadderCreator ladderCreator = new RandomLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        Position invalidPosition = Position.from(3);
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run(invalidPosition));
    }


}