import ladder.Creator.AutoFixedLadderCreator;
import ladder.Creator.AutoLadderCreator;
import ladder.Creator.NormalLadderCreator;
import ladder.GreaterThanOne;
import ladder.LadderGame;
import ladder.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderCreatorTest {

    @Test
    @DisplayName("사다리 자동생성(고정개수) 확인")
    void testCreateLadderInAuto() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
//테스트 커버리지 기능 사용
        //when
        AutoLadderCreator ladderCreator = new AutoLadderCreator(numberOfRow, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);
        //then
        assertThat(ladderGame.run(Position.from(0))).isNotNull();
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    @DisplayName("사다리 자동생성(고정확률) 확인")
    void testCreateLadderInAutoFixed() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        AutoFixedLadderCreator ladderCreator = new AutoFixedLadderCreator(numberOfRow, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);
        //then
        assertThat(ladderGame.run(Position.from(0))).isNotNull();
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    @DisplayName("사다리 직접생성 확인")
    void testCreateLadderInNormal() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        NormalLadderCreator ladderCreator = new NormalLadderCreator(numberOfRow, numberOfPerson);
        ladderCreator.drawLine(Position.from(0), Position.from(0));

        LadderGame ladderGame = new LadderGame(ladderCreator);
        //then
        assertThat(ladderGame.run(Position.from(0))).isNotNull();
        assertThat(ladderCreator).isNotNull();
    }
  
}