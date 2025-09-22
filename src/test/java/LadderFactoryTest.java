import ladder.GreaterThanOne;
import ladder.LadderGame;
import ladder.LadderGameFactory;
import ladder.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderFactoryTest {


    @Test
    @DisplayName("사다리 '랜덤자동' 생성 확인")
    void testCreateLadderByAutoInFactory() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame ladderGame = LadderGameFactory.auto(numberOfRow, numberOfPerson);

        //then
        ladderGame.run(Position.from(0));
    }

    @Test
    @DisplayName("사다리 '랜덤자동' 생성 확인")
    void testCreateLadderByNormalInFactory() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame ladderGame = LadderGameFactory.normal(numberOfRow, numberOfPerson);

        //then
        ladderGame.run(Position.from(0));
    }

    @Test
    @DisplayName("사다리 '랜덤자동' 생성 확인")
    void testCreateLadderByAutoFixedInFactory() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame ladderGame = LadderGameFactory.autoFixed(numberOfRow, numberOfPerson);

        //then
        ladderGame.run(Position.from(0));
    }
}
